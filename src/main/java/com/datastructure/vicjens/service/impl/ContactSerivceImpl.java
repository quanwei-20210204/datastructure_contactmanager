package com.datastructure.vicjens.service.impl;

import com.datastructure.vicjens.service.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactSerivceImpl implements ContactService {
    @Override
    public String say(){
        return "hello sunflower";
    }
}
