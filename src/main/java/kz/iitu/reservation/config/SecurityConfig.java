package kz.iitu.reservation.config;

import kz.iitu.reservation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private EmployeeService employeeService;


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
           .antMatchers("/v2/api-docs",
                   "/configuration/ui",
                   "/swagger-resources/**",
                   "/configuration/security",
                   "/swagger-ui.html",
                   "/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/employees/registration")
            .not()
            .fullyAuthenticated()
            .antMatchers("/auth/**")
            .permitAll()
            .antMatchers("/reserves/**")
            .permitAll()
            .antMatchers("/rooms/**")
            .permitAll()
            .antMatchers("/admin/**")
            .hasAuthority("ADMIN")
            .anyRequest()
            .authenticated()
            .and()
            .addFilter(new JwtTokenGeneratorFilter(authenticationManager()))
            .addFilterAfter(
                    new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2Y);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(employeeService)
            .passwordEncoder(passwordEncoder());
    }
}
