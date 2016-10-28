package org.pabloaraya.notesandroid;

import android.app.Application;

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
}
