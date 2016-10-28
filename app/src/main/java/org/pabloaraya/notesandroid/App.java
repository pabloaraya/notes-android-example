package org.pabloaraya.notesandroid;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by pablo on 10/27/16.
 */

public class App extends Application{

  public static final String API_URL = "https://google.com";

  private static NoteService.NoteInterfaceService service;

  @Override
  public void onCreate() {
    super.onCreate();

    service = new NoteService().api();
  }

  public static NoteService.NoteInterfaceService getService(){
    return service;
  }

  public static boolean isNetworkingAvailable(Context c){
    ConnectivityManager cm = (ConnectivityManager)c.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
  }
}
