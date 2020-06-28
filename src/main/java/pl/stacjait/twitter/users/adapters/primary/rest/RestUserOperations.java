package pl.stacjait.twitter.users.adapters.primary.rest;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.stacjait.twitter.users.primaryports.UpdateProfileCommand;
import pl.stacjait.twitter.users.primaryports.UpdateUserProfileUseCase;

@RestController
@RequestMapping("/api/users")
public class RestUserOperations {

	private UpdateUserProfileUseCase userOperations;

	public RestUserOperations(UpdateUserProfileUseCase userOperations) {
		this.userOperations = userOperations;
	}

	@PutMapping("/{userId}")
	public void updateProfile(String userId, UpdateProfileCommandDto command) {
		userOperations.updateProfile(UpdateProfileCommand
			.builder()
			.firstName(command.getFirstName())
			.build());
	}
}
