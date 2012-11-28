package com.component.tab;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.music.model.MediaPlayList;
import com.music.objectmapping.DataSource_playlist;
import com.music.utility.playlist_format_view;

public class PlayListFragment extends SherlockListFragment implements ActionBar.TabListener{

	protected final String TAG = "PlayListFragment";
	Context context;
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		 /** Creating array adapter to set data in listview */
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_multiple_choice, playlist);
 
        /** Setting the array adapter to the listview */
		context = view.getContext();
		DataSource_playlist dataPlaylist = new DataSource_playlist(context);
		dataPlaylist.getAllThePlayPlistFromDB();
        ArrayAdapter<MediaPlayList> adapter = new playlist_format_view(context,com.example.musicapplication.R.layout.playplist_view,dataPlaylist.getPlayplist());
        setListAdapter(adapter);
 
		super.onViewCreated(view, savedInstanceState);
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		ft.add(android.R.id.content, this,"Playlist");
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
