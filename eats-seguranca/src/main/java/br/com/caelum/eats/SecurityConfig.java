package br.com.caelum.eats;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.caelum.eats.seguranca.JwtAuthenticationEntryPoint;
import br.com.caelum.eats.seguranca.JwtAuthenticationFilter;
import br.com.caelum.eats.seguranca.Role;
import br.com.caelum.eats.seguranca.UserService;
import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
class SecurityConfig extends WebSecurityConfigurerAdapter {

	private UserService userService;
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private PasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/restaurantes/**", "/pedidos/**", "/pagamentos/**", "/tipos-de-cozinha/**", "/formas-de-pagamento/**").permitAll()
				.antMatchers("/socket/**").permitAll()
				.antMatchers("/auth/**").permitAll()
				.antMatchers("/actuator/**").permitAll()
				.antMatchers("/admin/**").hasRole(Role.ROLES.ADMIN.name())
				.antMatchers(HttpMethod.POST, "/parceiros/restaurantes").permitAll()
				.antMatchers("/parceiros/restaurantes/do-usuario/{username}").access("@restauranteAuthorizationService.checaUsername(authentication,#username)")
				.antMatchers("/parceiros/restaurantes/{restauranteId}/**").access("@restauranteAuthorizationService.checaId(authentication,#restauranteId)")
				.antMatchers("/parceiros/**").hasRole(Role.ROLES.PARCEIRO.name())
				.anyRequest().authenticated()
				.and().cors()
				.and().csrf().disable()
				.formLogin().disable()
				.httpBasic().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint);
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(this.passwordEncoder);
	}

	@Override
	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
