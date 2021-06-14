package by.halubovich.trial.binder.commandline;

import java.io.BufferedReader;
import org.springframework.cloud.stream.binder.AbstractMessageChannelBinder;
import org.springframework.cloud.stream.binder.ConsumerProperties;
import org.springframework.cloud.stream.binder.ProducerProperties;
import org.springframework.cloud.stream.provisioning.ConsumerDestination;
import org.springframework.cloud.stream.provisioning.ProducerDestination;
import org.springframework.integration.core.MessageProducer;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

class CommandLineBinder extends
    AbstractMessageChannelBinder<
        ConsumerProperties, ProducerProperties, CommandLineBinderProvisioner> {

  private final BufferedReader reader;

  CommandLineBinder(
      final CommandLineBinderProvisioner provisioningProvider,
      final BufferedReader commandLineReader) {
    super(null, provisioningProvider);
    reader = commandLineReader;
  }

  @Override
  protected MessageHandler createProducerMessageHandler(
      final ProducerDestination destination,
      final ProducerProperties producerProperties,
      final MessageChannel errorChannel) {
    return message -> System.out.println(new String((byte[]) message.getPayload()));
  }

  @Override
  protected MessageProducer createConsumerEndpoint(
      final ConsumerDestination destination,
      final String group,
      final ConsumerProperties properties) {
    return new CommandLineMessageProducer(reader);
  }
}
