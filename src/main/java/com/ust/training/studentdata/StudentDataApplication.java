/***
 * Project Name:StudentData
 */

package com.ust.training.studentdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
@EnableAutoConfiguration
/**
 * class containing Main method where execution starts
 * 
 * @author Akhila
 *
 */
public class StudentDataApplication {

  private static final Logger LOG = LoggerFactory.getLogger(StudentDataApplication.class);

  public static void main(String[] args) {
    try {
      SpringApplication.run(StudentDataApplication.class, args);
    } catch (Exception e) {
      LOG.error("Exception:", e);
    }
  }

  /**
   * Docket api() point to the basepackage controller
   * 
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.ust.training.studentdata.controller"))
        .paths(PathSelectors.any()).build();
  }
}
