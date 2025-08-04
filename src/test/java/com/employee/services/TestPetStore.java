package com.employee.services;

import com.employee.details.services.PetStoreClientConfig;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.Map;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

@WireMockTest
public class TestPetStore {

    private static PetStoreClientConfig petStoreClientConfig;
//    private static RestClient restClient;

    @RegisterExtension
    public static  WireMockExtension wiremock =
            WireMockExtension.newInstance().options(wireMockConfig().port(8087)).
                    build();

    @BeforeAll
    public static void setup() {
//        restClient = RestClient.builder().baseUrl("http://localhost:8087").build();

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder().rootUri("http://localhost:8087");
        petStoreClientConfig = new PetStoreClientConfig(restTemplateBuilder);
        System.out.println("setup is successful");
        System.out.println("PetStoreClientConfig: " + petStoreClientConfig);

    }
    @Test
    public void testGetPetById() {
        wiremock.stubFor(get(urlEqualTo("/v2/pet/1")).willReturn(aResponse().
                withHeader("Content-Type", "application/json").withBody("""
                          {
                                                      "id": 1,
                                                      "name": "Dog",
                                                      "status": "available"
                                                    }
                        """)));
        Map<String, Object> result = petStoreClientConfig.getPetById(1L);
        System.out.println(result);
        Assertions.assertEquals(1, result.get("id"));
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll is successful");
        wiremock.resetAll();

    }
}
