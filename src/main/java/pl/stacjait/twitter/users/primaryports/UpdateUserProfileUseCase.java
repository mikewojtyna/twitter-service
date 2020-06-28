package pl.stacjait.twitter.users.primaryports;

import pl.stacjait.twitter.users.domain.LastActivity;
import pl.stacjait.twitter.users.domain.UserProfile;
import pl.stacjait.twitter.users.domain.UserProfileUpdated;
import pl.stacjait.twitter.users.secondaryports.FactsPublisher;
import pl.stacjait.twitter.users.secondaryports.UserDb;

import java.time.Instant;

public class UpdateUserProfileUseCase {

	private UserDb userDb;
	private FactsPublisher factsPublisher;

	public UpdateUserProfileUseCase(UserDb userDb, FactsPublisher factsPublisher) {
		this.userDb = userDb;
		this.factsPublisher = factsPublisher;
	}

	public void updateProfile(UpdateProfileCommand command) {
		userDb
			.findById(command.getId())
			.ifPresent(userProfile -> {
				UserProfile updatedProfile = new UserProfile(userProfile.getId(),
					command.getFirstName(), userProfile.getLastName(), userProfile.getEmail());
				userDb.save(updatedProfile);
				factsPublisher.publish(new UserProfileUpdated(Instant.now(), updatedProfile));
			});
	}

	public void updateLastActivity(LastActivity lastActivity) {
		throw new UnsupportedOperationException("Implement this method");
	}
}
