package uz.pdp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import uz.pdp.repository.StudentRepository;
import uz.pdp.repository.StudentRepositoryImpl;

@Configuration  // bu class  nimadir configlarni va qoshimcha ichida bean ishalta oladi
@ComponentScan("uz.pdp")
@EnableWebMvc

public class WebMvcConfig  implements WebMvcConfigurer {
//    front uchun settings web-inf papkadan .jsp fayllarni qidir degandek
    @Bean
    InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        viewResolver().setPrefix("/WEB-INF/views");
        viewResolver().setSuffix(".jsp");
        return resolver;
    }
@Bean
    DriverManagerDataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/potgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("naru456to");
        return  dataSource;
}
@Bean
    public StudentRepository getStudentDAO(){
        return new StudentRepositoryImpl(getDataSource());
}
}
