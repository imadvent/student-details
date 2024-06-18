package com.student.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MySqlConfig {

    @Autowired
    private VaultConfig vaultConfig;

    @Bean
    public DataSource dataSource() {

        return DataSourceBuilder
                .create()
                .url(vaultConfig.getUrl())
                .username(vaultConfig.getUsername())
                .password(vaultConfig.getPassword())
                .build();
    }
}
