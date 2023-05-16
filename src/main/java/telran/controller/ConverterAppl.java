package telran.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import telran.dto.FixerDTO;

import java.net.URI;
import java.net.URISyntaxException;


public class ConverterAppl {
    public static void main(String[] args) throws URISyntaxException {
        String aKey = "c6b106dc52ff88c18e0d9611a1b5c347";
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<String> requestEntity = new RequestEntity<>(HttpMethod.GET, new URI("http://data.fixer.io/api/latest?access_key="+aKey));
        ResponseEntity<FixerDTO> responseEntity = restTemplate.exchange(requestEntity, FixerDTO.class);
        System.out.println("Status response: \n" + responseEntity.getStatusCode());
        System.out.println("The response is: \n" + responseEntity.getBody());
    }
}
