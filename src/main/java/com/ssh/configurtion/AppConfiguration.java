package com.ssh.configurtion;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(value = {"com.ssh.dao", "com.ssh.service"})
@EnableTransactionManagement
public class AppConfiguration {
    private Properties properties;

    {
        properties = new Properties();
        try {
            properties.load(new ClassPathResource("db.properties").getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public DataSource dataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(properties.getProperty("jdbc.driver"));
        dataSource.setJdbcUrl(properties.getProperty("jdbc.url"));
        dataSource.setPassword(properties.getProperty("jdbc.psw"));
        dataSource.setUser(properties.getProperty("jdbc.user"));
        return dataSource;
    }

    @Bean
    public SessionFactory sessionFactory() throws Exception {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setConfigLocation(new ClassPathResource("hibernate/hibernate.cfg.xml"));
        factoryBean.setMappingLocations(
                new ClassPathResource("hibernate/User.hbm.xml"),
                new ClassPathResource("hibernate/Mate.hbm.xml"),
                new ClassPathResource("hibernate/Soulmate.hbm.xml")
        );
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory());
        return transactionManager;
    }
}
