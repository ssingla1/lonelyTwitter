package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    private TextView tweetview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        Intent intent = getIntent();
        String tweet = intent.getStringExtra("tweet");
        tweetview = (TextView) findViewById(R.id.textView);
        tweetview.setText(tweet);
    }
}