package by.halubovich.trial.binder.commandline;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.provisioning.ConsumerDestination;
import org.springframework.cloud.stream.provisioning.ProducerDestination;

@RequiredArgsConstructor
class CommandLineDestination implements ProducerDestination, ConsumerDestination {

  private final String destination;

  @Override
  public String getName() {
    return destination.trim();
  }

  @Override
  public String getNameForPartition(int partition) {
    throw new UnsupportedOperationException(
        "Partitioning is not implemented for file messaging.");
  }
}
