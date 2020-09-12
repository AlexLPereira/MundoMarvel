package br.usjt.ads20.mundomarvel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetalhePersonagemActivity extends AppCompatActivity {
    private TextView nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalhe_personagem);
        nome = (TextView) findViewById(R.id.personagem_selecionado);
        Intent intent = getIntent();
        nome.setText(intent.getStringExtra(ListarPersonagemActivity.DESCRICAO));

    }
}