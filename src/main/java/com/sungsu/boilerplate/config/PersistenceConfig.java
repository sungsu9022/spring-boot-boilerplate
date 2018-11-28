package com.sungsu.boilerplate.config;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.DefaultJpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class PersistenceConfig {

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.H2).build();
	}


	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(Boolean.valueOf(jpaProperties().isShowSql()));

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.sungsu.boilerplate.domain");
		factory.setDataSource(dataSource());
		factory.setJpaDialect(new DefaultJpaDialect());
		factory.setJpaProperties(makeJpaProperties());
		return factory;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory);
		return txManager;
	}

	@Bean
	public JpaProperties jpaProperties() {
		return new JpaProperties();
	}

	private Properties makeJpaProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", jpaProperties().getHibernate().getDdlAuto());
		properties.setProperty("hibernate.dialect", jpaProperties().getDatabasePlatform());
		properties.setProperty("hibernate.use_sql_comments", jpaProperties().getProperties().get("hibernate.use_sql_comments"));
		properties.setProperty("hibernate.naming.physical-strategy", jpaProperties().getHibernate().getNaming().getPhysicalStrategy());
		properties.setProperty("hibernate.naming.implicit-strategy", jpaProperties().getHibernate().getNaming().getImplicitStrategy());
		properties.setProperty("hibernate.hbm2ddl.auto", jpaProperties().getHibernate().getDdlAuto());
		return properties;
	}

}
