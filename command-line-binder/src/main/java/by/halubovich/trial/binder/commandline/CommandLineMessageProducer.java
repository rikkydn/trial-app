package by.halubovich.trial.binder.commandline;

import static java.util.Optional.ofNullable;
import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.io.BufferedReader;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.support.MessageBuilder;

@RequiredArgsConstructor
@Slf4j
class CommandLineMessageProducer extends MessageProducerSupport {

  private final BufferedReader reader;

  @Override
  public void doStart() {
    newSingleThreadScheduledExecutor().scheduleWithFixedDelay(this::send, 0, 50, MILLISECONDS);
  }

  private void send() {
    try {
      ofNullable(reader.readLine())
          .ifPresent(input -> sendMessage(MessageBuilder.withPayload(input).build()));
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }
}