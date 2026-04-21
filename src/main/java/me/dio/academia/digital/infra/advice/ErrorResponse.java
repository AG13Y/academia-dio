package me.dio.academia.digital.infra.advice;

public record ErrorResponse(
        String message,
        int status,
        long timestamp
) {
}
