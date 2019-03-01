package com.excelian.diginexserver.service;

import com.excelian.diginexserver.config.ApplicationProperties;
import com.excelian.diginexserver.domain.UserDetails;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.openapitools.client.api.ProfilesApi;
import org.openapitools.client.model.ProfileResource;
import org.openapitools.client.model.Role;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ProfileServiceTest {

    private ApplicationProperties appProperties;

    private ProfilesApi api;

    private ProfileService service;

    @Before
    public void setup() {
        this.api = Mockito.mock(ProfilesApi.class);
        this.service = new ProfileService(appProperties, api);
    }

    @Test
    public void whenCreatingNewProfile_shouldReturnTheProfileResource() {
        UserDetails userDetails = new UserDetails(
                "john.doe@email.com", "John", "Doe", "2019 Highway Code Test", "28/02/1981");

        when(api.profilesPost(any(ProfileResource.class))).thenReturn(service.createProfileResource(userDetails));
        ProfileResource profile = service.createProfile(userDetails);

        assertNotNull(profile);
        assertEquals(Role.INDIVIDUAL_CUSTOMER, profile.getRole());
    }
}