package com.abhinav.freshtomatoes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {

	String[] categoryList = {"Box Office", "In Theatres", "Opening", "Upcoming"};
	String[] categoryUrl = {"box_office.json", "in_theaters.json", "opening.json", "upcoming.json"};
	ArrayAdapter aCategoryList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		aCategoryList = new ArrayAdapter(this, android.R.layout.simple_list_item_1, categoryList);
		ListView lvCategoryList = (ListView) findViewById(R.id.lvCategoryList);
		lvCategoryList.setAdapter(aCategoryList);
		
		lvCategoryList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long rowid) {
				Intent intent = new Intent(getApplicationContext(), MovieListActivity.class);
				intent.putExtra("category", categoryUrl[position]);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
