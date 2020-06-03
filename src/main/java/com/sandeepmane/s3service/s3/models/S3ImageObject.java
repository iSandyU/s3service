package com.sandeepmane.s3service.s3.models;

import com.amazonaws.services.s3.model.S3Object;
import com.sandeepmane.s3service.s3.constants.Constants.Orientation;

import lombok.Data;

/**
 * 
 * Model to hold s3 relatd information
 */
@Data
public class S3ImageObject extends S3Object{
    
    /**
     * Image Name optional
     */
    private String imgName ;

    /**
     * Image Name FolderName
     */
    private String folder ;


    /**
     * Image Orientation
     */
    private Orientation imgOrientation ;

    /**
     *  S3 Bucket name where image is stored
     */
    private String bucketName;

    /**
     * S3 Path relative to bucket root optional
     */
    private String path;
}