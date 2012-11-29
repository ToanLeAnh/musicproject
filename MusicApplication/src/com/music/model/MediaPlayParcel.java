package com.music.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class MediaPlayParcel implements Parcelable {
	private String pathMedia;
	private String typeObj = "";
	private int position = 0;
	
	protected String TAG = "";
	
	//Deserilise
	public MediaPlayParcel(Parcel source){
		this.pathMedia = source.readString();
		this.typeObj = source.readString();
		this.position = source.readInt();
		Log.d("TAG", "call create");
	}
	
	public MediaPlayParcel(){
		
	}
	
	public String getPathMedia() {
		return pathMedia;
	}
	public void setPathMedia(String pathMedia) {
		this.pathMedia = pathMedia;
	}
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	public String getTypeObj() {
		return typeObj;
	}
	public void setTypeObj(String typeObj) {
		this.typeObj = typeObj;
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//Serilise
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		//i just need to write each fields into paracell
		
		dest.writeString(this.pathMedia);
		dest.writeString(this.typeObj);
		dest.writeInt(this.position);
		Log.d("khong","Write it");
	}
	
	public final static Parcelable.Creator<MediaPlayParcel> CREATOR = new Creator<MediaPlayParcel>(){

		@Override
		public MediaPlayParcel createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			Log.d("TAG", "create");
			return new MediaPlayParcel(source);
		}

		@Override
		public MediaPlayParcel[] newArray(int size) {
			// TODO Auto-generated method stub
			return new MediaPlayParcel[size];
		}
		
	};
	
}
