package com.springmicroservice.jotech.mssc_brewery_client_MS.web.client;

import com.springmicroservice.jotech.mssc_brewery_client_MS.web.model.BeerDto;
import com.springmicroservice.jotech.mssc_brewery_client_MS.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;


    @Test
    void getBeerById() {

        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testSavedNewBeer(){

        BeerDto beerDto =  BeerDto.builder().beerName("New Beer").build();

        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());

    }



    @Test
    void testUpdateBeer(){

        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        client.updateBeer(UUID.randomUUID(),beerDto);
    }

    @Test
    void testDeleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }

    //Test for customer

    @Test
    void testGetCustomerById(){

       CustomerDto customerDto =  client.getCustomerById(UUID.randomUUID());

       assertNotNull(customerDto);


    }

    @Test
    void testSaveCustomer(){
        CustomerDto customerDto = CustomerDto.builder().name("Yonatan").build();
       URI uri =  client.saveNewCustomer(customerDto);

       assertNotNull(uri);

        System.out.println(uri);
    }

    @Test
    void testUpdateCustomer(){

        CustomerDto customerDto = CustomerDto.builder().name("Yonatan").build();

        client.updateCustomer(UUID.randomUUID(),customerDto);
    }

    @Test
    void testDeleteCustomer(){
        client.deleteCustomerById(UUID.randomUUID());
    }


}