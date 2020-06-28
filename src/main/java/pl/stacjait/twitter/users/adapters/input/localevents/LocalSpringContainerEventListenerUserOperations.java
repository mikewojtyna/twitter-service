package pl.stacjait.twitter.users.adapters.input.localevents;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.stacjait.twitter.users.primaryports.UpdateProfileCommand;
import pl.stacjait.twitter.users.primaryports.UserOperations;

@Component
public class LocalSpringContainerEventListenerUserOperations {

	private UserOperations userOperations;

	public LocalSpringContainerEventListenerUserOperations(UserOperations userOperations) {
		this.userOperations = userOperations;
	}

	@EventListener
	public void updateProfile(UserProfileUpdated event) {
		userOperations.updateProfile(UpdateProfileCommand
			.builder()
			.firstName(event.getFirstName())
			.build());
	}
}
