package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class is the main object class for defining tweets.<br>
 * All tweets have a message and a date attribute.
 * <code>
 *     begin <br>
 *         some pseudo code<br>
 *             end
 * </code>
 * <ul>
 *     <li>item 1</li>
 *     <li>item 2</li>
 *     <li>item 3</li>
 * </ul>
 * <ol>
 *     <li>item 1</li>
 *     <li>item 2</li>
 *     <li>item3</li>
 * </ol>
 *@author singla1
 * @version 1.0
 * @see Tweetable
 * @since 0.5
 *
 */
public abstract class Tweet implements Tweetable{
    private Date date;
    private String message;
    private ArrayList<Mood> moodArrayList = new ArrayList<Mood>();

    //private String hiddenstring;

    /**
     * Instantiates a new Tweet.
     *
     * @param date    the date of the tweet
     * @param message the message
     * @throws TweetooLongException the tweetoo long exception
     */
    public Tweet (Date date, String message) throws TweetooLongException{
        this.date = date;
        this.setMessage(message);
    }

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     * @throws TweetooLongException the tweetoo long exception
     */
    public Tweet (String message) throws TweetooLongException{
        this.setMessage(message);
        this.date = new Date();
    }

    /**
     * Boolean to check if tweet Is important.
     *
     * @return the boolean
     */
    public abstract Boolean isImportant();

    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     * @throws TweetooLongException the tweetoo long exception
     */
    public void setMessage(String message) throws TweetooLongException{
       if (message.length() >144){
           //todo throw new error here
            throw new TweetooLongException();

       } else {
           this.message = message;
       }

    }
    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }

    /**
     * Add a mood to the tweet.
     *
     * @param mood the mood
     */
    public void addMood(Mood mood){
        this.moodArrayList.add(mood);
    }

    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date of the tweet
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
