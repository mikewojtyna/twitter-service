package pl.stacjait.twitter.users.adapters.secondary.fact;

import org.springframework.context.ApplicationEventPublisher;
import pl.stacjait.twitter.users.domain.Fact;
import pl.stacjait.twitter.users.secondaryports.FactsPublisher;

public class SpringLocalEventContainerFactPublisher implements FactsPublisher {

	private ApplicationEventPublisher applicationEventPublisher;

	public SpringLocalEventContainerFactPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	@Override
	public void publish(Fact fact) {
		applicationEventPublisher.publishEvent(fact);
	}
}
