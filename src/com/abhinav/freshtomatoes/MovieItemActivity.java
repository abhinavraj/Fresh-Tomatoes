package com.abhinav.freshtomatoes;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

public class MovieItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.movie_item_activity);
		
		Movie movie = (Movie) getIntent().getSerializableExtra("movie");
		Log.d("DEBUG", movie.title);
		SmartImageView ivProfilePic = (SmartImageView) findViewById(R.id.ivProfilePic);
		ivProfilePic.setImageUrl(movie.profilepicUrl);
		
		TextView tvMovTitle = (TextView) findViewById(R.id.tvTitle);
		tvMovTitle.setText(movie.title);
		
		TextView tvMovieUserRating = (TextView) findViewById(R.id.tvMovieUserRating);
		tvMovieUserRating.setText(movie.userrating);
		
		TextView tvMovCriticRating = (TextView) findViewById(R.id.tvMovCriticRating);
		tvMovCriticRating.setText(movie.criticrating);
		
		TextView tvMovMpaaRating = (TextView) findViewById(R.id.tvMovMpaaRating);
		tvMovMpaaRating.setText(movie.mpaarating);
		
		TextView tvMovRuntime = (TextView) findViewById(R.id.tvMovRuntime);
		tvMovRuntime.setText(movie.runtime);
		
		TextView tvMovieSynopsis = (TextView) findViewById(R.id.tvMovieSynopsis);
		tvMovieSynopsis.setText(movie.synopsis);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

}
