package pl.stacjait.twitter.users.impl;

import pl.stacjait.twitter.users.primaryports.UpdateProfileCommand;

import java.util.Optional;

public class UserService {

	public void updateProfile(UpdateProfileCommand command) {
		throw new UnsupportedOperationException("Implement this method");
	}

	public Optional<UserProfile> findProfile(String userId) {
		throw new UnsupportedOperationException("Implement this method");
	}
}
