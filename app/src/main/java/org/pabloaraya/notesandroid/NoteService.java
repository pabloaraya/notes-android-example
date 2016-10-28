package org.pabloaraya.notesandroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by pablo on 10/27/16.
 */

public class NoteService {

  public interface NoteInterfaceService {
    @GET("{user}/notes")
    Call<List<NoteModel>> listRepos(@Path("user") String user);
  }

  public NoteInterfaceService api(){
    Retrofit retrofit = new Retrofit.Builder()
      .baseUrl(App.API_URL)
      .build();

    return retrofit.create(NoteInterfaceService.class);
  }
}
