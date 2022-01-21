import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        EntityManagerFactory factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
        EntityManager em = factory.createEntityManager();

        Product product = context.getBean("product", Product.class);

        em.getTransaction().begin();
        product.setPrice(100);
        product.setTitle("Pencil");
        em.persist(product);
        em.getTransaction().commit();

        em.close();



    }
}
