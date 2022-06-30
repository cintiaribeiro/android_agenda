package com.cintia.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cintia.agenda.R;
import com.cintia.agenda.DAO.AlunoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListAlunoActivity extends AppCompatActivity {

    private final AlunoDAO alunoDAO = new AlunoDAO();
    public static final String TITULO_APPBAR = "Lista de Alunos";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TITULO_APPBAR);
        setContentView(R.layout.activity_list_aluno);
        configFabNovoAluno();
    }

    private void configFabNovoAluno() {
        FloatingActionButton btnNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        btnNovoAluno.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        abreFormAluno();
                    }
                }
        );
    }

    private void abreFormAluno() {
        startActivity( new Intent(this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configLista();
    }

    private void configLista() {
        ListView listAlunos = findViewById(R.id.activity_lista_alunos_list_view);
        listAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                alunoDAO.todos()));
    }
}
