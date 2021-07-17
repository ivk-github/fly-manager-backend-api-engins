package com.flymanager.api.engins.configuration;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
/*
	Method level security
	jsr250Enabled :
		set true if @RolesAllowed annotation need to be used
	securedEnabled :
		set true if @Secured annotation need to be used
	prePostEnabled :
		set true if @PreAuthorize and @PostAuthorize annotations need to be used
*/
@EnableGlobalMethodSecurity(jsr250Enabled = true, securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
	@Override
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		/*
			NullAuthenticatedSessionStrategy : For bearer-only applications
			RegisterSessionAuthenticationStrategy : For public or confidential applications
		*/
		return new NullAuthenticatedSessionStrategy();
//		return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(keycloakAuthenticationProvider());

		KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
		/*
			SimpleAuthorityMapper to make sure roles are not prefixed with ROLE_.
			By default when used Role-Based mapping,
			spring-security adds ROLE_ prefix to every role.
		*/
		keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
		auth.authenticationProvider(keycloakAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.csrf().disable();
		http.headers().frameOptions().disable();	// Affichage de la console H2
		http.authorizeRequests()
//			.antMatchers("/swagger-ui", "/swagger-ui/**").permitAll()
//			.antMatchers("/h2-console", "/h2-console/**").permitAll()
//			.antMatchers("/engins", "/engins/**").authenticated()
			.anyRequest().permitAll();
	}
}
