package com.minimi.backend.auth.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private int status;
    private String message;
}
