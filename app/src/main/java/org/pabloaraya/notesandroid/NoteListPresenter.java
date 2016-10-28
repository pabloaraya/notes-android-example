package org.pabloaraya.notesandroid;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by pablo on 10/26/16.
 */

public class NoteListPresenter {

  private Context context;
  private NoteListInteractor noteListInteractor;
  private NoteListView noteListView;

  private NoteAdapter mAdapter;
  private RecyclerView.LayoutManager mLayoutManager;

  public NoteListPresenter(Context context, NoteListView noteListView){
    this.context = context;
    this.noteListInteractor = new NoteListInteractor();
    this.noteListView = noteListView;
  }

  public void initListView(){
    mLayoutManager = new LinearLayoutManager(context);
    mAdapter = new NoteAdapter(noteListInteractor.getNotes());

    noteListView.setNoteListManager(mLayoutManager);
    noteListView.setNoteListAdapter(mAdapter);
  }
}
