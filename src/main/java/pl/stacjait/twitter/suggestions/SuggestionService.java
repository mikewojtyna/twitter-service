package pl.stacjait.twitter.suggestions;

import pl.stacjait.twitter.followers.Followers;
import pl.stacjait.twitter.followers.FollowersService;
import pl.stacjait.twitter.tweetcrud.Tweet;
import pl.stacjait.twitter.tweetcrud.TweetCrudService;

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
}
