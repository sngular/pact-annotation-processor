
<#macro writeAttrField field>
  <#if field.functionByType??>
    <#if field.defaultValue?is_number>
      <#if field.functionByType == "decimalType">
        ${field.fieldType} ${field.name} = new BigDecimal("${field.defaultValue?c}");
      <#else>
        ${field.fieldType} ${field.name} = ${field.defaultValue?c};
      </#if>
    <#elseif field.defaultValue?is_boolean>
      ${field.fieldType} ${field.name} = ${field.defaultValue?then('true', 'false')};
    <#elseif field.functionByType == "date">
      ${field.fieldType} ${field.name} = LocalDate.parse("${field.defaultValue?date}"));
    <#elseif field.functionByType == "datetime" && field.formatValue?has_content>
      //"${field.defaultValue}"
      ${field.fieldType} ${field.name} = ZonedDateTime.parse("${field.defaultValue?j_string?no_esc}",  DateTimeFormatter.ofPattern("${field.formatValue?no_esc}"));
    <#elseif field.functionByType != "date" && field.functionByType != "datetime">
      ${field.fieldType} ${field.name} = "${field.defaultValue}";
    </#if>
  <#else>
  <@writeComplexAttrField complexField=field/>
  </#if>
</#macro>

<#function writeRightValue value type format="">
    <#if value?is_number>
      <#return value?c/>
    <#elseif value?is_boolean>
      <#return value?then('true', 'false')/>
    <#elseif type == "date">
      <#return 'LocalDate.parse("${value?date}")'?j_string/>
    <#elseif type == "datetime" && format?has_content>
      <#return 'ZonedDateTime.parse("${value?datetime}", DateTimeFormatter.ofPattern("${format?no_esc}")'?no_esc/>
    <#elseif type != "date" && type != "datetime">
      <#return value?string/>
    </#if>

</#function>

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

<#macro writeBuilderField field>
  <#if field.functionByType??>
    <#if field.name?has_content>
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
    <#else>
      <#if field.formatValue??>
        <#if field.functionByType == "dateValue">
          pactDslJsonBody.eachLike(PactDslJsonRootValue.date("${field.formatValue?no_esc}", Date.from(Instant.now())));
        <#elseif field.functionByType == "datetimeValue">
          pactDslJsonBody.eachLike(PactDslJsonRootValue.datetime("${field.formatValue?no_esc}", ZonedDateTime.now()));
        <#elseif field.functionByType == "integerValue">
          pactDslJsonBody.eachLike(PactDslJsonRootValue.integerMatching("${field.formatValue?no_esc}", ${field.defaultValue?int});
        <#elseif field.functionByType == "decimalValue">
          pactDslJsonBody.eachLike(PactDslJsonRootValue.decimalMatching("${field.formatValue?no_esc}", ${field.defaultValue?float});
        </#if>
      </#if>
    </#if>
  </#if>
</#macro>

<#macro writeBuilderComplexField complexField>
  <#if complexField.complexType.name() == "COLLECTION">
  if (!${complexField.name}.isEmpty()) {
    pactDslJsonBody.array("${complexField.name}");
      <#list complexField.fields as internalField>
          <@writeBuilderField field=internalField/>
      </#list>
    pactDslJsonBody.closeArray();
  }
  <#else>
  pactDslJsonBody.object("${complexField.name}", ${complexField.name}.build());
  pactDslJsonBody.closeObject();
  </#if>

</#macro>

package ${schema.modelPackage};

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslJsonRootValue;
<#if schema.customModifiers??>
import com.sngular.annotation.processor.mapping.CustomDslModifier;
</#if>
import java.util.Objects;
import java.util.Date;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

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

    public DslPart build() {
        PactDslJsonBody pactDslJsonBody = new PactDslJsonBody();
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

    <#if schema.customModifiers??>
    private static void applyCustomModifiers(PactDslJsonBody pactDslJsonBody) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        <#list schema.customModifiers as customMod>
            ((CustomDslModifier) Class.forName("${customMod}").newInstance()).apply(pactDslJsonBody);
        </#list>
    }
    </#if>

}

