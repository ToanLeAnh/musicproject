package com.music.utility;

import java.util.List;

import com.music.model.MediaPlayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class playlist_format_view extends ArrayAdapter<MediaPlayList> {

	protected final String TAG = "";
	private List<MediaPlayList> lst_playplist;
	private Context context;
	private int viewId =0;
	private int txt_playlist_view = com.example.musicapplication.R.id.txt_playlist_view;
	
	public playlist_format_view(Context context, int textViewResourceId,List<MediaPlayList> objects) {
		super(context, textViewResourceId, objects);
		this.lst_playplist = objects;
		this.context = context;
		this.viewId = textViewResourceId;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflat = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View view =  (View)inflat.inflate(this.viewId, parent, false);
		
		TextView txt = (TextView)view.findViewById(txt_playlist_view);
		MediaPlayList a = new MediaPlayList();
		a = lst_playplist.get(position);
		
		txt.setText(a.getPlaylist());
		
		return view;
	}

	
}
