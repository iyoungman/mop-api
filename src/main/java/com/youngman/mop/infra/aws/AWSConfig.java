package com.youngman.mop.infra.aws;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by YoungMan on 2019-07-17.
 */

@Configuration
public class AWSConfig {

//	@Value("${cloud.aws.credentials.accessKey}")
//	private String accessKey;
//
//	@Value("${cloud.aws.credentials.secretKey}")
//	private String secretKey;

	@Value("${cloud.aws.region.static}")
	private String region;


//	@Bean
//	public BasicAWSCredentials basicAWSCredentials() {
//		return new BasicAWSCredentials(accessKey, secretKey);
//	}

	@Bean
	public AmazonS3Client amazonS3Client() {
//		AmazonS3Client amazonS3Client = new AmazonS3Client(basicAWSCredentials());
		AmazonS3Client amazonS3Client = new AmazonS3Client();
		amazonS3Client.setRegion(Region.getRegion(Regions.fromName(region)));
		return amazonS3Client;
	}
}
