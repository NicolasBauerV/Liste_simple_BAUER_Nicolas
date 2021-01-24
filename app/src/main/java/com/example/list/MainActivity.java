package com.example.list;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Associer votre view avec son instance
        ListView maListe = (ListView) findViewById(R.id.maliste);
        //Travailler avec les ressources du projet
        //Votre objet ressources
        Resources res = getResources();
        //Tableau des chaînes de caractères provenant du tableau défini dans strings.xml
        String[] MesValeurs = res.getStringArray(R.array.montableau);
        //Remplir l’adaptateur
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MesValeurs);
        //Lier données à la liste
        maListe.setAdapter(adapter);

        Class[] classes = {Basket.class, Foot.class, Handball.class, Hockey.class, E_Sport.class};

        maListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), MesValeurs[position] + ", index = " + position, Toast.LENGTH_SHORT).show();
                if (MesValeurs[position].equals((String) maListe.getItemAtPosition(position))) {
                    Intent intent = new Intent(getApplicationContext(), classes[position]);
                    startActivity(intent);
                }
            }
        });

    }
}