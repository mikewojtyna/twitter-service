package pl.stacjait.twitter.tweetcrud;

public interface TweetActivityUpdater {

	void updateTweetActivityForUser(String userId, Tweet tweet);
}
