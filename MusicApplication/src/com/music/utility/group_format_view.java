package com.music.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.music.model.MediaFile;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class group_format_view extends ArrayAdapter<HashMap<String,List<MediaFile>>> {

	List<HashMap<String,List<MediaFile>>> lst_obj;
	Context context;
	protected String TAG = "group_format_view";
	
	public group_format_view(Context context,int textViewResourceId,List<HashMap<String, List<MediaFile>>> objects) {
		super(context, com.example.musicapplication.R.layout.group_view, objects);
		// TODO Auto-generated constructor stub
		this.lst_obj = objects;
		this.context = context;
		Log.d(TAG,"INIT ");
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflate = (LayoutInflater)context.getSystemService(context.LOCATION_SERVICE);
		View view = inflate.inflate(com.example.musicapplication.R.layout.group_view, parent, false);
		
		String name= "";
		TextView txt= (TextView)view.findViewById(com.example.musicapplication.R.id.txt_title_group_view);
		
		HashMap<String,List<MediaFile>> a = lst_obj.get(position);
		Log.d(TAG,"get INFO");
		for (Map.Entry<String,List<MediaFile>> entry : a.entrySet()){
			name = entry.getKey();
		}
		
		txt.setText(name);
		return view;
		
	}
	
	
	
	
	
	
}
