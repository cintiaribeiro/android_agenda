package com.cintia.agenda.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cintia.agenda.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAlunoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Lista de Alunos");
        setContentView(R.layout.activity_list_aluno);

        List<String> alunos = new ArrayList<String>(Arrays.asList("Lucca", "Léo", "Luizinho"));
        ListView listAlunos = findViewById(R.id.activity_lista_alunos_list_view);
        listAlunos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, alunos));

    }
}
