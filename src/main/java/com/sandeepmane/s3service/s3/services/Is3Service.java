package com.sandeepmane.s3service.s3.services;

import java.util.List;

import com.amazonaws.services.s3.model.S3Object;

public interface Is3Service {
    
    public List<S3Object> getImages();

}