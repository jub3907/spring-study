package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {

    @Test
    void StatefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StateFulService stateFulService1 = ac.getBean(StateFulService.class);
        StateFulService stateFulService2 = ac.getBean(StateFulService.class);

        stateFulService1.order("userA", 10000);
        stateFulService2.order("userB", 20000);

        int price1 = stateFulService1.getPrice();
        int price2 = stateFulService2.getPrice();
        System.out.println("price = " + price1);

    }

    static class TestConfig {
        @Bean
        public StateFulService stateFulService() {
            return new StateFulService();
        }
    }
}