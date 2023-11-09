package com.norbert.graphql.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {
    private Long id;
    private String street;
    private String city;
}
