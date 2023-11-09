
<#macro writeAttrField field>
  <#if field.functionByType??>
    <#if field.defaultValue?is_number>
      <#if field.functionByType == "decimalType">
        ${field.fieldType} ${field.name} = new BigDecimal("${field.defaultValue?c}");
      <#else>
        ${field.fieldType} ${field.name} = ${field.defaultValue?c}<#if field.suffixValue?has_content && field.suffixValue == "L">L</#if>;
      </#if>
    <#elseif field.defaultValue?is_boolean>
      ${field.fieldType} ${field.name} = ${field.defaultValue?then('true', 'false')};
    <#elseif field.functionByType == "date">
      ${field.fieldType} ${field.name} = Date.from(Instant.parse("${field.defaultValue}"));
    <#elseif field.functionByType == "datetime" && field.formatValue?has_content>
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
    <#elseif type == "dateValue">
      <#return 'Date.from(Instant.parse(\"${value}\"))'?no_esc/>
    <#elseif type == "datetimeValue" && format?has_content>
      <#return 'ZonedDateTime.parse("${value?datetime}", DateTimeFormatter.ofPattern("${format?no_esc}")'?no_esc/>
    <#elseif type != "dateValue" && type != "datetimeValue">
      <#return '\"${value?j_string}\"'?no_esc/>
    </#if>
</#function>

