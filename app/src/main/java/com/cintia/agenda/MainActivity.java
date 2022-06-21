package com.cintia.agenda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Lista de Alunos");
        setContentView(R.layout.main_activity);

        List<String> alunos = new ArrayList<String>(Arrays.asList("Lucca", "Léo", "Luizinho"));
        ListView listAlunos = findViewById(R.id.activity_main_fab_novo_aluno);
        listAlunos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, alunos));

    }
}
