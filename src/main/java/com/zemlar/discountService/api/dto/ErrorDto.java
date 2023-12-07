package com.zemlar.discountService.api.dto;

public record ErrorDto(int status, String message, String path) {
}
