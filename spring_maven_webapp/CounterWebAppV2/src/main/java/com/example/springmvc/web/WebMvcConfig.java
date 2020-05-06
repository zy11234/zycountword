package com.example.springmvc.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Web application configuration.
 *
 * @author bobyuan
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

	/**
	 * Locate our static resources and serve them.
	 */
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
	}

	@Controller
	static class FaviconController {
		@GetMapping("favicon.ico")
		public String favicon() {
			return "forward:/assets/img/favicon.ico.png";
		}
	}
}