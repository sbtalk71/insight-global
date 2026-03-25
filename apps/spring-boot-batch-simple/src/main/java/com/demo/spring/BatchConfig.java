package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration

public class BatchConfig {

		
	@Bean
	public Job getJob(JobRepository jobRepository,Step simpleStep) {
		return new JobBuilder("Hello",jobRepository).start(simpleStep).build();
	}
	
	@Bean
	public Step simpleStep(JobRepository jobRepository, PlatformTransactionManager txm) {
		StepBuilder sb= new StepBuilder("hello-world-step", jobRepository);
		
		return sb.tasklet(helloTasklet(),txm).build();
	}

	public Tasklet helloTasklet() {
		return new Tasklet() {

			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println("Hello World from Tasklet");
				return RepeatStatus.FINISHED;
			}
		};
	}

}
