package pl.damiankaplon.devcompanyweb.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.damiankaplon.devcompanyweb.dbutil.DbUtil;

@Configuration
public class AppConfig {
    @Bean
    public SessionFactory sessionFactory(){
        return DbUtil.sessionFactory;
    }
}
