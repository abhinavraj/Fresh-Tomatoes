package com.abhinav.freshtomatoes;

import java.util.List;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

public class MovieArrayAdapter extends ArrayAdapter<Movie> {
	public MovieArrayAdapter(Context context, List<Movie> movies) {
		super(context, R.layout.movie_list_item, movies);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//Inflating the view 
		LayoutInflater vi = LayoutInflater.from(getContext());
		RelativeLayout v = (RelativeLayout)vi.inflate(R.layout.movie_list_item, null);
		
		//Accessing the data
		Movie movie = this.getItem(position);
		
		//Populating the view
		TextView tvMovieTitle = (TextView) v.findViewById(R.id.tvMovTitle);
		tvMovieTitle.setText(movie.title);
		
		SmartImageView ivThumbnail = (SmartImageView) v.findViewById(R.id.ivMovie);
		ivThumbnail.setImageUrl(movie.thumnailUrl);
		
		TextView tvCriticRating = (TextView) v.findViewById(R.id.tvCriticRating);
		tvCriticRating.setText(movie.criticrating);
		TextView tvUserRating = (TextView) v.findViewById(R.id.tvUserRating);
		tvUserRating.setText(movie.userrating);
		TextView tvMpaaRating = (TextView) v.findViewById(R.id.tvMpaaRating);
		tvMpaaRating.setText(movie.mpaarating);
		TextView tvRuntime = (TextView) v.findViewById(R.id.tvRuntime);
		tvRuntime.setText(movie.runtime);
		
		// Return the view
		return v;
	}
}
