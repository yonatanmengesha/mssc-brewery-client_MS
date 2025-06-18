package com.springmicroservice.jotech.mssc_brewery_client_MS.web.client;

import com.springmicroservice.jotech.mssc_brewery_client_MS.web.model.BeerDto;
import com.springmicroservice.jotech.mssc_brewery_client_MS.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
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

        BeerDto beerDto =  getValidBeerDto();

        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);


        System.out.println(uri.toString());

    }



    @Test
    void testUpdateBeer(){

        BeerDto beerDto = getValidBeerDto();

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
        CustomerDto customerDto = getValidCustomerDto();
       URI uri =  client.saveNewCustomer(customerDto);

       assertNotNull(uri);

        System.out.println(uri);
    }

    @Test
    void testUpdateCustomer(){

        CustomerDto customerDto = getValidCustomerDto();

        client.updateCustomer(UUID.randomUUID(),customerDto);
    }

    @Test
    void testDeleteCustomer(){
        client.deleteCustomerById(UUID.randomUUID());
    }


    BeerDto getValidBeerDto(){
     return    BeerDto.builder().beerName("New Beer")
                .beerStyle("PALE_ALE")
                .upc(1234567890L).build();
    }

    CustomerDto getValidCustomerDto(){
        return CustomerDto.builder()
                .customerName("Yonatan M").build();
    }


}