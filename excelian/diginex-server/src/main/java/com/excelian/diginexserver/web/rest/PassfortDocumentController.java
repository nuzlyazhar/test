package com.excelian.diginexserver.web.rest;

import com.excelian.diginexserver.domain.Image;
import com.excelian.diginexserver.service.DocumentService;
import io.swagger.annotations.ApiOperation;
import org.openapitools.client.model.ProfileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@Validated
public class PassfortDocumentController {

    static final int DEFAULT_PAGE_SIZE = 10;

    private DocumentService documentService;

    @Autowired
    public PassfortDocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping(value = "/documents/{profileId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Get Document(s)",
            notes = "Gets a list of documents for a given Profile in PassFort",
            response = ProfileResource.class)
    public List<Object> getDocuments(@PathVariable("profileId") String profileId) {

        List<Object> documents = documentService.getDocuments(profileId);

        return documents;
    }

    @PostMapping(value = "/documents/{profileId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Upload a new document image",
            notes = "This method allows you to submit a document image. It returns an &#x60;id&#x60; which can be used to reference the image in other data structures (typically as part of the document data structure)",
            response = Object.class)
    public Object uploadImage(@PathVariable("profileId") String profileId, @RequestBody Image image) {

       Object document = documentService.uploadImage(profileId, image);

        return document;
    }
}
