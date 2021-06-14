package by.halubovich.trial.exchange.coindesk.support;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestConstructor;

@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest
@EnableAutoConfiguration
@ContextConfiguration(classes = ModuleTest.class)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public @interface ModuleTest {

}
