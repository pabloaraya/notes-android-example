package org.pabloaraya.notesandroid;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by pablo on 10/26/16.
 */

public class NoteListPresenter implements NoteCallback{

  private Context context;
  private NoteListInteractor noteListInteractor;
  private NoteListView noteListView;

  private NoteAdapter mAdapter;
  private RecyclerView.LayoutManager mLayoutManager;

  public NoteListPresenter(Context context, NoteListView noteListView){
    this.context            = context;
    this.noteListInteractor = new NoteListInteractor(context, this);
    this.noteListView       = noteListView;
  }

  public void initListView(){
    mLayoutManager  = new LinearLayoutManager(context);
    mAdapter        = new NoteAdapter();

    noteListView.setNoteListManager(mLayoutManager);
    noteListView.setNoteListAdapter(mAdapter);

    noteListInteractor.getNotes();
  }

  public void newNote(String message){
    noteListInteractor.newNoteService(message);
  }

  @Override
  public void onResponse(List<NoteModel> notes) {
    mAdapter.replaceNotes(notes);
  }

  @Override
  public void onNetworkConnectionError() {
    noteListInteractor.getNoteDatabase();
  }

  @Override
  public void onServerError() {
    noteListInteractor.getNoteDatabase();
  }
}
