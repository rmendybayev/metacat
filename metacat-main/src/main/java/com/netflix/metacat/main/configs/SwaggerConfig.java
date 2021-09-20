/*
 *
 *  Copyright 2015 Netflix, Inc.
 *  Modifications copyright (C) 2021 EPAM Systems, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package com.netflix.metacat.main.configs;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Spring configuration for Swagger via SpringFox.
 *
 * see: https://github.com/springfox/springfox
 * @author tgianos
 * @since 1.1.0
 */
@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
    /**
     * Configure Spring Fox.
     *
     * @return The spring fox docket.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(
                getMetacatApi()
            )
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.netflix.metacat.main.api"))
            .paths(PathSelectors.any())
            .build()
            .pathMapping("/")
            .useDefaultResponseMessages(false);
    }

    private ApiInfo getMetacatApi() {
        return new ApiInfoBuilder()
            .title("Metacat API")
            .description("The set of APIs available in this version of metacat")
            .version("2.0")
            .termsOfServiceUrl(null)
            .contact(new Contact("Netflix, Inc.", "https://jobs.netflix.com/", null))
            .license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
            .extensions(Lists.newArrayList()).build();
    }

    //TODO: Update with more detailed swagger configurations
    //      see: http://tinyurl.com/glla6vc
}
