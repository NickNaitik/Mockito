package com.example.Mockito.service;

import com.example.Mockito.exception.BussinessException;
import com.example.Mockito.model.DictonaryResponse;
import com.example.Mockito.util.CustomLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class DictonaryService {

    ObjectMapper mapper;

    @Autowired
    public DictonaryService(ObjectMapper mapper){
        this.mapper = mapper;
    }

    String method_Name = "";
    String className =  DictonaryService.class.getName();

    CustomLogger log = new CustomLogger(DictonaryService.class);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<DictonaryResponse[]> responseEntity = null;
    public DictonaryResponse[] getDetails(String word) throws BussinessException {

            method_Name = "getDetail";
            try {
                log.info(className, method_Name, "---Request Processing--", "Word Received for process : " + word);
                responseEntity = restTemplate.exchange("https://api.dictionaryapi.dev/api/v2/entries/en/" + word, HttpMethod.GET, null, DictonaryResponse[].class);
                log.info(className, method_Name, "---Response Processing--- ", responseEntity.getBody());
                return mapper.convertValue(responseEntity.getBody(), DictonaryResponse[].class);
            } catch (HttpClientErrorException exception){
                log.exception("Exception Caught : ",exception, exception.getStatusText(), exception.getResponseBodyAsString());

                // Parse the JSON string
                JSONObject jsonObject = new JSONObject(exception.getResponseBodyAsString());

                // Access values using keys
                String title = jsonObject.getString("title");
                String message = jsonObject.getString("message");
                String resolution = jsonObject.getString("resolution");
                throw new BussinessException("400",message,resolution);
            }
    }

}
