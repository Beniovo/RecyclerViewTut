package com.example.recyclerviewtut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Person> people;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find recyclerview created
        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        //connect recycler view to layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new PersonAdapter(this, people);

        recyclerView.setAdapter(myAdapter);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("Sparrow", "White", "bus"));
                myAdapter.notifyDataSetChanged();
            }
        });

        //hardcode people list
        people = new ArrayList<Person>();
        people.add(new Person("James", "Ibezim", "bus"));
        people.add(new Person("Sarah", "Pius", "bus"));
        people.add(new Person("Jane", "Bless", "plane"));
        people.add(new Person("Evi", "Uzo", "plane"));
        people.add(new Person("James", "Ibezim", "bus"));
        people.add(new Person("Sarah", "Pius", "bus"));
        people.add(new Person("Jane", "Bless", "plane"));
        people.add(new Person("Evi", "Uzo", "plane"));
        people.add(new Person("James", "Ibezim", "bus"));
        people.add(new Person("Sarah", "Pius", "bus"));
        people.add(new Person("Jane", "Bless", "plane"));
        people.add(new Person("Evi", "Uzo", "plane"));


    }

    @Override
    public void onClickItem(int index) {
        Toast.makeText(this, "Surname: = " + people.get(index).getSurname(),
                                        Toast.LENGTH_SHORT).show();
    }
}
