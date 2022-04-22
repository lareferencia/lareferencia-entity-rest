package org.lareferencia.entity;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@SpringBootApplication
@ComponentScan("org.lareferencia.core.entity")
@EntityScan("org.lareferencia.core.entity.domain")
@EnableJpaRepositories(value="org.lareferencia.core.entity.repositories.jpa")
@EnableSolrRepositories( basePackages = "org.lareferencia.core.entity.repositories.solr"/*, namedQueriesLocation = "classpath:solr-named-queries.properties", */)
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class} )
@Configuration
@ComponentScan
public class DummyApp {

    public static void main(String... args){
        SpringApplication.run(DummyApp.class);
    }
    
 
    
}