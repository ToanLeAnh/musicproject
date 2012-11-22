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
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DirectoriesActivity extends ListActivity  {
	
	private String[] unShowedFolder = {"/acct", "/cache", "/config", "/system","/sys","/sbin","/root","/etc"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_list_directories);
		
		List<String> lststr = showDirectory("/");
		
		ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice , lststr); 
		
		setListAdapter(a);
	}

	private List<String> showDirectory(String pathInfo){
	
		File rootDir = new File(pathInfo);
		List<String> lststr = new ArrayList<String>();
		
		if (rootDir != null){
			File[] dirArray = rootDir.listFiles();
			for (File folder : dirArray){
				if ((folder.isDirectory() == true) && (folder.isHidden()==false)){
					if (isValidPath(folder.getPath().toString())){
						
						lststr.add(folder.getName().toString());
					}
				}
			}
		}
		return lststr;
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	}
	
	private boolean isValidPath(String pathInfo){	
		
		Log.i("Le Huu Nghia",pathInfo);
		
		for(String s : unShowedFolder){
			Log.i("Bau oi",s);
			if (s.equals(pathInfo)){
				return false;
			}
		}
		return true;
	}
	
}
