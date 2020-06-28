package pl.stacjait.twitter;

import java.util.Collection;

public class SuggestionService {

	private FollowersService followersService;
	private TweetCrudService tweetCrudService;

	public SuggestionService(FollowersService followersService, TweetCrudService tweetCrudService) {
		this.followersService = followersService;
		this.tweetCrudService = tweetCrudService;
	}

	public Suggestions suggestionsFor(String userId) {
		Followers followers = followersService.followersOf(userId);
		Suggestions suggestions = new Suggestions();
		followers.forEach(follower -> {
			Collection<Tweet> tweets = tweetCrudService.findRecentTweetsOf(follower.getId());
			suggestions.addTweets(tweets);
		});
		return suggestions;
	}

	//	@Transactional
	// transactional makes no sense in distributed systems (most of the time, we don't want to follow 2PC)
	public void updateInTransaction() {
		// TODO: consider SAGA and eventual consistency
		followersService.updateFollowers();
		tweetCrudService.postTweet(new CreateTweetCommand("aa"));
	}
}
