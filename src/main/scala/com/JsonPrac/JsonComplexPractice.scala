package com.JsonPrac

import org.json.JSONObject

object JsonComplexPractice
{
  def main(args:Array[String]): Unit =
  {
    val inputJson="""{ "orderId": 1, "dateExpiry": null, "dateEffective": "13-Apr-2018 00:00", "ruleThenClause": [ { "channelId": "", "actionName": "Action_3", "enrichData": false, "channelName": "", "gatewayName": "", "actionTypeId": 4, "fieldDetails": [ { "fieldName": "percentwheelbearingoilremaining_red", "fieldType": "string", "fieldValue": "RED" } ], "actionTypeName": "ADD COLUMN", "templateFields": [], "templateHeader": [ { "ccName": "", "ccType": "datasetColumns", "toName": "", "toType": "datasetColumns", "subject": "", "ccEmails": [], "fromName": "", "toEmails": [] } ], "templateContent": "", "actionConfigured": "", "messageTemplateId": "", "messageTemplateName": "" } ], "ruleConditionJSON": { "rules": [ { "id": "percentwheelbearingoilremaining", "data": { "originaltype": "double" }, "type": "double", "field": "percentwheelbearingoilremaining", "input": "number", "value": [ "-10" ], "operator": "less" } ], "valid": true, "condition": "AND" }, "ruleConditionDRLExpression": "(percentwheelbearingoilremaining < -10)" }"""
    val json=new JSONObject(inputJson)
    println(json.get("orderId")+" "+json.get("dateEffective"))
    val ruleThenClause = json.getJSONArray("ruleThenClause")

    println(ruleThenClause.getJSONObject(0).get("actionName"))
    println(ruleThenClause.getJSONObject(0).getJSONArray("fieldDetails").getJSONObject(0))
    println(ruleThenClause.getJSONObject(0).getJSONArray("fieldDetails").getJSONObject(0).get("fieldName"))

  }
}
