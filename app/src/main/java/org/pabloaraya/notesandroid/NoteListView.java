package org.pabloaraya.notesandroid;

import android.support.v7.widget.RecyclerView;

/**
 * Created by pablo on 10/26/16.
 */

public interface NoteListView {

  void setNoteListManager(RecyclerView.LayoutManager manager);
  void setNoteListAdapter(NoteAdapter adapter);
  void showNoteList(boolean state);
  void showDialogNewNote();
  void hideDialogNewNote();
}
