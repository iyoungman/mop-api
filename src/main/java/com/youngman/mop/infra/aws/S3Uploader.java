package com.youngman.mop.infra.aws;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-07-17.
 */

@Slf4j
@RequiredArgsConstructor
@Component
public class S3Uploader {

	private final AmazonS3Client amazonS3Client;

	@Value("${cloud.aws.s3.bucket}")
	private String bucket;

	@Value("${cloud.aws.s3.dirName}")
	private String dirName;


	public String uploadFile(MultipartFile multipartFile, String fileName) {
		if (StringUtils.isEmpty(multipartFile.getOriginalFilename())) {
			throw new IllegalArgumentException("올바르지 않은 파일입니다");
		}

		try {
			fileName = dirName + "/" + fileName;
			return putS3(multipartFile.getInputStream(), fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> uploadFiles(List<MultipartFile> multipartFiles) {
		List<String> putUris = new ArrayList<>();

		multipartFiles.stream()
				.filter(multipartFile -> !StringUtils.isEmpty(multipartFile.getOriginalFilename()))
				.forEach(multipartFile -> {
					try {
						putUris.add(putS3(multipartFile.getInputStream(), multipartFile.getOriginalFilename()));
					} catch (IOException e) {
						e.printStackTrace();
					}
				});

		return putUris;
	}

	private String putS3(InputStream inputStream, String fileName) {
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, fileName, inputStream, setObjectMetadata(fileName));
		putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead);
		PutObjectResult putObjectResult = amazonS3Client.putObject(putObjectRequest);
		IOUtils.closeQuietly(inputStream);

		return amazonS3Client.getUrl(bucket, fileName).toString();
	}

	private ObjectMetadata setObjectMetadata(String fileName) {
		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentType("text/plain");
		objectMetadata.setContentDisposition(fileName);
		return objectMetadata;
	}

	public List<S3ObjectSummary> fetchFiles() {
		ObjectListing objectListing = amazonS3Client.listObjects(new ListObjectsRequest().withBucketName(bucket));
		List<S3ObjectSummary> s3ObjectSummaries = objectListing.getObjectSummaries();
		return s3ObjectSummaries;
	}


}
