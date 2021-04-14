package com.digitalinnovationone.herosapi.config;


import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Configuration;
import static com.digitalinnovationone.herosapi.constants.HeroesConstant.DYNAMO_END_POINT;
import static com.digitalinnovationone.herosapi.constants.HeroesConstant.DYNAMO_REGION;


@Configuration
@EnableDynamoDBRepositories
public class HerosData {

    public static void main(String[] args) throws Exception {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(DYNAMO_END_POINT, DYNAMO_REGION))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);


            Table table = dynamoDB.getTable("Heroes_Table");

            Item hero = new Item()
                    .withPrimaryKey("id", "1")
                    .withString("name", "Mulher maravilha")
                    .withString("universe", "ds comics")
                    .withNumber("films", 3);

        Item hero2 = new Item()
                .withPrimaryKey("id", "2")
                .withString("name", "Viuva negra")
                .withString("universe", "marvel")
                .withNumber("films", 2);

        Item hero3 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "Capita marvel")
                .withString("universe", "marvel")
                .withNumber("films", 5);

            PutItemOutcome outcome = table.putItem(hero);
            PutItemOutcome outcome2 = table.putItem(hero2);
            PutItemOutcome outcome3 = table.putItem(hero3);






    }


}
