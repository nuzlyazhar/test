package com.excelian.diginexserver.service;

import com.excelian.diginexserver.config.ApplicationProperties;
import com.excelian.diginexserver.domain.Image;
import org.openapitools.client.ApiClient;
import org.openapitools.client.api.DocumentImagesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DocumentService {

    private ApplicationProperties appProperties;
    private DocumentImagesApi api;

    private static String DATA = "data";
    private static String DOCUMENT_CATEGORY = "document_category";
    private static String DOCUMENT_TYPE = "document_type";
    private static String IMAGE_TYPE = "image_type";

    @Autowired
    public DocumentService(ApplicationProperties applicationProperties) {
        this.appProperties = applicationProperties;
        this.api = new ApiClient(appProperties.getAuthName(),appProperties.getApiKey()).buildClient(DocumentImagesApi.class);
    }

    public List<Object> getDocuments(String profileId) {

        List<Object> documents = api.profilesProfileIdDocumentImagesGet(profileId);

        return documents;
    }


    public Object uploadImage(String profileId, Image image) {
        Map<String, Object> imageData = constructImageUploadRequest(image);
        Object document = api.profilesProfileIdDocumentImagesPost(profileId, imageData);
        return document;
    }


    private Map<String, Object> constructImageUploadRequest(Image image){
        Map<String, Object> imageData = new HashMap<>();
        imageData.put(DATA, image.getData());
        imageData.put(DOCUMENT_CATEGORY, image.getDocumentCategory());
        imageData.put(DOCUMENT_TYPE, image.getDocumentType());
        imageData.put(IMAGE_TYPE, image.getImageType());
        return imageData;
    }
}
