package org.pabloaraya.notesandroid;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pablo on 10/26/16.
 */

public class NoteListInteractor {

  private Context context;
  private NoteCallback callback;

  public NoteListInteractor(Context context, NoteCallback callback){
    this.context = context;
    this.callback = callback;
  }

  public void getNotes(){
    if(App.isNetworkingAvailable(context)){
      getNoteServices();
    }else{
      getNoteDatabase();
    }
  }

  public void getNoteServices(){
    App.getService().listNotes().enqueue(new Callback<List<NoteModel>>() {
      @Override
      public void onResponse(Call<List<NoteModel>> call, Response<List<NoteModel>> response) {
        callback.onResponse(response.body());
      }

      @Override
      public void onFailure(Call<List<NoteModel>> call, Throwable t) {
        callback.onServerError();
      }
    });
  }

  public void getNoteDatabase(){
    List<NoteModel> noteModelList = new ArrayList<>();
    noteModelList.add(new NoteModel("Nota 1"));
    noteModelList.add(new NoteModel("Nota 2"));
    noteModelList.add(new NoteModel("Nota 3"));
    noteModelList.add(new NoteModel("Nota 4"));
    noteModelList.add(new NoteModel("Nota 5"));
    noteModelList.add(new NoteModel("Nota 6"));
    noteModelList.add(new NoteModel("Nota 7"));
    noteModelList.add(new NoteModel("Nota 8"));
    callback.onResponse(noteModelList);
  }

  public void newNoteService(String message){
    /*App.getService().listRepos(message).enqueue(new Callback<List<NoteModel>>() {
      @Override
      public void onResponse(Call<List<NoteModel>> call, Response<List<NoteModel>> response) {

      }

      @Override
      public void onFailure(Call<List<NoteModel>> call, Throwable t) {

      }
    });*/
  }
}
