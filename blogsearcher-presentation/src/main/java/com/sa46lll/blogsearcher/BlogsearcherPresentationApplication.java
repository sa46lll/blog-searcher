package com.sa46lll.blogsearcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BlogsearcherPresentationApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogsearcherPresentationApplication.class, args);
    }

}
