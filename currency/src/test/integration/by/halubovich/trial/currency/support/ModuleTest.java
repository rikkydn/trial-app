package by.halubovich.trial.currency.support;


import by.halubovich.trial.currency.support.configuration.ExchangeServiceMock;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestConstructor;

@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest
@EnableAutoConfiguration
@ContextConfiguration(classes = {
    ModuleTest.class,
    ExchangeServiceMock.class
})
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public @interface ModuleTest {

}
