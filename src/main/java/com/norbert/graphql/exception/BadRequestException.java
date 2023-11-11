package com.norbert.graphql.exception;

import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphQLException;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.Map;


public class BadRequestException extends RuntimeException implements GraphQLError {

    private String invalidField;
    public BadRequestException(String message,String invalidField) {
        super(message);
        this.invalidField = invalidField;
    }


    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public List<Object> getPath() {
        return GraphQLError.super.getPath();
    }

    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("invalidField",invalidField);
    }


}
