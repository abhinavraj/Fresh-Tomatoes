package com.abhinav.freshtomatoes;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.loopj.android.http.JsonHttpResponseHandler;

public class MovieListActivity extends Activity {
	
	ArrayList<Movie> movieList = new ArrayList<Movie>();
	MovieArrayAdapter aMovieList;

	private void successHandler(JSONObject movielist) {
		JSONArray movies = null;
        String movietitle = null;
		try {
			movies = (JSONArray) movielist.get("movies");
			Log.d("DEBUG", "Movie count:"+movies.length());
			for(int i=0; i < movies.length(); i++) {
				JSONObject movObj = ((JSONObject)movies.get(i));
				String title = movObj.getString("title");
				Movie movie = new Movie(title);
				movie.thumnailUrl = movObj.getJSONObject("posters").getString("thumbnail");
				movie.profilepicUrl = movObj.getJSONObject("posters").getString("detailed");
				movie.userrating = "User:" + movObj.getJSONObject("ratings").getString("audience_score") +"%";
				movie.criticrating = "Critic:" + movObj.getJSONObject("ratings").getString("critics_score") + "%";
				//movie.releasedate = movObj.getJSONObject("release_dates").getString("theatre");
				movie.runtime = movObj.getString("runtime") + " min.";
				movie.mpaarating = movObj.getString("mpaa_rating");
				movie.synopsis = movObj.getString("synopsis");
				
				movieList.add(movie);
			}
			
			aMovieList = new MovieArrayAdapter(MovieListActivity.this, movieList);
			ListView lvMovieList = (ListView) findViewById(R.id.lvMovieList);
			lvMovieList.setAdapter(aMovieList);
			
			lvMovieList.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int position,
						long rowid) {
					Intent intent = new Intent(getApplicationContext(), MovieItemActivity.class);
					intent.putExtra("movie", movieList.get(position));
					startActivity(intent);
				}
			});
			
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private void getMovieList(String category) {
		FreshTomatoesRestClient.getMovieList(category, new JsonHttpResponseHandler() {
			@Override
            public void onSuccess(JSONObject movielist) {
				successHandler(movielist);
            }
			
			@Override
    		public void onFailure(Throwable arg0) {
				Log.d("DEBUG", "getMovieList FAIL");
    		}
		});
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		String category = getIntent().getStringExtra("category");
		getMovieList(category);
		
		setContentView(R.layout.movie_list_activity);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
