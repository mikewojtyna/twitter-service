package pl.stacjait.twitter.tweetcrud.activityupdaterimpl;

import pl.stacjait.twitter.tweetcrud.Tweet;
import pl.stacjait.twitter.tweetcrud.TweetActivityUpdater;
import pl.stacjait.twitter.users.domain.LastActivity;
import pl.stacjait.twitter.users.domain.Tags;
import pl.stacjait.twitter.users.primaryports.UpdateUserProfileUseCase;

import java.time.Instant;

public class UsersContextDirectUseCaseConsumingTweetActivityUpdater implements TweetActivityUpdater {

	private UpdateUserProfileUseCase updateUserProfileUseCase;

	public UsersContextDirectUseCaseConsumingTweetActivityUpdater(UpdateUserProfileUseCase updateUserProfileUseCase) {
		this.updateUserProfileUseCase = updateUserProfileUseCase;
	}

	@Override
	public void updateTweetActivityForUser(String userId, Tweet tweet) {
		updateUserProfileUseCase.updateLastActivity(new LastActivity(
			new pl.stacjait.twitter.users.domain.Tweet(Instant.now(), "Title: " + tweet.getMsg()),
			new Tags()));
	}
}
