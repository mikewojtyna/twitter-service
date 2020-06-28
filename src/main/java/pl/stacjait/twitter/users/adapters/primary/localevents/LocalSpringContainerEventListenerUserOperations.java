package pl.stacjait.twitter.users.adapters.primary.localevents;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.stacjait.twitter.users.primaryports.UpdateProfileCommand;
import pl.stacjait.twitter.users.primaryports.UpdateUserProfileUseCase;

@Component
public class LocalSpringContainerEventListenerUserOperations {

	private UpdateUserProfileUseCase userOperations;

	public LocalSpringContainerEventListenerUserOperations(UpdateUserProfileUseCase userOperations) {
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
