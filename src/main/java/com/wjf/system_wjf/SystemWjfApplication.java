package com.wjf.system_wjf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.wjf.system_wjf.filter")
public class SystemWjfApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemWjfApplication.class, args);
    }

}
