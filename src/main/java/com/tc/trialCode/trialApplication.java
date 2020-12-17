package com.tc.trialCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.tc.trialCode")
@SpringBootApplication
@ServletComponentScan
public class trialApplication {
	protected static final Logger logger= LoggerFactory.getLogger(trialApplication.class);
    public static void main( String[] args ){
    	SpringApplication.run(trialApplication.class, args);
    }
}
