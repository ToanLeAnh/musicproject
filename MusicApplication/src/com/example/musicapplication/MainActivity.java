package com.example.musicapplication;

import java.util.zip.Inflater;

import android.os.Bundle;
import android.util.Log;
import android.content.Intent;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;
import com.component.tab.AlbumsFragment;
import com.component.tab.ArtistFragment;
import com.component.tab.FoldersFragment;
import com.component.tab.PlayListFragment;
import com.component.tab.SongsFragment;

public class MainActivity extends SherlockFragmentActivity{

	com.actionbarsherlock.app.ActionBar actionBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
 
        actionBar.setDisplayShowTitleEnabled(true);
 
        Tab tab = actionBar.newTab()
                    .setText("Songs")
                    .setTabListener(new SongsFragment());
                    //.setIcon(R.drawable.songs);
        
        actionBar.addTab(tab);
        
        Tab tab_Album = actionBar.newTab()
                .setText("Albums")
                .setTabListener(new AlbumsFragment());
                //.setIcon(R.drawable.songs);

        actionBar.addTab(tab_Album);
        
        Tab tab_Artist = actionBar.newTab()
                .setText("Artist")
                .setTabListener(new ArtistFragment());
                //.setIcon(R.drawable.songs);

        actionBar.addTab(tab_Artist);

        Tab tab_Playlist = actionBar.newTab()
                .setText("Playlist")
                .setTabListener(new PlayListFragment());
                //.setIcon(R.drawable.songs);

        actionBar.addTab(tab_Playlist);

        Tab tab_Folder = actionBar.newTab()
                .setText("Folders")
                .setTabListener(new FoldersFragment());
                //.setIcon(R.drawable.songs);

        actionBar.addTab(tab_Folder);	
					
	}
	
	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		// TODO Auto-generated method stub
		
		
		 com.actionbarsherlock.view.SubMenu subMenu1 = menu.addSubMenu("Settings");
		 
		 Intent intent = new Intent(this,DirectoriesActivity.class);
	     subMenu1.add("Folders").setIntent(intent);
	     
	     
	     MenuItem b = subMenu1.add("Time");
	    
	     MenuItem subMenu1Item = subMenu1.getItem();
	     subMenu1Item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
	     
	     
	     //Setting Menu.....
		//com.actionbarsherlock.view.MenuInflater inflat = getSupportMenuInflater();
		//inflat.inflate(R.menu.menu_items, menu);
		
		//return super.onCreateOptionsMenu(menu);
		
		//create menu songs
		//MenuItem menuItemSongs = menu.add("Settings");
		
		//menuItemSongs.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		//menuItemSongs (R.menu.menu_items);
		
		/*
		menuItemSongs.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				Intent songsIntent = new Intent(MainActivity.this,SongsActivity.class);
				startActivity(songsIntent);
				
				return true;
			}
		});*/
		
		//add menu artist, album, playslist
		
		//menu.add("Artists").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		//menu.add("Albums").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		//menu.add("Playlists").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		
		return true;
		
	}

	 @Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		Intent a = item.getIntent();
		if (a != null){
			startActivity(a);
		}
			
		// TODO Auto-generated method stub
		return true;
	}
	
}
