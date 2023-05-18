package telran.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import telran.dto.FixerDTO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Map;


public class ConverterAppl {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please enter your access key: ");
            String aKey = bf.readLine();        //-----------> c6b106dc52ff88c18e0d9611a1b5c347

            RestTemplate restTemplate = new RestTemplate();
            RequestEntity<String> requestEntity = new RequestEntity<>(HttpMethod.GET, new URI("http://data.fixer.io/api/latest?access_key=" + aKey));
            ResponseEntity<FixerDTO> responseEntity = restTemplate.exchange(requestEntity, FixerDTO.class);

            System.out.println("From currency: ");
            String fromCur = bf.readLine().toUpperCase().strip();
            System.out.println("To currency: ");
            String toCur = bf.readLine().toUpperCase().strip();
            System.out.println("Amount");
            Double amount = Double.parseDouble(bf.readLine());

            System.out.println(curExchange(fromCur, toCur, amount, responseEntity.getBody().getRates()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Double curExchange(String from, String to, Double amount, Map<String, Double> data) throws Exception {
        if (!data.containsKey(from) && !data.containsKey(to)) {
            throw new Exception("No such currency in data");
        }
        return amount * (data.get(from) / data.get(to));
    }
}
