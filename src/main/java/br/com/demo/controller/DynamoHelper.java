package br.com.demo.controller;


import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import br.com.demo.to.DataTO;

public class DynamoHelper {
	final static AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.defaultClient();
	final static DynamoDB db = new DynamoDB(ddb);
	
	
	public static DataTO SetEmail(String email){
		ScanRequest scanRequest = new ScanRequest().withTableName("desktop-ctrl");
		ScanResult result = ddb.scan(scanRequest);
		System.out.println(result);
		
		for (Map<String, AttributeValue> item : result.getItems()){
		    if(item.get("email") == null){
		    	System.out.println(item.get("instanceId").getS());
		    	Table table = db.getTable("desktop-ctrl");
		    	
		    	Map<String, String> expressionAttributeNames = new HashMap<String, String>();
				expressionAttributeNames.put("#na", "email");
				UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("instanceId", item.get("instanceId").getS())
				        .withUpdateExpression("set #na = :val1").withNameMap(new NameMap().with("#na", "email"))
				        .withValueMap(new ValueMap().withString(":val1", email)).withReturnValues(ReturnValue.ALL_NEW);
				
				UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
				System.out.println(outcome.getItem().toJSONPretty());
				
				DataTO to = new DataTO();
				to.setUser("Administrator");
				to.setRdp("https://s3.amazonaws.com/escape-room-rdp/" +item.get("desktopName").getS() + ".rdp");
				to.setPasswd(item.get("passwd").getS());
				to.setUrl(item.get("record").getS());
				return to;
		    } else {
		    	System.out.println("tem email...");
		    }
		}
		
		return null;
	}

}
