package io.muenchendigital.digiwf.digiwf_task_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import pro.taskana.SpringTaskanaEngineConfiguration;
import pro.taskana.TaskanaEngineConfiguration;
import pro.taskana.classification.api.ClassificationService;
import pro.taskana.common.api.TaskanaEngine;
import pro.taskana.common.internal.configuration.DbSchemaCreator;
import pro.taskana.task.api.TaskService;
import pro.taskana.user.api.UserService;
import pro.taskana.workbasket.api.WorkbasketService;

import javax.sql.DataSource;
import java.sql.SQLException;

//@Configuration
public class TaskanaConfig {

    @Value("${taskana.schemaName:TASKANA}")
    private String schemaName;

//    @Bean
//    @Primary
//    //@ConfigurationProperties(prefix = "customdb.datasource")
//    public DataSourceProperties dataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    @Primary
//    public DataSource dataSource(DataSourceProperties properties) {
//        return properties.initializeDataSourceBuilder().build();
//    }
//
//    @Bean
//    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
//        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
//        transactionManager.setDataSource(dataSource);
//        return transactionManager;
//    }
//
//    @Bean
//    public SpringTaskanaEngineConfiguration taskanaEngineConfiguration(DataSource dataSource) {
//        return new SpringTaskanaEngineConfiguration(dataSource, true, false, schemaName);
//    }
//
//    @Bean
//    public TaskanaEngine taskanaEngine(SpringTaskanaEngineConfiguration taskanaEngineConfiguration)
//            throws SQLException {
//        return taskanaEngineConfiguration.buildTaskanaEngine();
//    }
//
//    @Bean
//    public WorkbasketService workbasketService(TaskanaEngine taskanaEngine) {
//        return taskanaEngine.getWorkbasketService();
//    }
//
//    @Bean
//    public TaskService taskService(TaskanaEngine taskanaEngine) {
//        return taskanaEngine.getTaskService();
//    }
//
//    @Bean
//    public ClassificationService classificationService(TaskanaEngine taskanaEngine) {
//        return taskanaEngine.getClassificationService();
//    }
//
//    @Bean
//    public UserService userService(TaskanaEngine taskanaEngine) {
//        return taskanaEngine.getUserService();
//    }
//
//    @Bean
//    @DependsOn("taskanaEngineConfiguration")
//    public DbSchemaCreator schemaGenerator(TaskanaEngineConfiguration taskanaEngineConfiguration,
//                                DataSource dataSource) throws SQLException {
//        DbSchemaCreator dbSchemaCreator =
//                new DbSchemaCreator(dataSource, taskanaEngineConfiguration.getSchemaName());
//        dbSchemaCreator.run();
//
//        return dbSchemaCreator;
//    }
}
