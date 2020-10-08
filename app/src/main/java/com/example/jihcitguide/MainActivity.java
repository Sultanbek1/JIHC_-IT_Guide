package com.example.jihcitguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    Adapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Part 1 Create RecyclerView
        // 1) create Model class
        // 2) create MyHolder class
        // 3) create Adapter class
        // 4) now in the main class

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // I will create recyclerview in linearLayout


        myAdapter = new Adapter(this, getMyList());
        mRecyclerView.setAdapter(myAdapter);
    }

    private ArrayList<Model> getMyList() {
        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setTitle("Software engineer");
        m.setDescription("This is newsfeed description..");
        m.setImg(R.drawable.sengineer);
        models.add(m);

        m = new Model();
        m.setTitle("Marketer");
        m.setDescription("This is newsfeed description..");
        m.setImg(R.drawable.marketer);
        models.add(m);

        m = new Model();
        m.setTitle("Designer");
        m.setDescription("This is newsfeed description..");
        m.setImg(R.drawable.gdesigner);
        models.add(m);

        m = new Model();
        m.setTitle("Manager");
        m.setDescription("This is newsfeed description..");
        m.setImg(R.drawable.manager);
        models.add(m);

        m = new Model();
        m.setTitle("Accounter");
        m.setDescription("This is newsfeed description..");
        m.setImg(R.drawable.accounting);
        models.add(m);

        m = new Model();
        m.setTitle("Translator");
        m.setDescription("This is newsfeed description..");
        m.setImg(R.drawable.translation);
        models.add(m);

        return models;

        // Part 2
        // 1) Create interface
        // 2) go to in MyHolder class and implements OnclickListener
        // 3) Create new Acitivity
    }
}