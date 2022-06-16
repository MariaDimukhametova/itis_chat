package org.example.itischat.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.itischat.security.filter.JwtTokenAuthenticationFilter;
import org.example.itischat.security.filter.JwtTokenAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {
    public static final String LOGIN_FILTER_PROCESSES_URL = "/login";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;


    @Value("${jwt.secretKey}")
    private String secretKey;

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtTokenAuthenticationFilter authenticationFilter =
                new JwtTokenAuthenticationFilter(
                        authenticationManagerBean(),
                        objectMapper,
                        secretKey
                );

        JwtTokenAuthorizationFilter authorizationFilter =
                new JwtTokenAuthorizationFilter(objectMapper, secretKey);

        authenticationFilter.setFilterProcessesUrl(LOGIN_FILTER_PROCESSES_URL);
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilter(authenticationFilter);
        http.addFilterBefore(authorizationFilter,
                UsernamePasswordAuthenticationFilter.class);

        http.authorizeRequests()
                .antMatchers(LOGIN_FILTER_PROCESSES_URL + "/**").permitAll()
                .antMatchers("/chatRooms").authenticated()
                .antMatchers("/messages").authenticated();
    }
}
