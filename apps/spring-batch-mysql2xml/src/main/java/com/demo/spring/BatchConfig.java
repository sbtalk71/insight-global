package com.demo.spring;

import com.demo.spring.model.Emp;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages ="com.demo.spring" )
@EnableBatchProcessing
@EnableTransactionManagement
public class BatchConfig {

    @Value("file:xml/employees.xml")
    private WritableResource outputFile;

    @Autowired
    ResourceLoader resourceLoader;


    @Bean
    DataSource dataSource(){
        DriverManagerDataSource ds= new DriverManagerDataSource();
        ds.setUrl("jdbc:mariadb://localhost:3307/training");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }

    @Bean
    ItemReader<Emp> jdbcItemReader(){
        JdbcCursorItemReader<Emp> reader= new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource());
        reader.setSql("select empno,name,address,salary from employee");
        reader.setRowMapper(new EmpRowMapper());
        return reader;
    }

    @Bean
    ItemProcessor<Emp,Emp> itemProcessor(){
        return new EmpItemProcessor();
    }

    @Bean
    ItemWriter<Emp> jaxbItemWriter(){
        StaxEventItemWriter<Emp> writer=new StaxEventItemWriter<>();
        writer.setMarshaller(marshaller());
        writer.setResource(outputFile);
        writer.setRootTagName("employees");
        return writer;

    }
    Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller=new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Emp.class);
        return marshaller;
    }

    @Bean
    Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new StepBuilder("step1",jobRepository)
                .<Emp,Emp>chunk(2,transactionManager)
                .reader(jdbcItemReader()).processor(itemProcessor()).writer(jaxbItemWriter()).build();
    }

    @Bean
    Job job1(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new JobBuilder("mysql2xml-job",jobRepository)
                .start(step1(jobRepository,transactionManager))
                .build();
    }

    @Bean
    PlatformTransactionManager transactionManager(){
        JdbcTransactionManager txm= new JdbcTransactionManager(dataSource());
        return txm;
    }
}
