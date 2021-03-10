package ua.restoraunt.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import ua.restoraunt.domain.Menu;
import ua.restoraunt.domain.Restoraunt;


@Configuration
public class AppConfig {

    @Bean
    public RowMapper<Restoraunt> restorauntRowMapper() {
        return new BeanPropertyRowMapper<>(Restoraunt.class);
    }

    @Bean
    public RowMapper<Menu> menuRowMapper() {
        return new BeanPropertyRowMapper<>(Menu.class);
    }
}
