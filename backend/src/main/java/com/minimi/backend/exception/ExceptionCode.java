package com.minimi.backend.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member not found"),
    MEMBER_EXISTS(409, "Member exists"),
    CONTENTS_NOT_FOUND(404, "Coffee not found"),
    COMMENT_NOT_FOUND(404, "Order not found"),
    USER_NOT_EQUAL(403,"Username Not Equal"),
    LIKE_NOT_FOUND(404, "Like not found"),
    LIKE_EXISTS(409, "Like exists");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}

