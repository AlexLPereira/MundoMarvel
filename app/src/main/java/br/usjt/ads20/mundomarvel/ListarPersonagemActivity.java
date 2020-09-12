package br.usjt.ads20.mundomarvel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarPersonagemActivity extends AppCompatActivity {
    public static String DESCRICAO = "br.usjt.ads20.mundomarvel.descricao";
    ArrayList<String> lista;
    Activity atividade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_personagem);
        atividade = this;
        final Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);
        lista = buscaPersonagens(chave);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(atividade, DetalhePersonagemActivity.class);
                intent1.putExtra(DESCRICAO, lista.get(i));
                startActivity(intent1);
            }
        });

    }

    private ArrayList<String> buscaPersonagens(String chave){
        ArrayList<String> lista = geraListaPersonagens();
        if(chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<String> filtro = new ArrayList<>();
            for(String nome: lista){
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    filtro.add(nome);
                }
            }
            return filtro;
        }

    }
    private ArrayList<String> geraListaPersonagens(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Motoqueiro Fantasma");
        lista.add("Hulk");
        lista.add("Gavião Arqueiro");
        lista.add("Soldado Invernal");
        lista.add("Visão");
        lista.add("Thor");
        lista.add("Drax");
        lista.add("Dr. Estranho");
        lista.add("Vespa");
        lista.add("Viúva Negra");
        return lista;
    }
}