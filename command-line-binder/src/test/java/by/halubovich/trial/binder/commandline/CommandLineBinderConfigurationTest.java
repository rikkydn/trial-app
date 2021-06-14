package by.halubovich.trial.binder.commandline;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandLineBinderConfigurationTest {

  @Test
  void commandLineReaderTest() throws InterruptedException {
    Assertions.assertNotNull(new CommandLineBinderConfiguration().commandLineReader());
  }

}
