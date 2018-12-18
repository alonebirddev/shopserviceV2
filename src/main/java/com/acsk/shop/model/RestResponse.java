package com.acsk.shop.model;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

public class RestResponse {
    public static final String ERROR_HEADER = "shop-error-message";

    private RestResponse() {
    }

    public static  <T> ResponseEntity<T> createErrorRespoonse(HttpStatus status, Collection<String> messages) {
        HttpHeaders headers = new HttpHeaders();
        for (String message : messages) {
            headers.add(ERROR_HEADER, message);
        }
        return new ResponseEntity<>(headers, status);
    }

    public static <T> ResponseEntity<T> createErrorResponse(HttpStatus status, String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(ERROR_HEADER, message);
        return new ResponseEntity<>(headers, status);
    }

    public static String getErrorMessage(ResponseEntity<?> responseEntity) {
        return responseEntity.getHeaders().getFirst(ERROR_HEADER);
    }

    public static List<String> getErrorMessages(ResponseEntity<?> responseEntity) {
        return responseEntity.getHeaders().get(ERROR_HEADER);
    }
}
