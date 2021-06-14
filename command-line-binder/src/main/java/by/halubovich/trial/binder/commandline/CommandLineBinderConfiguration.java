package by.halubovich.trial.binder.commandline;

import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

class CommandLineBinderConfiguration {

  @Bean
  @ConditionalOnMissingBean
  CommandLineBinderProvisioner commandLineBinderProvisioner() {
    return new CommandLineBinderProvisioner();
  }

  @Bean
  @ConditionalOnMissingBean
  CommandLineBinder commandLineBinder(final CommandLineBinderProvisioner binderProvisioner,
      final BufferedReader commandLineReader) {
    return new CommandLineBinder(binderProvisioner, commandLineReader);
  }

  @Bean
  @ConditionalOnMissingBean
  BufferedReader commandLineReader() {
    return new BufferedReader(new InputStreamReader(in));
  }
}
