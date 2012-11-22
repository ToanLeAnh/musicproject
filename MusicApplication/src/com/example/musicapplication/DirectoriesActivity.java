package com.example.musicapplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.ListActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class DirectoriesActivity extends ListActivity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_list_directories);
		
		Log.i("tro","khong hieu chuyen gi");
		
		List<String> lststr = showDirectory();
		
		Log.i("Nghia","Chao the gioi");
		
		ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice , lststr); 
		
		Log.i("nghia","sai o dau");
		
		setListAdapter(a);
	}

	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_list_directories, menu);
		return true;
	}
	*/
	
	private List<String> showDirectory(){
	
		File rootDir = new File("/");
		List<String> lststr = new ArrayList<String>();
		
		if (rootDir != null){
			File[] dirArray = rootDir.listFiles();
			for (File folder : dirArray){
				if ((folder.isDirectory() == true) && (folder.isHidden()==false)){
					lststr.add(folder.getPath().toString());
					Log.i("Nghia oi","khong hieu");
				}
			}
		}
		return lststr;
	}

}
