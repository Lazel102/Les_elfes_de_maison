package com.example.prototyp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  public static String UPLOAD_DIRECTORY;

  static {
    Path currentWorkingDir = Paths.get("").toAbsolutePath();
    UPLOAD_DIRECTORY = currentWorkingDir.resolve("uploads").toString();
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/images/**")
        .addResourceLocations("file:" + UPLOAD_DIRECTORY + "/");
  }
}
