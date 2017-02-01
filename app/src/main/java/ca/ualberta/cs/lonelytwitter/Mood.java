package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This is an abstract class that defines the mood of the tweet <br>
 * <code>
 *     begin <br>
 *         some pseudo code<br>
 *             end
 * </code>
 * @author singla1
 * @version 1.0
 * @since 0.5
 *
 */
public abstract class Mood {
    private Date date;

    /**
     * Instantiates a new Mood.
     */
    public Mood() {
        this.date = new Date();
    }

    /**
     * Instantiates a new Mood.
     *
     * @param date the date
     */
    public Mood(Date date) {
        this.date = date;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Currentmood string.
     *
     * @return the string
     */
    public abstract String currentmood();

}
