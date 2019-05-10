package com.spring.restapi.ConsumeRest.service;

import com.spring.restapi.ConsumeRest.model.PhonebookEntry;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class PhonebookService {

    public PhonebookEntry getEntryById(int id)
    {
        final String uri = "http://localhost:8081/api/v1/phonebook/" + id;
        RestTemplate restTemplate = new RestTemplate();

        PhonebookEntry result = restTemplate.getForObject(uri, PhonebookEntry.class);
        return result;
    }

    public List<PhonebookEntry> getAllEntries()
    {
        List<PhonebookEntry> result = null;

        final String uri = "http://localhost:8081/api/v1/phonebook";
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

    public PhonebookEntry createEntry(PhonebookEntry entry)
    {
        final String uri = "http://localhost:8081/api/v1/phonebook";

        RestTemplate restTemplate = new RestTemplate();
        PhonebookEntry result = restTemplate.postForObject( uri, entry, PhonebookEntry.class);
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
        final String uri = "http://localhost:8081/api/v1/phonebook/"+id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri);

    }

}
