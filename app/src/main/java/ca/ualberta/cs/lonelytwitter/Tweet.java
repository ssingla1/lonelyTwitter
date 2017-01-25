package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by singla1 on 1/17/17.
 */

public abstract class Tweet implements Tweetable{
    private Date date;
    private String message;
    private ArrayList<Mood> moodArrayList = new ArrayList<Mood>();

    //private String hiddenstring;

    public Tweet (Date date, String message) throws TweetooLongException{
        this.date = date;
        this.setMessage(message);
    }
    public Tweet (String message) throws TweetooLongException{
        this.setMessage(message);
        this.date = new Date();
    }

    public abstract Boolean isImportant();

    public String getMessage() {
        return message;
    }

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

    public void addMood(Mood mood){
        this.moodArrayList.add(mood);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
