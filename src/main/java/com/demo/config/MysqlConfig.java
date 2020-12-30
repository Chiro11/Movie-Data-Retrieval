package com.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = MysqlConfig.PACKAGE, sqlSessionFactoryRef = "secondSqlSessionFactory")
public class MysqlConfig {

    static final String PACKAGE = "com.demo.mapper";
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Value("${mysql.datasource.url}")
    private String url;

    @Value("${mysql.datasource.username}")
    private String user;

    @Value("${mysql.datasource.password}")
    private String password;

    @Value("${mysql.datasource.driver-class-name}")
    private String driverClass;


    @Bean(name = "mysqlDataSource")
    public DataSource clusterDataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "secondTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("mysqlDataSource") DataSource clusterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MysqlConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
