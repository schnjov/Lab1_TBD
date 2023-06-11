package cl.usach.tbd.grupo2.backend_tbd.config;

import cl.usach.tbd.grupo2.backend_tbd.repositories.implementations.UserDetailsRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize

                        .requestMatchers("/api/**").permitAll()
                        .requestMatchers("/voluntarios/**").hasRole("VOLUNTARIO")
                        .requestMatchers("/instituciones/**").hasRole("INSTITUCION")

                        .anyRequest().authenticated()
                );

        http
                .formLogin(withDefaults()); // (1)
        http
                .httpBasic(withDefaults()); // (1)
        return http.build();
    }
  /* (1) By default, Spring Security form login/http basic auth are enabled.
  However, as soon as any servlet-based configuration is provided,
  form based login or/and http basic auth must be explicitly provided.
  */

    // Autenticacion con UserDetailsService
    @Bean
    UserDetailsRepositoryImpl userDetailsService() {
        return new UserDetailsRepositoryImpl();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
