package com.walmart.SQL;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class ResponseResults {
    private final HttpStatus statusCode;
    private final String body;

    ResponseResults(final ClientHttpResponse response) throws IOException {
        final InputStream bodyInputStream = response.getBody();
        final StringWriter stringWriter = new StringWriter();
        IOUtils.copy(bodyInputStream, stringWriter);
        this.body = stringWriter.toString();
        this.statusCode = response.getStatusCode();
    }
    
    ResponseResults(final ResponseEntity<String> responseEntity) {
        this.body = responseEntity.getBody();
        this.statusCode = responseEntity.getStatusCode();
    }

    HttpStatus getStatusCode() {
        return this.statusCode;
    }

    String getBody() {
        return body;
    }
}
