package pl.stacjait.twitter.users.secondaryports;

import pl.stacjait.twitter.users.domain.Fact;

public interface FactsPublisher {

	void publish(Fact fact);
}
