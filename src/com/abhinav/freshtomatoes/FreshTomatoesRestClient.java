package com.abhinav.freshtomatoes;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class FreshTomatoesRestClient {
	private static final String BASE_URL = "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/";

	  private static AsyncHttpClient client = new AsyncHttpClient();

	  public static void getMovieList(String category,AsyncHttpResponseHandler responseHandler) {
		  String url = BASE_URL + category + "?apikey=c3kpks6mv92ym6999npsxsea";
	      client.get(url, responseHandler);
	  }

	  public static void getInThreatresMovieList(AsyncHttpResponseHandler responseHandler) {
		  String url = "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/in_theaters.json?apikey=c3kpks6mv92ym6999npsxsea";
	      client.get(url, responseHandler);
	  }
	  
	  public static void getOpeningMovieList(AsyncHttpResponseHandler responseHandler) {
		  String url = "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/opening.json?apikey=c3kpks6mv92ym6999npsxsea";
	      client.get(url, responseHandler);
	  }
	  
	  public static void getUpcomingMovieList(AsyncHttpResponseHandler responseHandler) {
		  String url = "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/upcoming.json?apikey=c3kpks6mv92ym6999npsxsea";
	      client.get(url, responseHandler);
	  }
	  
}
