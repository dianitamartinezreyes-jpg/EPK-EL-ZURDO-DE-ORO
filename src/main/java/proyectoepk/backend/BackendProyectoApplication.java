package proyectoepk.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 👇 IMPORTS NUEVOS
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import proyectoepk.backend.servlet.ContratoServlet;

@SpringBootApplication
public class BackendProyectoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendProyectoApplication.class, args);
    }

    // 👇 REGISTRAMOS EL SERVLET
    @Bean
    public ServletRegistrationBean<ContratoServlet> servletContrato() {
        return new ServletRegistrationBean<>(new ContratoServlet(), "/guardarContrato");
    }
}
