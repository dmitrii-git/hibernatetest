import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"hibernatetest"})
public class AppConfig {
    @Bean
    public Product product() {
        Product product = new Product();

        return product;
    }
}
