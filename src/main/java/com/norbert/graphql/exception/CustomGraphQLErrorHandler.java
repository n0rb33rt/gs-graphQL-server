package com.norbert.graphql.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.execution.DataFetcherExceptionHandler;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomGraphQLErrorHandler implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        return errors.stream().map(error -> GraphqlErrorBuilder.newError()
                .message(error.getMessage())
                .locations(error.getLocations())
                .path(error.getPath())
                .errorType(error.getErrorType())
                .build()).collect(Collectors.toList());
    }

}
