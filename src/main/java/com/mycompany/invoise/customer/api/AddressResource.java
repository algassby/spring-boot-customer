package com.mycompany.invoise.customer.api;

import com.mycompany.invoise.core.entity.customer.Address;
import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.customer.repository.AddressRepositoryInterface;
import com.mycompany.invoise.customer.repository.CustomerRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/address")
public class AddressResource {

    @Autowired
    private AddressRepositoryInterface addressResource;

    @RequestMapping("/{id}")
    public Address get(@PathVariable("id") Long id){
        return addressResource.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public AddressRepositoryInterface getAddressResource() {
        return addressResource;
    }

    public void setAddressResource(AddressRepositoryInterface addressResource) {
        this.addressResource = addressResource;
    }
}
