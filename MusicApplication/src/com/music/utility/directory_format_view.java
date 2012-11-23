package com.music.utility;

import java.util.List;

import com.example.musicapplication.R.id;
import com.example.musicapplication.R.layout;
import com.music.model.MediaDirectory;

import android.R;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

public class directory_format_view extends ArrayAdapter<MediaDirectory> {
	
	private final String TAG = "directory_format_view";
	
	private Context context;
	private List<MediaDirectory> lstDirectory;
	private int typeLayoutFormat = com.example.musicapplication.R.layout.directory_multi_choice;
	private int txtControlId = com.example.musicapplication.R.id.txt_name_directory;
	
	public directory_format_view(Context context, int textViewResourceId,List<MediaDirectory> objects,int controlId) {
		super(context, com.example.musicapplication.R.layout.directory_multi_choice, objects);
		
		// TODO Auto-generated constructor stub
		this.context = context;
		this.lstDirectory = objects;
		//this.typeLayoutFormat = textViewResourceId;
		//this.typeControlId = controlId;
		
		//Log.d(TAG,"Construction");
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//Log.d(TAG,"start get View");
		
		LayoutInflater inflatobj = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View view = (View)inflatobj.inflate(this.typeLayoutFormat,parent,false);
		
		//Log.d(TAG,"transfer xml to Oject successfully.");
		
		TextView controlObj = (TextView)view.findViewById(txtControlId);
		
		//Log.d(TAG,"Get Component Successfully.");
		
		MediaDirectory dir = lstDirectory.get(position);
		
		boolean isCheck = dir.getIsChecked() == "Y" ? true : false;
		
		
		controlObj.setText(dir.getName());
		controlObj.setTag(dir);
		
		//Log.d(TAG,"End Start Get View");
		
		return view;
	}
	
	
}
