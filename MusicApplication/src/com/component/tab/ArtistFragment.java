package com.component.tab;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
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

public class ArtistFragment extends SherlockListFragment implements ActionBar.TabListener{
	
	protected String TAG = "ArtistFragment";
	private Context  context;
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		 /** Creating array adapter to set data in listview */
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_multiple_choice, artist);
 
        /** Setting the array adapter to the listview */
        //setListAdapter(adapter);
		context = view.getContext();
		ArrayAdapter<HashMap<String,ArrayList<MediaFile>>> adapter = new group_format_view(context,R.layout.group_view, SingletonApp.getGroupAtists());
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
		ft.add(android.R.id.content, this,"Artist");
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
