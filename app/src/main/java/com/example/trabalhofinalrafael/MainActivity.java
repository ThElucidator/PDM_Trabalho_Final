package com.example.trabalhofinalrafael;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnAbrirMesa;
    private ListView lvMesaAberta;
    private List<String> MesasA = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MesasA.add("teste");

        this.lvMesaAberta = findViewById(R.id.lvMesaAberta);

        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MesasA);
        lvMesaAberta.setAdapter(Adapter);

        this.MostrarMesasAbertas();
    }

    public void MostrarMesasAbertas(){


        ConexaoMySQL c = new ConexaoMySQL(this);



    }
}