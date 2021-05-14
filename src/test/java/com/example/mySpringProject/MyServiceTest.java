package com.example.mySpringProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
@RunWith(SpringRunner.class)
@RestClientTest(MyService.class)
@TestPropertySource(properties = { "endpoint=/api" })
public class MyServiceTest {
    @Autowired
    private MyService myService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    @Test
    public void myServiceTest(){

        String json = "{\n" +
                "        \"data\": {\n" +
                "            \"id\": 1,\n" +
                "            \"email\": \"janet.weaver@reqres.in\",\n" +
                "            \"first_name\": \"Janet\",\n" +
                "            \"last_name\": \"Weaver\",\n" +
                "            \"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg\"\n" +
                "        }\n" +
                "    }";

        this.mockRestServiceServer
                .expect(requestTo("/api"))
                .andRespond(withSuccess(json, APPLICATION_JSON));

        System.out.println(myService.getUsers());
    }
}
