package com.example.musicapplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.music.model.MediaDirectory;
import com.music.utility.directory_format_view;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.ListActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DirectoriesActivity extends Activity  {
	
	private final String TAG = "";

	private String[] unShowedFolder = {"/acct", "/cache", "/config", "/system","/sys","/sbin","/root","/etc"};
	private ListView lstView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_directories);
		
		lstView = (ListView)findViewById(R.id.lst_view_directories); 
		
		List<MediaDirectory> lstDir = showDirectory("/");
		
		ArrayAdapter<MediaDirectory> arrayDirAdapter = new directory_format_view(this,R.layout.directory_multi_choice,lstDir,R.id.lst_view_directories); 
		
		
		lstView.setAdapter(arrayDirAdapter);		
		
		
		/*
		lstView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Log.d(TAG,"sao ky vay ta");
				
			}
			
		});
		*/
		
		
		
		//ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice , lststr); 
		//setListAdapter(a);
		
	}

	private List<MediaDirectory> showDirectory(String pathInfo){
	
		File rootDir = new File(pathInfo);
		List<MediaDirectory> lstDirectory = new ArrayList<MediaDirectory>();
		
		if (rootDir != null){
			File[] dirArray = rootDir.listFiles();
			for (File folder : dirArray){
				if ((folder.isDirectory() == true) && (folder.isHidden()==false)){
					if (isValidPath(folder.getPath().toString())){
						MediaDirectory dir = new MediaDirectory();
						dir.setName(folder.getName().toString());
						dir.setPath(folder.getPath().toString());
						dir.setIsChecked("N");
						
						lstDirectory.add(dir);
					}
				}
			}
		}
		return lstDirectory;
	}
	
	private boolean isValidPath(String pathInfo){	
		
		for(String s : unShowedFolder){
			if (s.equals(pathInfo)){
				return false;
			}
		}
		return true;
	}
	
}
