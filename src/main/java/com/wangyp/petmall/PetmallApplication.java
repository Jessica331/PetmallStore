package com.wangyp.petmall;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;


import javax.servlet.MultipartConfigElement;
import java.util.Properties;

@Configuration
@SpringBootApplication
@MapperScan("com.wangyp.petmall.mapper")
public class PetmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetmallApplication.class, args);
	}

	@Bean
	public MultipartConfigElement getMultipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES));
		factory.setMaxRequestSize(DataSize.of(10, DataUnit.MEGABYTES));
		return factory.createMultipartConfig();
	}

	@Bean
	public PageHelper pageHelper() {
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum", "true");
		properties.setProperty("rowBoundsWithCount", "true");
		properties.setProperty("reasonable", "true");
		properties.setProperty("dialect", "mysql");
		pageHelper.setProperties(properties);
		return pageHelper;
	}

}
