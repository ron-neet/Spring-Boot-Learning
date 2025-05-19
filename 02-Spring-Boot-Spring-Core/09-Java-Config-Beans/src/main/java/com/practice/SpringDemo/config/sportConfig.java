package com.practice.SpringDemo.config;

import com.practice.SpringDemo.Common.Coach;
import com.practice.SpringDemo.Common.swimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class sportConfig {

    @Bean("aqua")
    public Coach swimCoach(){
        return new swimCoach();
    }

}
