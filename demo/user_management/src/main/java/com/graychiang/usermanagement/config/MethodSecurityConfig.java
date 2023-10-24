package com.graychiang.usermanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * Created by IntelliJ IDEA.
 * Project : user_management
 * User: graychiang

 * 
 * Date: 22/03/20
 * Time: 10.08
 */
@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true
)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

}