package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This class is defines a normal tweet.<br>
 * <code>
 *     begin <br>
 *         some pseudo code<br>
 *             end
 * </code>
 *@author singla1
 * @version 1.0
 * @see Tweet,TweetooLongException
 * @since 0.5
 *
 */
public class NormalTweet extends Tweet {


    /**
     * Instantiates a new Normal tweet.
     *
     * @param date    the date of the tweet
     * @param message the message
     * @throws TweetooLongException the tweetoo long exception
     */
    public NormalTweet(Date date, String message) throws TweetooLongException {
        super(date, message);
    }

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     * @throws TweetooLongException the tweetoo long exception
     */
    public NormalTweet(String message) throws TweetooLongException {
        super(message);
    }

    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
