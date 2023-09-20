package lk.ijse.projectmanagementapi2.config;

import lk.ijse.projectmanagementapi2.controller.TechLedController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {TechLedController.class})

public class WebAppConfig {

}
