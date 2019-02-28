package com.excelian.diginexserver.service;

import com.excelian.diginexserver.config.ApplicationProperties;
import org.openapitools.client.ApiClient;
import org.openapitools.client.api.DocumentImagesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    private ApplicationProperties appProperties;
    private DocumentImagesApi api;

    @Autowired
    public DocumentService(ApplicationProperties applicationProperties) {
        this.appProperties = applicationProperties;
        this.api = new ApiClient(appProperties.getAuthName(),appProperties.getApiKey()).buildClient(DocumentImagesApi.class);
    }

    public List<Object> getDocuments(String profileId) {

        List<Object> documents = api.profilesProfileIdDocumentImagesGet(profileId);

        return documents;
    }
}
