package com.my.app.common.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.yaml.snakeyaml.Yaml;

import com.my.app.common.domain.Config;

@Configuration
public class YamlConfig {
	
	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	public Config loadConfig() {
		Config config = null;
		
		try {
			Resource resource = applicationContext.getResource("classpath:config/config.yml");
			Yaml yaml = new Yaml();
			config = yaml.loadAs(resource.getInputStream(), Config.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return config;
	}
	
}
