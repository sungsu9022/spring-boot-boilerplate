package com.sungsu.boilerplate.config;

import com.sungsu.boilerplate.ApplicationPackageRoot;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by seongsuPark on 2018. 9. 8..
 */
@Configuration
@ComponentScan(basePackageClasses = ApplicationPackageRoot.class)
public class RootConfig {
}
