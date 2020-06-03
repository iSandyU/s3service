package com.sandeepmane.s3service.s3.services;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class S3Service implements Is3Service {

    private AmazonS3 s3Client;

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String accessSecret;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${s3.bucket.name}")
    private String bucketName;

    @Override
    public List<S3Object> getImages() {

        ObjectListing bucketList = null;

        System.out.println("***********");

        System.out.println("AccessKey:" + accessKey);

        System.out.println("***********");

        AWSCredentials credentials = new BasicAWSCredentials(accessKey, accessSecret);

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(region).build();

        System.out.println("Client is:" + s3Client.getRegionName());

        bucketList = s3Client.listObjects(bucketName);

        List<S3ObjectSummary> summaryList = bucketList.getObjectSummaries();

        List<S3Object> s3ImageList = new ArrayList();
        S3Object newImage = null;
        for (S3ObjectSummary s3ObjectSummary : summaryList) {

            /* if(s3ObjectSummary.getKey().contains("Images"))
            { */
               // s3Client.listObjects(bucketName)
               System.out.println("###################");
               System.out.println("Key is:"+s3ObjectSummary.getKey());
                //newImage = new S3ImageObject();
                newImage = s3Client.getObject(s3ObjectSummary.getBucketName(), s3ObjectSummary.getKey());
                //newImage.setFolder(s3ObjectSummary.getKey());
                //newImage.setBucketName(s3ObjectSummary.getBucketName());
                s3ImageList.add(newImage);

                
            //}
            
        }

        return s3ImageList;
    }

}
