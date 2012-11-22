package com.component.tab;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.app.ActionBar.Tab;

public class AlbumsFragment extends SherlockListFragment implements ActionBar.TabListener {
	String songs[] = new String[]{
	        "Nhip Cau Tri Am",
	        "Xuan Chien Truong",
	        "De Lai Cho Doi",
	      };
	
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		 /** Creating array adapter to set data in listview */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_multiple_choice, songs);
 
        /** Setting the array adapter to the listview */
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
