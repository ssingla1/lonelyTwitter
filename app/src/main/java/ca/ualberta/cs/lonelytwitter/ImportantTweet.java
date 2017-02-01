package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This class is defines an Important tweet.<br>
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
public class ImportantTweet extends Tweet {

    /**
     * Instantiates a new Important tweet.
     *
     * @param date    the date
     * @param message the message
     * @throws TweetooLongException the tweetoo long exception
     */
    public ImportantTweet(Date date, String message) throws TweetooLongException {
        super(date, message);
    }

    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     * @throws TweetooLongException the tweetoo long exception
     */
    public ImportantTweet(String message) throws TweetooLongException {
        super(message);
    }

    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    @Override
    public String getMessage(){
        return super.getMessage() + "!!!!";
    }
}
