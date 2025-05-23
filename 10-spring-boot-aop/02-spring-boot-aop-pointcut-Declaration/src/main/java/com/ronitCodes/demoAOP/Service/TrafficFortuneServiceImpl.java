package com.ronitCodes.demoAOP.Service;

import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{

    @Override
    public String getFortune(boolean flag){

        if(flag){
            throw new RuntimeException("Trip Wire Detected");
        }

        return getFortune();
    }

    @Override
    public String getFortune(){

        // Simulate a delay
        try{
            TimeUnit.SECONDS.sleep(5);
        }
        catch(InterruptedException exc){
            throw new RuntimeException(exc);
        }


        // return Fortune
        return "Expect heavy traffic this morning. Don't forget your umbrella.";
    }

}
