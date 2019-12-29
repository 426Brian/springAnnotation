package com.sprAnnotation.conf;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sprAnnotation.bean.Yellow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource(value = {"classpath:jdbc.properties"})
public class ConfigProfile implements EmbeddedValueResolverAware {

    private StringValueResolver resolver;

    @Value("${mysql.user}")
    String user;
    @Value("${mysql.password}")
    String psw;
    @Value("${mysql.driver}")
    String driver;

    @Profile("test")
    @Bean("dataSourceTest")
    public DataSource dataSourceTest() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/cloudDB01?serverTimezone=GMT");
        dataSource.setDriverClass(driver);
        dataSource.setUser(user);
        dataSource.setPassword(psw);

        return dataSource;
    }


    @Profile("dev")
    @Bean("dataSourceDev")
    public DataSource dataSourceDev() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/cloudDB  02?serverTimezone=GMT");
        dataSource.setDriverClass(driver);
        dataSource.setUser(user);
        dataSource.setPassword(psw);

        return dataSource;
    }

    @Profile("pro")
    @Bean("dataSourcePro")
    public DataSource dataSourcePro() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/cloudDB03?serverTimezone=GMT");
        dataSource.setDriverClass(driver);
        dataSource.setUser(user);
        dataSource.setPassword(psw);

        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
    }

    @Profile("test")
    @Bean
    public Yellow yellow(){
        return new Yellow();
    }
}
