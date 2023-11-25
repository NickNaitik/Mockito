package com.example.Mockito.service;

import com.example.Mockito.model.DictonaryResponse;
import com.example.Mockito.util.CustomLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;

@Service
public class DictonaryService {

    String method_Name = "";
    String className =  DictonaryService.class.getName();

    CustomLogger log = new CustomLogger(DictonaryService.class);


    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Object> responseEntity = null;
    ResponseEntity<DictonaryResponse[]> responseEntity2 = null;
    public Object getDetails(String word) {

        method_Name = "getDetail";
        log.info(className,method_Name,"---Request Processing--","Word Received for process : "+word);

            responseEntity = restTemplate.exchange("https://api.dictionaryapi.dev/api/v2/entries/en/" + word, HttpMethod.GET, null, Object.class);
            log.info(className, method_Name, "First Call completed",null);
            responseEntity2 = restTemplate.exchange("https://api.dictionaryapi.dev/api/v2/entries/en/" + word, HttpMethod.GET, null, DictonaryResponse[].class);
            log.info(className, method_Name, "Response received 2: ", responseEntity2.getBody());
            log.info(className, method_Name, "Response received: {}", responseEntity);
        System.out.println("Response Entity Object : "+responseEntity);
        System.out.println("Response Entity DictonaryResponse : "+responseEntity2.getBody()[0]);
        ObjectMapper mapper = new ObjectMapper();
        DictonaryResponse[] dictonaryResponse = mapper.convertValue(responseEntity2.getBody(),DictonaryResponse[].class);
        log.info(className, method_Name,"Dictonary response get word : {}",dictonaryResponse[0].getWord());
        return responseEntity.getBody();
    }

}
