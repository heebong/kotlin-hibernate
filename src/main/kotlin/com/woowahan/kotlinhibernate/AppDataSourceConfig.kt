package com.woowahan.kotlinhibernate

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@ComponentScan(basePackages = ["com.woowahan.kotlinhibernate"])
@EnableJpaRepositories(basePackages = ["com.woowahan.kotlinhibernate"])
class AppDataSourceConfig {
}