package com.component.tab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.example.musicapplication.R;
import com.music.Application.SingletonApp;
import com.music.model.MediaFile;
import com.music.utility.group_format_view;

public class AlbumsFragment extends SherlockListFragment implements ActionBar.TabListener {
	
	Context context;
	protected String TAG= "AlbumsFragment";
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		 /** Creating array adapter to set data in listview */
        //ArrayAdapter<HashMap<String,List<MediaFile>>> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_multiple_choice, SingletonApp.getGroupAlbums());
 
        /** Setting the array adapter to the listview */
		context = view.getContext();	
		ArrayAdapter<HashMap<String,ArrayList<MediaFile>>> adapter = new group_format_view(context,R.layout.group_view, SingletonApp.getGroupAlbums());
	    setListAdapter(adapter);
        
		super.onViewCreated(view, savedInstanceState);
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		ft.add(android.R.id.content, this,"Albums");
        ft.attach(this);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		ft.detach(this);
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
}
