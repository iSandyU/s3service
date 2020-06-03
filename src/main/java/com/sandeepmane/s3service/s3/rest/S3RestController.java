package com.sandeepmane.s3service.s3.rest;

import java.util.List;

import com.amazonaws.services.s3.model.S3Object;
import com.sandeepmane.s3service.s3.services.S3Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S3RestController {
    
    
    @Autowired
    private S3Service s3Service ;

    @RequestMapping("/images")
    public List<S3Object> getImages()
    {

        
        return s3Service.getImages();
    }

    

}