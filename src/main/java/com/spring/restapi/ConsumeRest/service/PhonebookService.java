package com.spring.restapi.ConsumeRest.service;

import com.spring.restapi.ConsumeRest.model.PhonebookEntry;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
@Service
public class PhonebookService {

    final String baseUri = "http://localhost:8081/api/v1/phonebookentries/";

    public PhonebookEntry getEntryById(int id)
    {
        String uri = baseUri + id;
        RestTemplate restTemplate = new RestTemplate();

        PhonebookEntry result = restTemplate.getForObject(uri, PhonebookEntry.class);
        return result;
    }

    public List<PhonebookEntry> getAllEntries()
    {
        List<PhonebookEntry> result = null;

        String uri = baseUri;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<PhonebookEntry>> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PhonebookEntry>>(){});

        if(response.getStatusCode().value() == 200)
            result = response.getBody();
        return result;
    }

    public URI createEntry(PhonebookEntry entry)
    {
        final String uri = baseUri;

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<PhonebookEntry> requestEntity = new HttpEntity<>(entry, requestHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity response = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                requestEntity,
                ResponseEntity.class);
        URI result = response.getHeaders().getLocation();

        return result;
    }

    public void changeEntry(PhonebookEntry entry)
    {
        final String uri = "http://localhost:8081/api/v1/phonebook";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put( uri, entry);
    }

    public void deleteEntry(int id)
    {
        final String uri = baseUri+id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri);

    }

}
