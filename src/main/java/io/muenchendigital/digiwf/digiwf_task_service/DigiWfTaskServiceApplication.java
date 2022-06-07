package io.muenchendigital.digiwf.digiwf_task_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import pro.taskana.TaskanaEngineConfiguration;
import pro.taskana.common.api.TaskanaEngine;
import pro.taskana.common.internal.configuration.DbSchemaCreator;
import pro.taskana.sampledata.SampleDataGenerator;

import javax.sql.DataSource;
import java.sql.SQLException;


@SpringBootApplication
@ComponentScan({"pro.taskana","io.muenchendigital.digiwf.digiwf_task_service"})
@EnableScheduling
public class DigiWfTaskServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigiWfTaskServiceApplication.class, args);
    }

    //@Bean
    public GrantedAuthoritiesMapper grantedAuthoritiesMapper() {
        SimpleAuthorityMapper grantedAuthoritiesMapper = new SimpleAuthorityMapper();
        grantedAuthoritiesMapper.setPrefix("");
        return grantedAuthoritiesMapper;
    }
    @Bean
    @DependsOn("taskanaEngineConfiguration") // generate sample data after schema was inserted
    public SampleDataGenerator generateSampleData(
            TaskanaEngineConfiguration taskanaEngineConfiguration,
            DataSource dataSource,
            @Value("${generateSampleData:true}") boolean generateSampleData)
            throws SQLException {
        DbSchemaCreator dbSchemaCreator =
                new DbSchemaCreator(dataSource, taskanaEngineConfiguration.getSchemaName());
        dbSchemaCreator.run();
        SampleDataGenerator sampleDataGenerator =
                new SampleDataGenerator(dataSource, taskanaEngineConfiguration.getSchemaName());
        if (generateSampleData) {
            sampleDataGenerator.generateSampleData();
        }
        return sampleDataGenerator;
    }

    @Bean
    @DependsOn("taskanaEngineConfiguration")
    public TaskanaEngine getTaskanaEngine(TaskanaEngineConfiguration taskanaEngineConfiguration)
            throws SQLException {
        return taskanaEngineConfiguration.buildTaskanaEngine();
    }
}
