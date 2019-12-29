package com.sprAnnotation.conf;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@EnableTransactionManagement
@ComponentScan("com.sprAnnotation")
@Configuration
@PropertySource(value = {"classpath:jdbc.properties"})
public class TxConfig {

    @Value("${mysql.user}")
    String user;
    @Value("${mysql.password}")
    String psw;
    @Value("${mysql.driver}")
    String driver;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/cloudDB01?serverTimezone=GMT");
        dataSource.setDriverClass(driver);
        dataSource.setUser(user);
        dataSource.setPassword(psw);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() throws Exception {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource());

        return dataSourceTransactionManager;
    }
}
