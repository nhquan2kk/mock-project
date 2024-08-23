package com.springmvc.mock.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jakarta.servlet.ServletRegistration;
import jakarta.servlet.MultipartConfigElement;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	@Value("${file.upload.directory}")
    private String uploadDirectory;

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {

		// Optionally also set maxFileSize, maxRequestSize, fileSizeThreshold
		registration.setMultipartConfig(new MultipartConfigElement(
				uploadDirectory, 2097152, 4194304, 0));
	}

}
