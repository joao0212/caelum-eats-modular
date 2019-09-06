package br.com.caelum.eats;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class PasswordEncoderConfig {

	@Bean
	public PasswordEncoder bCryptPasswordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
