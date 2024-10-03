package com.luv2code.springboot.cruddemo.security;////Quando criamos esse arquivo, o spring security nao vai usar o application.propertiers
////ao inves disso, ele usara esses usuarios definidos aqui
//
//package com.luv2code.springboot.cruddemo.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DemoSecurityConfig {
//    //add support for jdbc
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        return  new JdbcUserDetailsManager(dataSource);
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        //Isso vai setar os roles que tem autorizacao para cada endpoint
//        http.authorizeHttpRequests(configurer ->
//                configurer
//                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
//
//        );
//
//        //use http basic authentication
//        http.httpBasic(Customizer.withDefaults());
//
//        //disable Cross Site Request Forgery(CSRF)
//        //in general, not required for stateless rest aPIS that use POST,PUT,DELETE and/or PATCH
//        http.csrf(csrf -> csrf.disable());
//
//        return http.build();
//    }
//
////    @Bean
////    public InMemoryUserDetailsManager userDetailsManager(){
////        UserDetails john = User.builder()
////                .username("john")
////                .password("{noop}test123")
////                .roles("EMPLOYEE")
////                .build();
////        UserDetails mary = User.builder()
////                .username("mary")
////                .password("{noop}test123")
////                .roles("EMPLOYEE", "MANAGER")
////                .build();
////        UserDetails susan = User.builder()
////                .username("susan")
////                .password("{noop}test123")
////                .roles("EMPLOYEE", "MANAGER", "ADMIN")
////                .build();
////        return new InMemoryUserDetailsManager(john,mary,susan);
////    }
//}
//

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig{


    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        // Create a JdbcUserDetailsManager instance
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        // Configure JdbcUserDetailsManager (e.g., set table names)
        userDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");

        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
