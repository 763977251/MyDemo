package com.shang.mybatisPlusDemo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

//@Configuration
//@MapperScan(basePackages = "com.shang.mybatisPlusDemo.car", sqlSessionFactoryRef = "carSqlSessionFactory", sqlSessionTemplateRef = "carSqlSessionTemplate")
public class CarDataSourceConfig {

    @Bean(name = "carDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.car")
    public DataSource carDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "carSqlSessionFactory")
    public SqlSessionFactory carSqlSessionFactory(@Qualifier("carDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/shang/mybatisPlusDemo/car/**.xml"));
        return bean.getObject();
    }

    @Bean(name = "carTransactionManager")
    public DataSourceTransactionManager carTransactionManager(@Qualifier("carDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "carSqlSessionTemplate")
    public SqlSessionTemplate carSqlSessionTemplate(@Qualifier("carSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
