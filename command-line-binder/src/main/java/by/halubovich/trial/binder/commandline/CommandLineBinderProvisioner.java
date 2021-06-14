package by.halubovich.trial.binder.commandline;

import org.springframework.cloud.stream.binder.ConsumerProperties;
import org.springframework.cloud.stream.binder.ProducerProperties;
import org.springframework.cloud.stream.provisioning.ConsumerDestination;
import org.springframework.cloud.stream.provisioning.ProducerDestination;
import org.springframework.cloud.stream.provisioning.ProvisioningProvider;

class CommandLineBinderProvisioner implements
    ProvisioningProvider<ConsumerProperties, ProducerProperties> {

  @Override
  public ProducerDestination provisionProducerDestination(
      final String name,
      final ProducerProperties properties) {
    return new CommandLineDestination(name);
  }

  @Override
  public ConsumerDestination provisionConsumerDestination(
      final String name,
      final String group,
      final ConsumerProperties properties) {
    return new CommandLineDestination(name);
  }
}
