package br.usjt.ads20.mundomarvel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText txtNome;
    public static final String NOME = "br.usjt.ads20.mundomarvel";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = (EditText)findViewById(R.id.busca_fila);
    }

    public void BuscarPersonagem(View view) {
        String nome = txtNome.getText().toString();
        Intent intent = new Intent(this, ListarPersonagemActivity.class);
        intent.putExtra(NOME, nome);
        startActivity(intent);
    }
}