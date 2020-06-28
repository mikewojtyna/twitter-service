package pl.stacjait.twitter.users.adapters.secondary.db;

import org.springframework.stereotype.Component;
import pl.stacjait.twitter.users.domain.UserProfile;
import pl.stacjait.twitter.users.secondaryports.UserDb;

import java.util.Optional;
import java.util.UUID;

@Component
public class JpaUserDb implements UserDb {

	private UserProfileJpaRepository jpaRepository;

	@Override
	public void save(UserProfile profile) {
		jpaRepository.save(profile);
	}

	@Override
	public Optional<UserProfile> findById(String userId) {
		return jpaRepository.findById(UUID.fromString(userId));
	}
}
