package com.norbert.graphql.response;

import com.norbert.graphql.entity.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {
    private Long id;

    private String street;

    private String city;

    public AddressResponse(Address address){
        this.id = address.getId();
        this.street = address.getStreet();
        this.city = address.getCity();
    }

}
