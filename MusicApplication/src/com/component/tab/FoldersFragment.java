package com.component.tab;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockListFragment;
import com.music.Application.SingletonApp;
import com.music.model.MediaFile;
import com.music.objectmapping.Datasource_mediafile;
import com.music.utility.music_format_view;

public class FoldersFragment extends SherlockListFragment implements ActionBar.TabListener {
	
	
	
	private Datasource_mediafile transfer_file;
	protected String TAG = "FoldersFragment";
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		 /** Creating array adapter to set data in listview */
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_multiple_choice, folders);
		//transfer_file = new Datasource_mediafile();
		//List<MediaFile> b =  transfer_file.getAllMediaFromSpecifiedFolders();
        
		SingletonApp.getListMediaFileFromFolders();
		ArrayAdapter<MediaFile> lst_adapter_view  = new music_format_view(view.getContext(),0,SingletonApp.getList_media_folder());
				
        /** Setting the array adapter to the listview */
        setListAdapter(lst_adapter_view);
        
		super.onViewCreated(view, savedInstanceState);
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
