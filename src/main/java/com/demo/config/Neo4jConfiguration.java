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
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@MapperScan(basePackages = Neo4jConfiguration.PACKAGE,sqlSessionFactoryRef = "Neo4jSessionFactory")
@EnableTransactionManagement
public class Neo4jConfiguration {
    static final String PACKAGE = "com.demo.mapper.neo4j";
    static final String MAPPER_LOCATION = "classpath:mapper/neo4j/*.xml";

    //@Value("${neo4j.url}")
    private String url="jdbc:neo4j:bolt://106.15.234.251:7687";

    @Value("${neo4j.username}")
    private String userName;

    @Value("${neo4j.password}")
    private String password;

    @Value("${neo4j.driver-class-name}")
    private String DriverClassName;


    @Bean(name = "neo4jDataSource")
    public DataSource neo4jDataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(DriverClassName);
        return dataSource;
    }


    @Bean(name = "Neo4jSessionFactory")
    public SqlSessionFactory neo4jSqlSessionFactory(@Qualifier("neo4jDataSource") DataSource neo4jDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(neo4jDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(Neo4jConfiguration.MAPPER_LOCATION));
        System.out.println("neo4j");
        return sessionFactory.getObject();
    }

}
