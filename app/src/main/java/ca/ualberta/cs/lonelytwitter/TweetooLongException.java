package ca.ualberta.cs.lonelytwitter;

/**
 * Created by singla1 on 1/17/17.
 */

public class TweetooLongException extends Exception {
    public TweetooLongException() {
    }

    public TweetooLongException(String detailMessage) {
        super(detailMessage);
    }
}
