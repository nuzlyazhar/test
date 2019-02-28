package com.excelian.diginexserver.web.rest;

import com.excelian.diginexserver.service.DocumentService;
import io.swagger.annotations.ApiOperation;
import org.openapitools.client.model.ProfileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
