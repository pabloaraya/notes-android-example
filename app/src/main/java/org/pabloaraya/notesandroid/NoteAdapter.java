package org.pabloaraya.notesandroid;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pablo on 10/26/16.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
  private List<NoteModel> mDataset;

  // Provide a reference to the views for each data item
  // Complex data items may need more than one view per item, and
  // you provide access to all the views for a data item in a view holder
  public static class ViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView mTextView;

    public ViewHolder(View v) {
      super(v);
      mTextView = (TextView) v;
    }
  }

  public NoteAdapter() {
    mDataset = new ArrayList<>();
  }
  // Provide a suitable constructor (depends on the kind of dataset)
  public NoteAdapter(List<NoteModel> myDataset) {
    mDataset = myDataset;
  }

  // Create new views (invoked by the layout manager)
  @Override public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    // create a new view
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
    // set the view's size, margins, paddings and layout parameters

    ViewHolder vh = new ViewHolder(v);
    return vh;
  }

  // Replace the contents of a view (invoked by the layout manager)
  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    // - get element from your dataset at this position
    // - replace the contents of the view with that element
    holder.mTextView.setText(mDataset.get(position).getMessage());
    holder.mTextView.setOnClickListener((View v) -> {
      Toast.makeText(v.getContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
    });
  }

  // Return the size of your dataset (invoked by the layout manager)
  @Override
  public int getItemCount() {
    return mDataset.size();
  }

  public void replaceNotes(List<NoteModel> notes){
    mDataset = notes;
    notifyDataSetChanged();
  }
}


