package com.example.myapplication.Models;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapters.NoteRecyclerViewAdapter;
import com.example.myapplication.DbHelper.NoteDbHelper;
import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class NotesActivity extends AppCompatActivity {

    FloatingActionButton fab;
    List<Note> notes;
    NoteDbHelper noteDbHelper;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        noteDbHelper = new NoteDbHelper(this);
        notes = noteDbHelper.getAll();

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotesActivity.this, CreateNoteActivity.class));
            }
        });

        initRecylcerView();
    }

    private void initRecylcerView() {
        recyclerView = findViewById(R.id.notesListView);
        final NoteRecyclerViewAdapter recyclerViewAdapter = new NoteRecyclerViewAdapter(this, notes);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SwipeHelper swipeHelper = new SwipeHelper(this, recyclerView) {
            @Override
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons) {
                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        "Edit",
                        0,
                        Color.parseColor("#C7C7CB"),

                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                Intent intent = new Intent(getApplicationContext(), NoteUpdateActivity.class);
                                intent.putExtra("id", notes.get(pos).getId());
                                intent.putExtra("note", notes.get(pos).getNote());
                                startActivity(intent);
                            }
                        }
                ));

                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        "Delete",
                        0,
                        Color.parseColor("#FF3C30"),
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(final int pos) {
                                final AlertDialog.Builder dialog = new AlertDialog.Builder(NotesActivity.this);
                                dialog.setMessage("Are you sure?");
                                dialog.setTitle("Note delete");
                                dialog.setIcon(android.R.drawable.ic_dialog_alert);
                                dialog.setCancelable(false);

                                dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        if (noteDbHelper.deleteById(notes.get(pos).getId())) {
                                            Toast.makeText(getApplicationContext(), "Note Deleted", Toast.LENGTH_SHORT).show();
                                            notes.remove(pos);
                                            recyclerViewAdapter.notifyItemRemoved(pos);
                                        }
                                    }
                                });

                                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                });

                                dialog.show();
                            }
                        }
                ));
            }
        };
    }
}