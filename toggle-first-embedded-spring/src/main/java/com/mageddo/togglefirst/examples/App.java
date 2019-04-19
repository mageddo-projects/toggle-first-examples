package com.mageddo.togglefirst.examples;

import com.mageddo.togglefirst.DefaultFeatureManager;
import com.mageddo.togglefirst.EnumFeatureMetadataProvider;
import com.mageddo.togglefirst.FeatureManager;
import com.mageddo.togglefirst.repository.InMemoryFeatureRepository;
import com.mageddo.togglefirst.spring.EnableToggleFirst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableToggleFirst
public class App {

	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
		CoinsService coinsService = ctx.getBean(CoinsService.class);
		logger.info(coinsService.buy("123", 3.50));
	}

	@Bean
	public FeatureManager featureManager() {
		return new DefaultFeatureManager()
			.featureMetadataProvider(new EnumFeatureMetadataProvider())
			.featureRepository(new InMemoryFeatureRepository())
			;
	}
}
