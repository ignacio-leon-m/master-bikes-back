package com.registro.usuarios.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.registro.usuarios.servicio.UsuarioServicio;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	//Inyectamos el servicio de usuarios
	@Autowired
	private UsuarioServicio usuarioServicio;

	//Éste método encripta la contraseña
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//Éste método configura la autenticación de la aplicación y la encriptación de la contraseña
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider(); //DaoAuthenticationProvider es una clase de Spring Security que permite la autenticación de usuarios
		auth.setUserDetailsService(usuarioServicio); //Se le pasa el servicio que implementa la interfaz UserDetailsService
		auth.setPasswordEncoder(passwordEncoder()); //Se le pasa el encoder de contraseñas
		return auth; //Se retorna el objeto DaoAuthenticationProvider
	}

	// Otro método que configura la autenticación de la aplicación,
	// pero en éste caso se le pasa el objeto DaoAuthenticationProvider
	// para que éste se encargue de la autenticación.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	//Éste método configura la seguridad de la aplicación
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(
				"/registro**", //Éstas rutas no requieren autenticación
				"/js/**",
				"/css/**",
				"/img/**").permitAll()
		.anyRequest().authenticated()  //Cualquier otra ruta requiere autenticación
		.and()
		.formLogin() //Se configura el formulario de login
		.loginPage("/login") //Se configura la ruta del formulario de login
		.permitAll() //Se permite el acceso a todos los usuarios
		.and()
		.logout() //Se configura el formulario de logout
		.invalidateHttpSession(true) //Se invalida la sesión, para que no se pueda acceder a ella después del logout
		.clearAuthentication(true) //Se limpia la autenticación
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //Se configura la ruta del formulario de logout
		.logoutSuccessUrl("/login?logout") //Se configura la ruta de la página a la que se redirige después del logout
		.permitAll(); //Se permite el acceso a todos los usuarios
	}
}






