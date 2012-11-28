package com.music.utility;

import java.util.ArrayList;
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

public class group_format_view extends ArrayAdapter<HashMap<String,ArrayList<MediaFile>>> {

	List<HashMap<String,ArrayList<MediaFile>>> lst_obj;
	Context context;
	protected String TAG = "group_format_view";
	int textView = com.example.musicapplication.R.id.txt_title_group_view_view;
	int viewId = 0; 
	
	public group_format_view(Context context,int textViewResourceId,List<HashMap<String,ArrayList<MediaFile>>> objects) {
		super(context,textViewResourceId , objects);
		// TODO Auto-generated constructor stub
		Log.d(TAG,"Sao khong chiu noi vay ta");
		this.lst_obj = objects;
		this.context = context;
		viewId = textViewResourceId;
		Log.d(TAG,"INIT ");
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflate = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View view = inflate.inflate(viewId, parent, false);
		
		String name= "Le Huu Nghia";
		TextView txtObj= (TextView)view.findViewById(textView);
		
		HashMap<String,ArrayList<MediaFile>> a = lst_obj.get(position);
		Log.d(TAG,"get INFO");
		for (Map.Entry<String,ArrayList<MediaFile>> entry : a.entrySet()){
			name = entry.getKey();
		}
		
		
		txtObj.setText(name);
		return view;
		
	}
	
	
	
	
	
	
}
