package com.minimi.backend.facility.aws.service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class S3UploadService {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.s3.switchDev}")
    private Boolean devMode;

    private final AmazonS3 amazonS3;


    public List<String> upload(List<MultipartFile> multipartFileList) throws IOException{
        List<String> imagePathList = new ArrayList<>();

        if (devMode) {
            imagePathList.add("devMode IMG Path");
            return imagePathList;
        }

        for (MultipartFile multipartFile: multipartFileList) {
            String s3FileName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();
            Long size = multipartFile.getSize();

            ObjectMetadata objMeta = new ObjectMetadata();
            objMeta.setContentType(multipartFile.getContentType());
            objMeta.setContentLength(multipartFile.getInputStream().available());

            amazonS3.putObject(
                    new PutObjectRequest(bucket, s3FileName, multipartFile.getInputStream(), objMeta)
                            .withCannedAcl(CannedAccessControlList.PublicRead));

            String imgPath = amazonS3.getUrl(bucket, s3FileName).toString();
            imagePathList.add(imgPath);
        }
        return imagePathList;
    }
}
