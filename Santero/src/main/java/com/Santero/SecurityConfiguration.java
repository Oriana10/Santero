package com.Santero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Santero.services.ClientService;

@Configuration
@Order(1)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public ClientService clientService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(clientService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin().and().authorizeRequests()
				.antMatchers("/css/*", "/js/*", "/img/*", "/**").permitAll().and().formLogin()
				.loginPage("/client/login") // Indica la ruta donde el usuario se loguea
				.loginProcessingUrl("/auth/logincheck") // Indica la ruta a donde se envían los datos de logueo
				.usernameParameter("email") // Indica el "Username" con el que el usuario se loguea. Por cuestiones de
											// usabilidad, nuestro "Username" es el email del usuario.
				.passwordParameter("password")// Indica la clave que usa el usuario.
				.defaultSuccessUrl("/")// Indica la URL a donde redirecciona en caso de que se loguee correctamente
				.permitAll().and().logout() // Aca configuro la salida
				.logoutUrl("/client/logout") // Indica la ruta donde el usuario sale de su cuenta
				.logoutSuccessUrl("/") // INdica la URL a donde redirecciona en caso de que se desloguee correctamente
				.permitAll().and().csrf().disable();// Esto evita errores 403
	}
}