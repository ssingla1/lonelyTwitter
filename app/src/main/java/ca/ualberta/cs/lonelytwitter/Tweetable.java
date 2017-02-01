package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This is an interface for Tweet
 * @author singla1
 * @version 1.0
 * @see Tweet
 * @since 0.5
 *
 */
public interface Tweetable {
    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage();

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate();
}
