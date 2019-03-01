package com.excelian.diginexserver.web.rest;


import io.swagger.annotations.ApiOperation;
import org.openapitools.client.model.ProfileResource;
import org.openapitools.client.model.ProfileSearchResults;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@Validated
public class PassfortEventListner {


    @PostMapping(consumes = "application/json",
            produces = "application/json",
            value = "/passfort")
    public String passfortWebhookEndpoint(@RequestBody String json) {

        System.out.println(json);

        return null;
    }

}
