package com.excelian.diginexserver.service;

import com.excelian.diginexserver.config.ApplicationProperties;
import org.openapitools.client.ApiClient;
import org.openapitools.client.api.ChecksApi;
import org.openapitools.client.api.TasksApi;
import org.openapitools.client.model.CheckResource;
import org.openapitools.client.model.TaskResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private ApplicationProperties appProperties;
    private TasksApi api;

    @Autowired
    public TaskService(ApplicationProperties appProperties) {
        this.appProperties = appProperties;
        this.api =  new ApiClient(appProperties.getAuthName(),appProperties.getApiKey()).buildClient(TasksApi.class);
    }

    public List<TaskResource> getChecks(String profileId) {

        List<TaskResource> checkResources = api.profilesProfileIdTasksGet(profileId);

        return checkResources;
    }





}
