package com.minimi.backend.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member not found"),
    USERNAME_EXISTS(409, "Username exists"),
    EMAIL_EXISTS(409, "Email exists"),
    CONTENTS_NOT_FOUND(404, "Contents not found"),
    COMMENT_NOT_FOUND(404, "Comment not found"),
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

