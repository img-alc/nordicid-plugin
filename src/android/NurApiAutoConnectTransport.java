/*
 From NordicID Sample App
*/

package com.nordicid.nurapi;

public interface NurApiAutoConnectTransport {

	/** Should return the type of the implementing class (e.g. "BLE", "USB"). */
	public String getType();
	
	/** Can be used to provide some more information about the implementing class. */
	public String getDetails();
	
	/** Sets the address to ehich the implementing class should connect to. */
	public void setAddress(String addr);
	
	/** Returns the address where the implementing class is connected or connecting to. */
	public String getAddress();

	/** The method if the autoconnect implementation needs to handle "onPause". */
	public void onPause();

	/** The method if the autoconnect implementation needs to handle "onResume". */
	public void onResume();

	/** The method if the autoconnect implementation needs to handle "onStop". */
	public void onStop();

	/** The method if the autoconnect implementation needs to handle "onDestroy". */
	public void onDestroy();

	/** Disposing method if needed. */
	public void dispose();
}
