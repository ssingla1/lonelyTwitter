package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by singla1 on 2/14/17.
 */

public class TweetList {


    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();


    public void add(Tweet tweet){
        tweets.add(tweet);
    }

    public void addTweet(Tweet tweet){

        if (tweetexists(tweets, tweet)){
            throw new IllegalArgumentException();
        }
        else{
            tweets.add(tweet);
        }
    }

    public boolean hasTweet1(Tweet tweet){
        return tweets.contains(tweet);
    }

    public boolean hasTweet2(){
        for(Tweet i : tweets){
            Tweet cur = i;
            for(Tweet j : tweets){
                if(i!=j & j.getMessage().equals(cur.getMessage()));
                return true;
            }
        }
        return false;
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public int getCount(){
        int count = 0;
        for (Tweet i : tweets){
            count += 1;
        }
        return count;
    }

    public ArrayList<Tweet> getTweets (){
        Collections.sort(tweets);
        return tweets;
    }

    public boolean tweetexists(ArrayList<Tweet> tweetList, Tweet tweet){
        for(Tweet i : tweetList){
            if(i.getMessage().equals(tweet.getMessage())){
                return true;
            }
        }
        return false;
    }

}

