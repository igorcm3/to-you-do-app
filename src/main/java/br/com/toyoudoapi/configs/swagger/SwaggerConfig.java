package br.com.toyoudoapi.configs.swagger;

import br.com.toyoudoapi.configs.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by igorcm3 on 19/08/2022 - 21:16
 */
@Configuration
//@Profile("dev")
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30).select()
                .apis(RequestHandlerSelectors.basePackage("br.com.toyoudoapi.controllers"))
                .paths(PathSelectors.any()).build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("To You Do API")
                .description("Documentação da API de acesso aos endpoints do To You Do.").version("1.0")
                .build();
    }

    @Bean
    public SecurityConfiguration security() {
        String token;
        try {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername("admin@gmail.com");
            token = this.jwtTokenUtil.obterToken(userDetails);
        } catch (Exception e) {
            token = "";
        }

        return new SecurityConfiguration(null, null, null, null, "Bearer " + token, ApiKeyVehicle.HEADER,
                "Authorization", ",");
    }
}
