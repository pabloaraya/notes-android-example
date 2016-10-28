package org.pabloaraya.notesandroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pablo on 10/26/16.
 */

public class NoteListInteractor {

  public String[] getNotes(){
    return new String[]{"Nota 1", "Nota 2", "Nota 3"};
  }

  public void getNoteServices(String user){
    App.getService().listRepos(user).enqueue(new Callback<List<NoteModel>>() {
      @Override
      public void onResponse(Call<List<NoteModel>> call, Response<List<NoteModel>> response) {

      }

      @Override
      public void onFailure(Call<List<NoteModel>> call, Throwable t) {

      }
    });
  }
}
