package org.pabloaraya.notesandroid;

/**
 * Created by pablo on 10/26/16.
 */

public class NoteModel {

  private String message;

  public NoteModel(){}

  public NoteModel(String message){
    this.message = message;
  }

  public void setMessage(String message){
    this.message = message;
  }

  public String getMessage(){
    return message;
  }
}
