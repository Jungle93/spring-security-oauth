package com.github.jungle.learn.spring.oauth2.ressrv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * description: ResourceServerConfigurer
 *
 * @author jungle
 * @version 1.0
 * @date 2020/10/30
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

    @Bean
    public RemoteTokenServices tokenService() {
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setClientId("clientId");
        tokenServices.setClientSecret("123456");
        tokenServices.setCheckTokenEndpointUrl("http://localhost:8090/oauth/check_token");
        return tokenServices;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("oauth2-resource")
                .tokenServices(tokenService())
                .stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").authenticated()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
