package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by singla1 on 2/14/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("test tweet");
        Tweet tweet2 = new NormalTweet("test tweet");

        tweets.addTweet(tweet1);
        tweets.addTweet(tweet2);

    }

    public void testhasTweet2(){
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("test tweet");
        Tweet tweet2 = new NormalTweet("test tweet2");
        Tweet tweet3 = new NormalTweet("test tweet");

        tweets.add(tweet1);
        tweets.add(tweet2);
        tweets.add(tweet3);

        assertTrue(tweets.hasTweet2());

    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another Test Tweet");

        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(),tweet.getDate());
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Last Tweet");

        tweets.add(tweet);
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet1(tweet));
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("test tweet1");
        Tweet tweet2 = new NormalTweet("test tweet2");
        tweets.add(tweet1);
        tweets.add(tweet2);

        assertEquals(tweets.getCount(),2);

    }

    public void testGettweets(){

        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("test tweet1");
        Tweet tweet2 = new NormalTweet("test tweet2");
        Tweet tweet3 = new NormalTweet("test tweet3");

        tweets.add(tweet1);
        tweets.add(tweet2);
        tweets.add(tweet3);

        assertTrue(tweets.getTweet(1).getDate().compareTo(tweets.getTweet(2).getDate()));

    }

    public void testStrings(){
        assertEquals("'test' should be 'test'", "test", "test");
        assertTrue("'test' should start with 't'", "test".startsWith("t"));
    }
}
