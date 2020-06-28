package pl.stacjait.twitter.tweetcrud;

import java.util.Collection;

public class TweetCrudService {

	private TweetsRepository repository;

	public void postTweet(CreateTweetCommand command) {
		repository.save(new Tweet(command.getMsg()));
	}

	public Collection<Tweet> findAllTweets() {
		return repository.findAll();
	}

	public Collection<Tweet> findRecentTweetsOf(String userId) {

		return null;
	}
}
