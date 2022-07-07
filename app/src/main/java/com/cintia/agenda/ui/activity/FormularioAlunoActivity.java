package com.cintia.agenda.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cintia.agenda.R;
import com.cintia.agenda.model.Aluno;
import com.cintia.agenda.DAO.AlunoDAO;

import java.io.Serializable;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo aluno";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    final AlunoDAO alunoDAO = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(TITULO_APPBAR);
        setContentView(R.layout.activity_formulario_aluno);
        initCampos();
        configBtnSalvar();

        Intent dados = getIntent();
        Aluno aluno = (Aluno) dados.getSerializableExtra("aluno");

        if(aluno != null){
            campoNome.setText(aluno.getNome());
            campoTelefone.setText(aluno.getTelefone());
            campoEmail.setText(aluno.getEmail());
        }


    }

    private void configBtnSalvar() {
        Button btnSalvar = findViewById(R.id.activity_formulario_aluno_btn_salvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno alunoCriado = criAluno();
                salva(alunoCriado);
            }
        });
    }

    private void initCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void salva(Aluno aluno) {
        alunoDAO.salva(aluno);
        finish();
    }

    @NonNull
    private Aluno criAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        Aluno alunoCriado = new Aluno(nome, telefone, email);
        return alunoCriado;
    }
}