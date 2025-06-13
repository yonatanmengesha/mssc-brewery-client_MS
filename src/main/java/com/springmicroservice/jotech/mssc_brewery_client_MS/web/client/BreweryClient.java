package com.springmicroservice.jotech.mssc_brewery_client_MS.web.client;


import com.springmicroservice.jotech.mssc_brewery_client_MS.web.model.BeerDto;
import com.springmicroservice.jotech.mssc_brewery_client_MS.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix  = "sfg.brewery",ignoreUnknownFields = false)
public class BreweryClient {

    private final String BEER_PATH_V1="/api/v1/beer";
    private final String CUSTOMER_PATH_V1="/api/v1/customer";

    private String apiHost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid){

        return restTemplate.getForObject(apiHost+BEER_PATH_V1+"/"+uuid.toString(),BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){

        return restTemplate.postForLocation(apiHost+BEER_PATH_V1,beerDto);
    }

    public void updateBeer(UUID uuid,BeerDto beerDto){

         restTemplate.put(apiHost+BEER_PATH_V1 + "/" + uuid.toString(),beerDto);
    }

    public void deleteBeer(UUID uuid){

        restTemplate.delete(apiHost+BEER_PATH_V1+"/"+uuid);
    }

    //customer

    public CustomerDto getCustomerById(UUID uuid){

        return restTemplate.getForObject(apiHost+CUSTOMER_PATH_V1+"/"+uuid.toString(), CustomerDto.class);
    }

    public URI  saveNewCustomer(CustomerDto customerDto){

       return  restTemplate.postForLocation(apiHost+CUSTOMER_PATH_V1,customerDto);
    }

    public void updateCustomer(UUID uuid,CustomerDto customerDto){

        restTemplate.put(apiHost+CUSTOMER_PATH_V1+"/"+uuid,customerDto);
    }

    public void deleteCustomerById(UUID uuid){
        restTemplate.delete(apiHost+CUSTOMER_PATH_V1+"/"+uuid);
    }




    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
