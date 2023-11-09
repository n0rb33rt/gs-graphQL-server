package com.norbert.graphql.mapper;

import com.norbert.graphql.entity.Address;
import com.norbert.graphql.entity.Student;
import com.norbert.graphql.request.AddressRequest;
import lombok.AllArgsConstructor;

import java.util.function.Function;
@AllArgsConstructor
public class AddressRequestMapper implements Function<AddressRequest, Address> {
    private Student student;
    @Override
    public Address apply(AddressRequest addressRequest) {
        return Address.builder()
                .id(addressRequest.getId())
                .city(addressRequest.getCity())
                .street(addressRequest.getStreet())
                .student(student)
                .build();
    }
}
