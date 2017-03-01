package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static android.R.attr.text;

/**
 * This class is the main view class of the project. <br> In this class, user interaction
 * and file manipulation is performed.
 * All files are in the form of "json" files that are stored in Emulator's Accessible
 * from Android Device monitor.
 * <pre>
 *     pre-formatted text: <br>
 *         File Explorer -> data -> data -> ca.ualberta.cs.lonelytwitter -> files -> file.sav
 * </pre>
 * <code>
 *     begin <br>
 *         some pseudo code<br>
 *             end
 * </code>
 * The file name is indicated in the &nbsp &nbsp &nbsp FILENAME constant
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
 * @see Tweet
 * @since 0.5
 */
public class LonelyTwitterActivity extends Activity {

    /**
     * The file that all the tweets are saved there. The format of the file is JSON.
     *
     * @see #loadFromFile()
     * @see #saveInFile()
     */
	private static final String FILENAME = "file.sav";
	private enum TweetListOrdering {DATE_ASCENDING,DATE_DESCENDING,TEXT_ASCENDING,TExT_DESCEDING};
    private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;
	private LonelyTwitterActivity activity = this;

    public ListView getOldTweetsList(){
        return oldTweetsList;
    }

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		/*
		try{
			//Tweet tweet = new Tweet("First Tweet");
			Tweet tweet = new NormalTweet("First Tweet");
			//Creating a tweet object using normal tweet as we dont really care
			//about the methods in normal tweet, only tweet methods imp
			//Tweet tweet2 = new Tweet(new Date(), "My second Tweet");
			Mood mood1 = new Good();
			Mood mood2 = new Bad();
			tweet.setMessage("sdhgsd");
			ImportantTweet importanttweet = new ImportantTweet("Very Important");
			importanttweet.getDate();
			importanttweet.addMood(mood1);

			NormalTweet normalTweet = new NormalTweet("is normal");
			normalTweet.addMood(mood2);

			ArrayList<Tweet> arrayList = new ArrayList<Tweet>();
			arrayList.add(tweet);
			arrayList.add(importanttweet);
			arrayList.add(normalTweet);



		}catch (TweetooLongException e) {
			e.printStackTrace();
		}
		*/
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
                text  = trimExtraSpaces(text);
                try{
                    Tweet tweet = new NormalTweet(text);
                    tweetList.add(tweet);
                }
				catch (TweetooLongException e){
                    e.printStackTrace();
                }

				adapter.notifyDataSetChanged();

                saveInFile();
				//finish();

			}
		});
		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				tweetList.clear();
				adapter.notifyDataSetChanged();
				saveInFile();
				//finish();

			}
		});
		oldTweetsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				Intent intent = new Intent(activity, EditTweetActivity.class);
                Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(i);
                intent.putExtra("tweet", tweet.getMessage());
				startActivity(intent);

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

        loadFromFile();
		//String[] tweets = loadFromFile();

        adapter = new ArrayAdapter<Tweet>(this,R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}


    /**
     * Trim extra spaces using regular expression.
     * @param inputString string that needs to be cleared of extra spaces
     * @return resulting string
     */
    private String trimExtraSpaces(String inputString){
        inputString = inputString.replaceAll("\\s+"," ");
        return inputString;
    }

    /**
     * This method sorts the items in the  tweet list and refreshes the adapter.
     * @param ordering ordering to be used
     */
    private void sortTweettListItems(TweetListOrdering ordering){

    }

    /**
     * Loads file from specifeid file.
     *
     * @throws TweetooLongException if the text is too long
     * @exception FileNotFoundException if the file is not created first
     */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
            tweetList = gson.fromJson(in,listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
            tweetList = new ArrayList<Tweet>();
        } catch (IOException e) {
			// TODO Auto-generated catch block
            throw new RuntimeException();
        }
	}

    /**
     * Saves tweets to a specified file in JSON format
     *
     * @throws FileNotFoundException if file folder doesn't exist
     */
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(tweetList,out);
            out.flush();
            fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
            throw new RuntimeException();
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
            //e.printStackTrace();
		}
	}
}