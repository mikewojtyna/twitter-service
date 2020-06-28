package pl.stacjait.twitter.users.domain;

import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Value
@Entity
public class UserProfile {

	@Id
	@GeneratedValue
	UUID id;
	String firstName;
	String lastName;
	String email;
	LastActivity lastActivity;

	public UserProfile(UUID id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		lastActivity = null;
	}
}
