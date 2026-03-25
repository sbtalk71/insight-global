package com.demo.spring;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class MainApp {
    public static void main(String[] args) {
        Logger logger=Logger.getLogger("main-app");
        ApplicationContext ctx= new AnnotationConfigApplicationContext(BatchConfig.class);
        Job job=(Job)ctx.getBean("job1");
        JobLauncher jobLauncher=(JobLauncher) ctx.getBean("jobLauncher");

        try{
            JobParameters params=new JobParametersBuilder()
                    .addString("JobId",String.valueOf(System.currentTimeMillis()))
                    .toJobParameters();

            JobExecution jobExecution= jobLauncher.run(job,params);
            logger.info(jobExecution.getExitStatus()+"");
            logger.info("JOb Completed.....");
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }
}
