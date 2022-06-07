package io.muenchendigital.digiwf.digiwf_task_service.jobs;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pro.taskana.common.internal.transaction.SpringTransactionProvider;
import pro.taskana.common.internal.transaction.TaskanaTransactionProvider;

@Component
public class TransactionalJobsConfiguration {

    @Bean
    public TaskanaTransactionProvider springTransactionProvider() {
        return new SpringTransactionProvider();
    }
}
