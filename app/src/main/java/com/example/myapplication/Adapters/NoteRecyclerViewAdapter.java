package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Note;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class NoteRecyclerViewAdapter extends RecyclerView.Adapter<NoteRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Note> notes = new ArrayList<Note>();

    public NoteRecyclerViewAdapter(Context context, List<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_note_single, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.textViewNote.setText(notes.get(position).getNote());
//        holder.parentLayout.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                Toast.makeText(context, notes.get(position).getId(), Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNote;
        RelativeLayout parentLayout;
        public View container;

        MyViewHolder(View view) {
            super(view);
            container = view;

            parentLayout = view.findViewById(R.id.parent_layout);
            textViewNote = view.findViewById(R.id.textViewNote);
        }
    }
}
