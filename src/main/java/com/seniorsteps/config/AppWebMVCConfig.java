package com.seniorsteps.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@Configuration
@EnableWebMvc
public class AppWebMVCConfig implements WebMvcConfigurer {

	
	// TO Solve Problem(Could Not Inialize Proxy LazyLoading)
	public MappingJackson2HttpMessageConverter jacksonMessageConverter() {

		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper mapper = new ObjectMapper();

		// Registering Hibernate5Module to support lazy objects
		mapper.registerModule(new Hibernate5Module());
		messageConverter.setObjectMapper(mapper);

		return messageConverter;
	}

	// TO Solve Problem(Could Not Inialize Proxy LazyLoading)
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(jacksonMessageConverter());
	}
	
	//ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
