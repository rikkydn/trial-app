package by.halubovich.trial.binder.commandline.support.configuration;

import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestCommandLineBinderConfiguration {

  @Bean
  public Function<String, String> handler() {
    return v -> v;
  }

  @Bean
  @ConditionalOnMissingBean
  public BufferedReader commandLineReader() {
    final var is = new ByteArrayInputStream("test\ntest\n".getBytes(StandardCharsets.UTF_8));
    return new BufferedReader(new InputStreamReader(is));
  }
}
