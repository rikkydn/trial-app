package by.halubovich.trial.binder.commandline;

import by.halubovich.trial.binder.commandline.support.ModuleTest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.stream.function.StreamBridge;


@ModuleTest
@RequiredArgsConstructor
public class CommandLineBinderTest {

  private final StreamBridge bridge;

  @Test
  void testCommandLineBinder() throws InterruptedException {
    bridge.send("name", "value");
  }
}
