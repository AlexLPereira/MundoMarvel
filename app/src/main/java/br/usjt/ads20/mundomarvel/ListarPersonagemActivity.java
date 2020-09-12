package br.usjt.ads20.mundomarvel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;


import br.usjt.ads20.mundomarvel.model.Dados;
import br.usjt.ads20.mundomarvel.model.Personagem;

public class ListarPersonagemActivity extends AppCompatActivity {
    public static String DESCRICAO = "br.usjt.ads20.mundomarvel.descricao";
    Personagem[] lista;
    Activity atividade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_personagem);
        atividade = this;
        final Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);
        lista = Dados.buscaPersonagem(chave);
        BaseAdapter adapter = new PersonagemAdapter(this, lista);


        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(atividade, DetalhePersonagemActivity.class);
                intent1.putExtra(DESCRICAO, lista[i].getTitulo());
                startActivity(intent1);
            }
        });

    }



}