package br.usjt.ads20.mundomarvel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import br.usjt.ads20.mundomarvel.model.Personagem;
import br.usjt.ads20.mundomarvel.model.PersonagemNetwork;

public class MainActivity extends AppCompatActivity {
    private EditText txtNome;
    public static final String NOME = "br.usjt.ads20.mundomarvel";
    public static final String PERSONAGENS = "br.usjt.ads20.mundomarvel";
    //private String url = "https://gateway.marvel.com:443/v1/public/characters?apikey=";
    private String url = "https://api.themoviedb.org/3/movie/popular?language=pt-BR&page=1&api_key=";
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = (EditText)findViewById(R.id.busca_fila);
        context = this;
    }

    public void BuscarPersonagem(View view) {
       new DownloadJsonPersonagens().execute(url+getKey());
    }

    private class DownloadJsonPersonagens extends AsyncTask<String, Void, ArrayList<Personagem>>{

        @Override
        protected ArrayList<Personagem> doInBackground(String... strings) {
            ArrayList<Personagem> personagens = new ArrayList<>();
            try{
                personagens = PersonagemNetwork.buscarPersonagens(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return personagens;
        }
        protected void onPostExecute(ArrayList<Personagem> personagens){
            Intent intent = new Intent(context, ListarPersonagemActivity.class);
            String nome = txtNome .getText().toString();
            intent.putExtra(NOME, nome);
            intent.putExtra(PERSONAGENS, personagens);
            startActivity(intent);
        }
    }



    //API THE MOVIE DB
    private String getKey(){
        return "INSERIR CHAVE";
    }



    //API MARVEL
    /*private String getKey(){
        return "INSERIR CHAVE";
    }*/


}

//RESOLVER GET