<#macro writeSetterField field builderName>
<#if field.functionByType??>
  public ${builderName}Builder set${field.name?cap_first}(final ${field.fieldType?no_esc} ${field.name}) {
<#elseif field.complexType??>
<#if field.complexType.name() == "COLLECTION">
  public ${builderName}Builder set${field.name?cap_first}(final ${field.fieldType?no_esc} ${field.name}) {
<#elseif field.needBuilder>
  public ${builderName}Builder set${field.name?cap_first}(final ${field.fieldType?no_esc}Builder ${field.name}) {
<#else >
  public ${builderName}Builder set${field.name?cap_first}(final ${field.fieldType?no_esc} ${field.name}) {
</#if>
<#else>
  public ${builderName}Builder set${field.name?cap_first}(final ${field.fieldType?no_esc} ${field.name}) {
</#if>
    this.${field.name} = ${field.name};
    return this;
  }
</#macro>

<#function writeDefaultsList fieldList>
    <#list fieldList as internalField>
        ${writeRightValue(internalField.defaultValue, internalField.functionByType, internalField.format)}<#if internalField?is_last>, </#if>
    </#list>
</#function>

<#macro writeComplexAttrField complexField>
    <#if complexField.complexType.name() == "COLLECTION">
    ${complexField.fieldType?no_esc} ${complexField.name} = List.of(${writeDefaultsList(complexField.fields)});
    <#elseif complexField.needBuilder>
    ${complexField.fieldType?no_esc}Builder ${complexField.name} = new ${complexField.fieldType?no_esc}Builder();
    <#else >
    ${complexField.fieldType?no_esc} ${complexField.name};
    </#if>

</#macro>

<#macro writeBuilderField field>
  <#if field.functionByType??>
    <#if field.name?has_content>
      if (Objects.nonNull(${field.name})) {
        <#if field.formatValue??>
         <#if field.functionByType != "datetime">
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

<#macro writeBuilderLambdaField fieldList>
  PactDslJsonRootValue
  <#list fieldList as internalField>
    <#if internalField.functionByType??>
      <#if internalField.name?has_content>
        if (Objects.nonNull(${internalField.name})) {
          <#if internalField.formatValue??>
            <#if internalField.functionByType != "date" && internalField.functionByType != "datetime">
              .${internalField.functionByType}("${internalField.name}", "${internalField.formatValue?no_esc}", ${internalField.name})
            <#else>
              .${internalField.functionByType}("${internalField.name}", "${internalField.formatValue?no_esc}", ${internalField.name}.toInstant())
            </#if>
          <#else>
            .${internalField.functionByType}("${internalField.name}", ${internalField.name})
          </#if>
        }
      <#else>
        <#if internalField.formatValue??>
          <#if internalField.functionByType == "dateValue">
            .date("${internalField.formatValue?no_esc}", ${writeRightValue(internalField.defaultValue, internalField.functionByType)})
          <#elseif internalField.functionByType == "datetimeValue">
            .datetime("${internalField.formatValue?no_esc}", ${writeRightValue(internalField.defaultValue, internalField.functionByType)})
          <#elseif internalField.functionByType == "integerValue">
            .integerType("${internalField.formatValue?no_esc}",${writeRightValue(internalField.defaultValue, internalField.functionByType)})
          <#elseif internalField.functionByType == "decimalValue">
            .decimalType("${internalField.formatValue?no_esc}", ${writeRightValue(internalField.defaultValue, internalField.functionByType)})
          </#if>
        <#elseif internalField.defaultValue?is_number>
          <#if internalField.functionByType == "dateValue">
            .date(${writeRightValue(internalField.defaultValue, internalField.functionByType)})
          <#elseif internalField.functionByType == "datetimeValue">
            .datetime(${writeRightValue(internalField.defaultValue, internalField.functionByType)})
          <#elseif internalField.functionByType == "integerValue">
            .integerType(${writeRightValue(internalField.defaultValue, internalField.functionByType)})
          <#elseif internalField.functionByType == "decimalValue">
            .decimalType(${writeRightValue(internalField.defaultValue, internalField.functionByType)})
            </#if>
          <#elseif internalField.functionByType == "stringValue" >
          .stringType(${writeRightValue(internalField.defaultValue, internalField.functionByType)})
          <#else >
          .${internalField.functionByType}(${writeRightValue(internalField.defaultValue, internalField.functionByType)})
        </#if>
      </#if>
    </#if>
  </#list>
</#macro>

<#macro writeBuilderComplexField complexField>
  <#if complexField.complexType.name() == "COLLECTION">
      <#if complexField.fieldValidations??>
          <#if complexField.fieldValidations.randomSize??>
                <#assign randomSize = "${complexField.fieldValidations.randomSize}"/>
          <#else >
                <#assign randomSize = ""/>
          </#if>
          <#if complexField.fieldValidations.max??>
              <#assign max = "${complexField.fieldValidations.max}"/>
          <#else >
              <#assign max = ""/>
          </#if>
          <#if complexField.fieldValidations.min??>
              <#assign min = "${complexField.fieldValidations.min}"/>
          <#else >
              <#assign min = ""/>
          </#if>
  <#if max?has_content && min?has_content>
    if (${complexField.name}.isEmpty()) {
      pactDslJsonBody.minMaxArrayLike("${complexField.name}", ${min}, ${max});
    } else {
      pactDslJsonBody.minMaxArrayLike("${complexField.name}", ${min}, ${max}, <@writeBuilderLambdaField fieldList=complexField.fields/>, ${randomSize});
    }
  <#elseif min?has_content>
    if (${complexField.name}.isEmpty()) {
      pactDslJsonBody.minArrayLike("${complexField.name}", ${min});
    } else {
      pactDslJsonBody.minArrayLike("${complexField.name}", ${min}, <@writeBuilderLambdaField fieldList=complexField.fields/>, ${randomSize});
    }
  <#elseif max?has_content>
    if (${complexField.name}.isEmpty()) {
      pactDslJsonBody.maxArrayLike("${complexField.name}", ${max});
    } else {
      pactDslJsonBody.maxArrayLike("${complexField.name}", ${max}, <@writeBuilderLambdaField fieldList=complexField.fields/>, ${randomSize});
    }
    <#else >
    pactDslJsonBody.eachLike("${complexField.name}", <@writeBuilderLambdaField fieldList=complexField.fields/>, 1);
    </#if>
  <#else>
    pactDslJsonBody.array("${complexField.name}");
      <#list complexField.fields as internalField>
          <@writeBuilderField field=internalField/>
      </#list>
    pactDslJsonBody.closeArray();
  </#if>
  <#elseif complexField.needBuilder>
  pactDslJsonBody.object("${complexField.name}", ${complexField.name}.build());
  pactDslJsonBody.closeObject();
  <#else>
  <@writeBuilderField field=complexField/>
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
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

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

        <#-- if schema.customModifiers??>
        try {
            applyCustomModifiers(pactDslJsonBody);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
        </#if -->
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

