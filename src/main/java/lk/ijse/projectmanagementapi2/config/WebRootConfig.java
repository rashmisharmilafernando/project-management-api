package lk.ijse.projectmanagementapi2.config;

import lk.ijse.projectmanagementapi2.service.impl.TechLedBOimpl;
import lk.ijse.projectmanagementapi2.util.Converter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {TechLedBOimpl.class, Converter.class})
public class WebRootConfig {

}
