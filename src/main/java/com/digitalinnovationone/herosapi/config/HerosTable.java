package com.digitalinnovationone.herosapi.config;


import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

import java.util.Arrays;

import static com.digitalinnovationone.herosapi.constants.HeroesConstant.DYNAMO_END_POINT;
import static com.digitalinnovationone.herosapi.constants.HeroesConstant.DYNAMO_REGION;


@Configuration
@EnableDynamoDBRepositories
public class HerosTable {

    public static void main(String[] args) throws Exception {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(DYNAMO_END_POINT, DYNAMO_REGION))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName= "Heroes_Table";

        try {
            Table table = dynamoDB.createTable(tableName,
                    Arrays.asList(new KeySchemaElement("id", KeyType.HASH)),
                    Arrays.asList(new AttributeDefinition("id", ScalarAttributeType.S)),
                    new ProvisionedThroughput(5L, 5L));
                    table.waitForActive();



        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }


    }


}
