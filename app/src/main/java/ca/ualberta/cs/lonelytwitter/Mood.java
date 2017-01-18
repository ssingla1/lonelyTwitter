package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by singla1 on 1/17/17.
 */

public abstract class Mood {
    private Date date;

    public Mood() {
        this.date = new Date();
    }

    public Mood(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String currentmood();

}
