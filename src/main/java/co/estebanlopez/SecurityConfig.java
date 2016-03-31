package co.estebanlopez;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebMvcConfigurerAdapter {


    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .anyRequest()
                .anonymous()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }
}
