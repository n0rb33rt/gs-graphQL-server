package com.norbert.graphql.exception;

import lombok.Builder;

@Builder
public record ApiException(
        String error,
        String message,
        String path
) {
}
