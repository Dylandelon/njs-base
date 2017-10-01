package com.njs.webdiary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
//@MapperScan("com.njs.webdiary.mapper")
public class WebDiaryApplication {

	@Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(20);
		return executor;
	}
	@Bean
	public JedisPoolConfig jedisPoolConfig(){
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(200);
		jedisPoolConfig.setMaxIdle(50);
		jedisPoolConfig.setMinIdle(20);
		jedisPoolConfig.setMaxWaitMillis(3000);
		jedisPoolConfig.setTestOnReturn(true);
		jedisPoolConfig.setTestOnBorrow(true);
		return jedisPoolConfig;

	}
	@Bean
	public JedisPool jedisPool(){
		JedisPool jedisPool = new JedisPool(jedisPoolConfig(),"localhost", 6379, 5000,"root");
		return jedisPool;
	}
	public static void main(String[] args) {
		SpringApplication.run(WebDiaryApplication.class, args);
	}
}
