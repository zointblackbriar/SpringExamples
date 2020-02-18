package org.tu_dresden.de.internal.selfadaptive;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class ThreadManagement {
	
	private static final Logger logger = LoggerFactory.getLogger(ThreadManagement.class);
	
	@Bean(name = "taskExecutor")
	public Executor taskExecutor() {
		logger.debug("Async task executor");
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2); //this  number should be dynamic in self-adaptive system -- run time dynamicity
		executor.setMaxPoolSize(2); // runtime dynamic
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("Data Thread");
		executor.initialize();
		return executor;
	}

}
