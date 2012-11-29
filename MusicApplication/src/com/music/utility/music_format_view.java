package com.music.utility;

import java.util.List;

import com.example.musicapplication.StreamMediaActivity;
import com.music.Application.SingletonApp;
import com.music.model.MediaFile;
import com.music.model.MediaPlayParcel;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class music_format_view extends ArrayAdapter<MediaFile> {

	Context context;
	List<MediaFile> lst_mediaFile;
	
	int musicView = com.example.musicapplication.R.layout.music_view;
	int artist_Music_View = com.example.musicapplication.R.id.txt_artist_music_view;
	int title_Music_View = com.example.musicapplication.R.id.txt_title_music_view;
	
	protected String TAG = "music_format_view";
	
	public music_format_view(Context context, int textViewResourceId,List<MediaFile> objects) {
		super(context, com.example.musicapplication.R.layout.music_view,objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.lst_mediaFile = objects;
		
	}
	
	private class onRowClick implements OnClickListener{
		int position = 0 ;
		
		public onRowClick(int position){
			this.position = position;
		}
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			MediaPlayParcel mediaPlay = new MediaPlayParcel();
			MediaFile mediaFile = lst_mediaFile.get(position);
			mediaPlay.setPathMedia(mediaFile.getPath());
			mediaPlay.setPosition(position);
			
			Intent intent_listen = new Intent(v.getContext(),StreamMediaActivity.class);
			Bundle o = new Bundle();
			o.putParcelable("infObj", mediaPlay);
			intent_listen.putExtra("parcel",o); 
			v.getContext().startActivity(intent_listen);
		}
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		LayoutInflater inflat =  (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View view = inflat.inflate(musicView, parent, false); 
		
		MediaFile mediaFile;
		mediaFile =  lst_mediaFile.get(position);
		TextView artistView =  (TextView)view.findViewById(artist_Music_View);
		TextView titleView =  (TextView)view.findViewById(title_Music_View);
		
		artistView.setText(mediaFile.getArtist());
		titleView.setText(mediaFile.getTitle());
		
		view.setOnClickListener(new onRowClick(position));
		
		return view;
	}
	

	
}
