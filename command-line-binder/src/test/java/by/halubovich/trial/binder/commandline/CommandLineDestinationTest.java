package by.halubovich.trial.binder.commandline;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandLineDestinationTest {

  @Test
  void getNameForPartitionTest() {
    Assertions.assertThrows(UnsupportedOperationException.class,
        () -> new CommandLineDestination("").getNameForPartition(1));
  }

}
