<#macro writeField field isLast>
  <#if field.functionByType??>
        .${field.functionByType}(<#if !field.onlyValueFunction>"${field.name}",</#if> <#if field.formatValue??>"${field.formatValue?no_esc}"</#if> <#if field.defaultValue?is_number>${field.defaultValue?string.c}<#elseif field.defaultValue?is_boolean>${field.defaultValue?then('true', 'false')}<#elseif field.functionByType != "date" && field.functionByType != "datetime">"${field.defaultValue}"</#if>${field.suffixValue})
  <#else>
        <@writeComplexField complexField=field isLast=isLast/>
  </#if>
</#macro>

<#macro writeAttrField field>
  <#if field.functionByType??>
  ${field.fieldType} ${field.name} = ${field.defaultValue};
  <#else>
  <@writeComplexAttrField complexField=field/>
  </#if>
</#macro>

<#macro writeSetterField field builderName>
<#if field.functionByType??>
  public ${builderName}Builder set${field.name?cap_first}(final ${field.fieldType?no_esc} ${field.name}) {
<#elseif field.complexType??>
<#if field.complexType.name() == "COLLECTION">
  public ${builderName}Builder set${field.name?cap_first}(final ${field.fieldType?no_esc} ${field.name}) {
<#else>
  public ${builderName}Builder set${field.name?cap_first}(final ${field.fieldType?no_esc}Builder ${field.name}) {
</#if>
<#else>
  public ${builderName}Builder set${field.name?cap_first}(final ${field.fieldType?no_esc} ${field.name}) {
</#if>
    this.${field.name} = ${field.name};
    return this;
  }

</#macro>

<#macro writeComplexAttrField complexField>
    <#if complexField.complexType.name() == "COLLECTION">
    ${complexField.fieldType?no_esc} ${complexField.name} = new java.util.ArrayList();
    <#else>
    ${complexField.fieldType?no_esc}Builder ${complexField.name};
    </#if>

</#macro>

<#macro writeComplexField complexField isLast>
    <#if complexField.complexType.name() == "COLLECTION">
    .array("${complexField.name}")
    <#else>
    .object("${complexField.name}")
    </#if>
    <#list complexField.fields as internalField>
      <@writeField field=internalField isLast=internalField?is_last/>
    </#list>
    <#if complexField.complexType.name() == "COLLECTION">
    .closeArray()
    <#else>
    .closeObject()
    </#if>
</#macro>

<#macro writeBuilderField field>
  <#if field.functionByType??>
    if (Objects.nonNull(${field.name})) {
      <#if field.formatValue??>
       <#if field.functionByType != "date" && field.functionByType != "datetime">
        pactDslJsonBody.${field.functionByType}("${field.name}", "${field.formatValue?no_esc}", ${field.name});
       <#else>
        pactDslJsonBody.${field.functionByType}("${field.name}", "${field.formatValue?no_esc}", ${field.name}.toInstant());
       </#if>
      <#else>
        pactDslJsonBody.${field.functionByType}("${field.name}", ${field.name});
      </#if>
    }
  </#if>
</#macro>

<#macro writeBuilderComplexField complexField>
  <#if complexField.complexType.name() == "COLLECTION">
  if (!${complexField.name}.isEmpty()) {
    .array("${complexField.name}")
      <#list complexField.fields as internalField>
          <@writeBuilderField field=internalField/>
      </#list>
    .closeArray()
  }
  <#else>
  pactDslJsonBody.object("${complexField.name}");
  ${complexField.name}.build(pactDslJsonBody);
  pactDslJsonBody.closeObject();
  </#if>

</#macro>

package ${schema.modelPackage};

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
<#if schema.customModifiers??>
import com.sngular.annotation.processor.mapping.CustomDslModifier;
</#if>
import java.util.Objects;

<#function complex(field)>
  <#return field.functionByType??>
</#function>

<#function nocomplex(field)>
  <#if field.functionByType??>
    <#return false>
  <#else>
    <#return true>
  </#if>
</#function>

public class ${schema.className}Builder {
    <#list schema.fieldList as field>
    <@writeAttrField field=field/><#if field?is_last>;</#if>
    </#list>

    <#list schema.fieldList as field>
    <@writeSetterField field=field builderName=schema.className?cap_first/>
    </#list>

    public DslPart build(final PactDslJsonBody pactDslJsonBody) {

        <#list schema.fieldList?filter(complex) as field><@writeBuilderField field=field/></#list>
        <#list schema.fieldList?filter(nocomplex) as field><@writeBuilderComplexField complexField=field /></#list>

        <#if schema.customModifiers??>
        try {
            applyCustomModifiers(pactDslJsonBody);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
        </#if>
        return pactDslJsonBody;
    }

    public static DslPart defaultBuild() {
        PactDslJsonBody pactDslJsonBody = new PactDslJsonBody();
        pactDslJsonBody
        <#list schema.fieldList?filter(complex) as field><@writeField field=field isLast=field?is_last/></#list>
        <#list schema.fieldList?filter(nocomplex) as field><@writeComplexField complexField=field isLast=field?is_last/></#list>
        ;
        <#if schema.customModifiers??>
        try {
            applyCustomModifiers(pactDslJsonBody);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
        </#if>
        return pactDslJsonBody;
    }

    <#if schema.customModifiers??>
    private static void applyCustomModifiers(PactDslJsonBody pactDslJsonBody) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        <#list schema.customModifiers as customMod>
            ((CustomDslModifier) Class.forName("${customMod}").newInstance()).apply(pactDslJsonBody);
        </#list>
    }
    </#if>

}

