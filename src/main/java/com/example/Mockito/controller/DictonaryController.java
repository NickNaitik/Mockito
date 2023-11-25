package com.example.Mockito.controller;

import com.example.Mockito.exception.BussinessException;
import com.example.Mockito.model.DictonaryResponse;
import com.example.Mockito.service.DictonaryService;
import com.example.Mockito.util.CustomLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
public class DictonaryController {

    private final DictonaryService dictonaryService;

    public DictonaryController(DictonaryService dictonaryService){
        this.dictonaryService = dictonaryService;
    }

    String method_Name = "";
    String className =  DictonaryController.class.getName();

    CustomLogger log = new CustomLogger(DictonaryController.class);

    @GetMapping("/getDetail/{word}")
    public ResponseEntity<Object> getDetail(@PathVariable String word) throws BussinessException {

        method_Name = "getDetail";
        log.info(className,method_Name,"---Request Processing--","Word Received for process : "+word);
        return ResponseEntity.ok(dictonaryService.getDetails(word));
    }

}
