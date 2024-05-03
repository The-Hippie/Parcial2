package com.example.adaptaon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<ListElement> elements;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init() {
        elements = new ArrayList<>();
        elements.add(new ListElement("Manuel","Sala3","Activo","https://rickandmortyapi.com/api/character/avatar/120.jpeg"));
        elements.add(new ListElement("Marcos","Sala1","Activo","https://rickandmortyapi.com/api/character/avatar/72.jpeg"));
        elements.add(new ListElement("Daniela","Sala3","Desactivado","https://rickandmortyapi.com/api/character/avatar/190.jpeg"));
        elements.add(new ListElement("Pamela","Sala2","Activo","https://rickandmortyapi.com/api/character/avatar/241.jpeg"));
        elements.add(new ListElement("Mary","Sala2","Desactivado","https://rickandmortyapi.com/api/character/avatar/241.jpeg"));
        elements.add(new ListElement("Felipe","Sala2","Activado","https://www.las2orillas.co/wp-content/uploads/2023/08/bmw-carro-nuevo.jpg"));
        elements.add(new ListElement("Mauro","Sala3","Activado","https://img.remediosdigitales.com/1b793d/591aac361b16b/840_560.jpeg"));
        elements.add(new ListElement("Vanessa","Sala1","Activado","https://loscoches.com/wp-content/uploads/2021/04/carros-deportivos-potencia.jpg"));


        ListAdapter listAdapter = new ListAdapter(elements, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(ListElement item) {
                moveToDescription(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.listRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager( this));
        recyclerView.setAdapter(listAdapter);
    }

    public void moveToDescription(ListElement item){
        Intent intent=new Intent(this,DescriptionActivity.class);
        intent.putExtra("ListElement",item);
        startActivity(intent);
    }
}