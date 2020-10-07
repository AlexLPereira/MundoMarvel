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
import br.usjt.ads20.mundomarvel.model.Poster;



public class ListarPersonagemActivity extends AppCompatActivity {
        public static String PERSONAGEM = "br.usjt.ads20.mundomarvel.personagem";
    Personagem[] lista;
    Poster[] posters;
    Activity atividade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_personagem);
        atividade = this;
        final Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);
        ArrayList<Personagem> personagens = (ArrayList<Personagem>) intent.getSerializableExtra(MainActivity.PERSONAGENS);
        Dados.setPersonagens(personagens);

        lista = Dados.buscaPersonagem(chave);
        posters = Dados.buscaPosters(chave);

        BaseAdapter adapter = new PersonagemAdapter(this, lista/*, posters*/);


        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(atividade, DetalhePersonagemActivity.class);
                intent1.putExtra(PERSONAGEM, lista[i]);
                startActivity(intent1);
            }

        });

    }

}