package com.walmart.SQL;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MySteppers extends SpringIntegrationTest {



    @Given("^the client calls /hello$")
    public void the_client_issues_GET_hello() throws Throwable {
        executeGet("http://localhost:8000/hello");
    }

    @Given("^the client calls /students$")
    public void the_client_issues_GET_student() throws Throwable {
        executeGet("http://localhost:8000/students");
    }


    @Then("^the status code is (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @And("^the client receives student details (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        assertThat(latestResponse.getBody(), is(version));
    }

   @Given("^the client posts to /students$")
    public void theClientPostsToStudents() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept","application/json");
        headers.add("Content-Type","application/json");

        String jsonBody = "{\"name\": \"mark\"}";
        HttpEntity<String> entity = new HttpEntity<String>(jsonBody,headers);

        restTemplate = new RestTemplate();
        latestResponse = restTemplate.postForEntity("localhost:8080/students",entity,String.class);
    }

    @Then("^the client receives status code ok$")
    public void the_client_receives_status_code() throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is("200"));
    }


}
