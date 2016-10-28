package org.pabloaraya.notesandroid;

import java.util.List;

/**
 * Created by pablo on 10/28/16.
 */

public interface NoteCallback {

  void onResponse(List<NoteModel> notes);

  void onNetworkConnectionError();

  void onServerError();
}
