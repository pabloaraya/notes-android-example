package org.pabloaraya.notesandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class NoteMainActivity extends AppCompatActivity implements NoteListView{

  private NoteListPresenter noteListPresenter;

  private RecyclerView mRecyclerView;
  private FloatingActionButton mActionButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    mRecyclerView.setHasFixedSize(true);

    mActionButton = (FloatingActionButton) findViewById(R.id.fab);

    noteListPresenter = new NoteListPresenter(this, this);
    noteListPresenter.initListView();
  }

  @Override
  public void setNoteListManager(RecyclerView.LayoutManager manager) {
    mRecyclerView.setLayoutManager(manager);
  }

  @Override
  public void setNoteListAdapter(NoteAdapter adapter) {
    mRecyclerView.setAdapter(adapter);
  }

  @Override
  public void showNoteList(boolean state) {

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
