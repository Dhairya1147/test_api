package com.bajaj.test.controller;

import com.bajaj.test.model.BfhlRequest;
import com.bajaj.test.model.BfhlResponse;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/test")
public class BfhlController {

    //GET Mapping
    @GetMapping
    public Map<String,Integer> getOperationCode(){
        return Collections.singletonMap("operation-code",1);
    }

    //POST Mapping
    @PostMapping
    public BfhlResponse handleRequest(@RequestBody BfhlRequest request){
        List<String> data = request.getData();
        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> highestLowercase_alphabet = new ArrayList<>();

        if (data != null){
            for (String item : data){
                if (item.matches("[0-9]+")){
                    numbers.add(item);
                } else if (item.matches("[A-Za-z]")) {
                    alphabets.add(item);
                }
            }
        }

        List<String> lowercaseAlphabets = new ArrayList<>();
        for (String ch : alphabets){
            if (ch.matches("[a-z]")){
                lowercaseAlphabets.add(ch);
            }
        }

        if (!lowercaseAlphabets.isEmpty()){
            highestLowercase_alphabet.add(Collections.max(lowercaseAlphabets));
        }


        BfhlResponse response = new BfhlResponse();
        response.setUser_id("Dhairya_Gupta_30012003");
        response.setEmail("dhairyagupta1147@gmail.com");
        response.setRoll_number("0002AL221019");
        response.setIs_success(true);
        response.setNumbers(numbers);
        response.setAlphabets(alphabets);
        response.setHighest_alphabet(highestLowercase_alphabet);

        return response;
    }
}
