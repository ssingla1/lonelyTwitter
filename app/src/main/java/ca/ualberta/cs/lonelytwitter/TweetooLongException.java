package ca.ualberta.cs.lonelytwitter;

/**
 * This is an exception for a long tweet
 * @author singla1
 * @version 1.0
 * @see Exception
 * @since 0.5
 */
public class TweetooLongException extends Exception {
    /**
     * Instantiates a new Tweetoo long exception.
     */
    public TweetooLongException() {
    }

    /**
     * Instantiates a new Tweetoo long exception.
     *
     * @param detailMessage the detail message
     */
    public TweetooLongException(String detailMessage) {
        super(detailMessage);
    }
}
