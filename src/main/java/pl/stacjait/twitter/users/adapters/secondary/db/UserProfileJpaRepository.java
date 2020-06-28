package pl.stacjait.twitter.users.adapters.secondary.db;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.stacjait.twitter.users.domain.UserProfile;

import java.util.UUID;

public interface UserProfileJpaRepository extends JpaRepository<UserProfile, UUID> {

}
