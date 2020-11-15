package com.gtappdevelopers.gfg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.idCourseRV);
        //created new array list..
        recyclerDataArrayList=new ArrayList<>();

        //added data to array list
        recyclerDataArrayList.add(new RecyclerData("DSA",R.drawable.ic_gfglogo));
        recyclerDataArrayList.add(new RecyclerData("JAVA",R.drawable.ic_gfglogo));
        recyclerDataArrayList.add(new RecyclerData("C++",R.drawable.ic_gfglogo));
        recyclerDataArrayList.add(new RecyclerData("Python",R.drawable.ic_gfglogo));
        recyclerDataArrayList.add(new RecyclerData("Node Js",R.drawable.ic_gfglogo));

        //added data from arraylist to adapter class.
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(recyclerDataArrayList,this);
        //setting grid layout manager to implement grid view.
        // in this method '2' represents number of colums to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        //at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
}