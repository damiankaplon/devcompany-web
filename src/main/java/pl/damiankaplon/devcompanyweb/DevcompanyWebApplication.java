package pl.damiankaplon.devcompanyweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.damiankaplon.devcompanyweb.dbutil.DbUtil;

@SpringBootApplication
public class DevcompanyWebApplication {
    static {
        DbUtil.initialize();
    }

    public static void main(String[] args) {
        SpringApplication.run(DevcompanyWebApplication.class, args);
    }

}
