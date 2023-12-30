package com.sa46lll.blogsearcher.dto;

public record ApiResponse<T>(String code, String message, T data) {

    private static final String SUCCESS = "요청에 성공했습니다.";
    private static final String FAIL = "요청에 실패했습니다.";

    public static <T> ApiResponse<T> ok() {
        return new ApiResponse<>(SUCCESS, null, null);
    }

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(SUCCESS, null, data);
    }

    public static <T> ApiResponse<T> failure() {
        return new ApiResponse<>(FAIL, null, null);
    }

    public static <T> ApiResponse<T> failure(String message) {
        return new ApiResponse<>(FAIL, message, null);
    }
}
