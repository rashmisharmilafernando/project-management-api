package lk.ijse.projectmanagementapi2.config;

import lk.ijse.projectmanagementapi2.service.impl.TechLedBOimpl;
import lk.ijse.projectmanagementapi2.util.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JPAConfig.class})
@ComponentScan(basePackageClasses = {TechLedBOimpl.class, Converter.class})
public class WebRootConfig {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
