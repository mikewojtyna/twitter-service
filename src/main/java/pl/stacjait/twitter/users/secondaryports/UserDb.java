package pl.stacjait.twitter.users.secondaryports;

import pl.stacjait.twitter.users.domain.UserProfile;

import java.util.Optional;

public interface UserDb {

	void save(UserProfile profile);

	Optional<UserProfile> findById(String userId);
}
