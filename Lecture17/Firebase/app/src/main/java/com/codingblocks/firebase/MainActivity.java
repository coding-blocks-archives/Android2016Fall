package com.codingblocks.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.textView);

        String token = getSharedPreferences("firebase", MODE_PRIVATE).getString("refreshToken", "NOT GENERATED YET");

        tv.setText(token);

        FirebaseDatabase myDb = FirebaseDatabase.getInstance();
        DatabaseReference movieRef = myDb.getReference("movies");
        movieRef.setValue("List of movies");

        movieRef.child("ms-dhoni").child("name").setValue("M.S. Dhoni");
        movieRef.child("ms-dhoni").child("tagline").setValue("The Untold Story");
        movieRef.child("ms-dhoni").child("rating").setValue(7.5f);

        DatabaseReference newMovie = movieRef.push();
        newMovie.child("name").setValue("A new movie");
        newMovie.child("rating").setValue(8);

        Map<String, Object> movieMap = new HashMap<>();
        movieMap.put("name", "A Wonder Movie");
        movieMap.put("rating", 8);
        movieMap.put("director", "Clint Eastwood");

        Map<String, Object> movieList = new HashMap<>();
        movieList.put("some-movie", movieMap);

        movieRef.push().updateChildren(movieMap);

        movieRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                dataSnapshot.getRef().push();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
