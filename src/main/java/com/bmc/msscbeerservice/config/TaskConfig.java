package com.bmc.msscbeerservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Masoumeh Yeganeh
 * @created 24/05/2023
 */
@Configuration
@EnableAsync
@EnableScheduling
public class TaskConfig {

    @Bean
    TaskExecutor taskExecutor(){
        return new SimpleAsyncTaskExecutor();
    }
}
