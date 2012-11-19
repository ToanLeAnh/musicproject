package com.example.musicapplication;

import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Watson.OnCreateOptionsMenuListener;
import android.view.Menu;

public class SongsActivity extends Activity implements OnCreateOptionsMenuListener
{
	ActionBarSherlock mSherlock = ActionBarSherlock.wrap(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mSherlock.setUiOptions(ActivityInfo.UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW);
		mSherlock.setContentView(R.layout.songs);
			
	}
	
	@Override
	public void onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu,
			MenuInflater inflater) {
		// TODO Auto-generated method stub
		 MenuItem miExample1 = menu.add("Example1");
	        miExample1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
	         
	        MenuItem miDismiss = menu.add("Dismiss");
	        miDismiss.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
	         
	        miDismiss.setOnMenuItemClickListener(new OnMenuItemClickListener() {
	            @Override
	            public boolean onMenuItemClick(MenuItem item) {
	 
	                finish();	 
	                return true;
	            }
	     
	        });
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		//return super.onCreateOptionsMenu(menu);
		
		// here we let the ActionBarSherlock object handle the creation of menus.
        return mSherlock.dispatchCreateOptionsMenu(menu);

	}
	    
}
