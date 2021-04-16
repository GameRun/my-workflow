package com.example.workflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClassConfigConsume {



    private UserConfigTest userConfigTest;

    @Autowired
    public ServiceClassConfigConsume(UserConfigTest userConfigTest) {
        this.userConfigTest = userConfigTest;
    }



}
