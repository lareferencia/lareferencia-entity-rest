package org.lareferencia.app.rest;

import javax.servlet.ServletContext;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.solr.core.RequestMethod;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication(exclude=ElasticsearchDataAutoConfiguration.class)
@ComponentScan( basePackages = { "org.lareferencia.core", "org.lareferencia.app.rest"})
@EntityScan("org.lareferencia.core.entity.domain")
@EnableJpaRepositories(value = "org.lareferencia.core.entity.repositories.jpa")
@EnableSolrRepositories(basePackages = "org.lareferencia.core.entity.repositories.solr")
//@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
@EnableSwagger2
@Configuration
@ImportResource({"classpath*:application-context.xml"})
public class LareferenciaEntityRestApplication {
	
    @Autowired
    private Environment env;
    private final ServletContext servletContext;
    
    @Autowired
    private TypeResolver typeResolver;

    @Autowired
    public LareferenciaEntityRestApplication(ServletContext servletContext) {
        this.servletContext = servletContext;
    }    

    public static void main(String[] args) {
        SpringApplication.run(LareferenciaEntityRestApplication.class, args);
    }

    /** Configurations beans for solr services */
    @Bean
    public SolrClient solrClient(@Value("${solr.host}") String solrHost) {
        return new HttpSolrClient.Builder(solrHost).build();
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient client) throws Exception {

        SolrTemplate template = new SolrTemplate(client, RequestMethod.POST);
        return template;
    }

    /** Configurations beans for Guava serialization */
    @Bean
    public Module guavaModule() {
        return new GuavaModule();
    }

    @Bean
    ObjectMapper customizeJacksonConfiguration() {
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new GuavaModule());
        return om;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(env.getProperty("rest.lareferencia.spec"))
                //.additionalModels(typeResolver.resolve(org.lareferencia.contrib.rcaap.rest.v2.model.APISearchPagingImpl.class))
                //.paths(PathSelectors.any())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(io.swagger.annotations.Api.class))
                .build()
                .apiInfo(metadata());
    }
    
    /*private Type mixinTypes () {
        return new AlternateTypeBuilder()
                .withAnnotations(io.swagger.annotations.ApiModel.class)
                .build();        
    }*/
 
    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title(env.getProperty("rest.lareferencia.metadata.title"))
                .description(env.getProperty("rest.lareferencia.metadata.description"))
                .version(env.getProperty("rest.lareferencia.metadata.version"))
                .license(env.getProperty("rest.lareferencia.metadata.license"))
                .licenseUrl(env.getProperty("rest.lareferencia.metadata.licenseurl"))
                .build();
    }
/*
    @Bean
    UiConfiguration uiConfig() {
      return UiConfigurationBuilder.builder() 
          .deepLinking(true)
          .displayOperationId(false)
          .defaultModelsExpandDepth(1)
          .defaultModelExpandDepth(1)
          .defaultModelRendering(ModelRendering.EXAMPLE)
          .displayRequestDuration(false)
          .docExpansion(DocExpansion.NONE)
          .filter(false)
          .maxDisplayedTags(null)
          .operationsSorter(OperationsSorter.ALPHA)
          .showExtensions(false)
          .showCommonExtensions(false)
          .tagsSorter(TagsSorter.ALPHA)
          .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
          .validatorUrl(null)
          .build();
    }    
*/
}
