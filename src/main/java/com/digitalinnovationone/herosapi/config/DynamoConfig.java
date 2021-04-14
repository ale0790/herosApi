package com.digitalinnovationone.herosapi.config;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.apache.commons.lang3.StringUtils;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableDynamoDBRepositories
public class DynamoConfig {

    @Value("${amazon.dynamobd.endpoint}")
    private String amazonDynamoDBEndPoint;

    @Value("${aws_access_key_id}")
    private String amazonAwsAcessKey;

    @Value("${aws_secret_access_key}")
    private String amazonAwsSecretAcessesKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB(){
        AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAwsCredentials());
        if(!StringUtils.isEmpty(amazonDynamoDBEndPoint)){
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndPoint);
        }
        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentials amazonAwsCredentials(){
        return new BasicAWSCredentials(amazonAwsAcessKey, amazonAwsSecretAcessesKey);
    }

}
