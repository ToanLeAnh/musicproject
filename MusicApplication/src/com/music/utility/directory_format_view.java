package com.music.utility;

import java.util.List;

import com.example.musicapplication.R.id;
import com.example.musicapplication.R.layout;
import com.music.model.MediaDirectory;
import com.music.objectmapping.Datasource_directories;

import android.R;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class directory_format_view extends ArrayAdapter<MediaDirectory> {
	
	protected final String TAG = "directory_format_view";
	
	private Context context;
	private List<MediaDirectory> lstDirectory;
	private List<MediaDirectory> ds_lstDir; 
	
	private int typeLayoutFormat = com.example.musicapplication.R.layout.directory_multi_choice;
	private int txtControlId = com.example.musicapplication.R.id.txt_name_directory;
	private int ckControlId = com.example.musicapplication.R.id.ckb_name_directory;
	private Datasource_directories transfer;
	
	private class OnItemClickListener implements OnClickListener{
		
		private int position;
		public OnItemClickListener(int inPosition){
			this.position = inPosition;
		}
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Log.i(TAG, String.valueOf(this.position));
			MediaDirectory a = (MediaDirectory)v.getTag();
			Log.i(TAG,a.getName());
			Log.i(TAG,a.getPath());
			Log.i(TAG,a.getIsChecked());
		}
	};
	
	//This class support in case of user click Checkbox
	private class OnItemCheckedChangeListener implements OnCheckedChangeListener{
		
		private int position;
		
		public OnItemCheckedChangeListener(int mposition){
			this.position = mposition;
		}
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			// TODO Auto-generated method stub
			MediaDirectory dir = new MediaDirectory();
			dir = lstDirectory.get(this.position);
			
			if (isChecked == true){
				transfer.save(dir);
			}
			else{
				transfer.delete(dir);
			}
			
			//Log.d(TAG,String.valueOf(this.position));
			//Log.d(TAG,String.valueOf(isChecked));
		}
	};
	
	private void updateCheck(){
		int i=0,j=0;
		/*
		for(i=0;i < ds_lstDir.size();i++){
			for (j=0;j< lstDirectory.size();j++){
				if(ds_lstDir.get(i).getPath().equals(lstDirectory.get(j).getPath())){
					lstDirectory.get(j).setIsChecked("Y");
				}
			}
		}*/
		
		for(i=0;i< ds_lstDir.size();i++){
			for (j=0;j<lstDirectory.size();j++){
				if (lstDirectory.get(j).equals(ds_lstDir.get(i))){
					lstDirectory.get(j).setIsChecked("Y");
				}
			}
		}
	}
	
	public directory_format_view(Context context, int textViewResourceId,List<MediaDirectory> objects,int controlId) {
		super(context, com.example.musicapplication.R.layout.directory_multi_choice, objects);
		
		// TODO Auto-generated constructor stub
		this.context = context;
		this.lstDirectory = objects;
		this.transfer = new Datasource_directories(context);
		ds_lstDir = transfer.getListAllDirectories();
		updateCheck();
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
		TextView controlObj = (TextView)view.findViewById(this.txtControlId);
		CheckBox controlCk = (CheckBox)view.findViewById(this.ckControlId);
		//Log.d(TAG,"Get Component Successfully.");
		
		MediaDirectory dir = lstDirectory.get(position);
		
		boolean isCheck = dir.getIsChecked() == "Y" ? true : false;
		
		controlObj.setText(dir.getName());
		controlCk.setChecked(isCheck);
	    
		view.setTag(dir);
		
		controlCk.setOnCheckedChangeListener(new OnItemCheckedChangeListener(position));
		
		view.setOnClickListener(new OnItemClickListener(position));
		
		return view;
	}
	
}
