package br.usjt.ads20.mundomarvel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import br.usjt.ads20.mundomarvel.model.Dados;
import br.usjt.ads20.mundomarvel.model.Personagem;
import br.usjt.ads20.mundomarvel.model.PersonagemNetwork;
import br.usjt.ads20.mundomarvel.model.Poster;

public class MainActivity extends AppCompatActivity {
    private EditText txtNome;
    private ProgressBar progressBar;
    public static final String NOME = "br.usjt.ads20.mundomarvel";
    public static final String PERSONAGENS = "br.usjt.ads20.mundomarvel";
    private String url = "https://gateway.marvel.com:443/v1/public/characters?apikey=";
    private String imgUrl = "http://i.annihil.us/u/prod/marvel/i/mg/c";  //VERIFICAR DOWNLOAD DAS TUMBS
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = (EditText)findViewById(R.id.busca_fila);
        progressBar = (ProgressBar)findViewById(R.id.progressBarMain);
        context = this;
    }

    public void BuscarPersonagem(View view) {
       if (PersonagemNetwork.isConnected(this)) {
        progressBar.setVisibility(View.VISIBLE);
           String idioma = this.getResources().getString(R.string.idioma);
           String pais = this.getResources().getString(R.string.pais);
           new DownloadJsonPersonagens().execute(String.format(url,idioma,pais) + getKey());
       } else {
           String msg = this.getResources().getString(R.string.erro_rede);
           Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
           toast.show();
       }
       }

    private class DownloadJsonPersonagens extends AsyncTask<String, Void, ArrayList<Personagem>>{

        @Override
        protected ArrayList<Personagem> doInBackground(String... strings) {
            ArrayList<Personagem> personagens = new ArrayList<>();
            ArrayList<Poster> imagens = new ArrayList<>();
            try{
                personagens = PersonagemNetwork.buscarPersonagens(strings[0]);
                for (Personagem personagem: personagens) {
                    String poster = personagem.getPosterPath();
                    Bitmap img = PersonagemNetwork.buscarImagens(imgUrl + poster);
                    Poster p = new Poster();
                    p.setId(personagem.getId());
                    p.setTitulo(personagem.getTitulo());
                    p.setPoster(img);
                    imagens.add(p);
                }
                Dados.setImagens(imagens);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return personagens;
        }

        protected void onPostExecute(ArrayList<Personagem> personagens){
            Intent intent = new Intent(context, ListarPersonagemActivity.class);
            String nome = txtNome .getText().toString();
            intent.putExtra(NOME, nome);
            intent.putExtra(PERSONAGENS, personagens);
            progressBar.setVisibility(View.INVISIBLE);
            startActivity(intent);
        }


    }

    //API MARVEL
    private String getKey(){
        return "2d1d7950e765e65154be65485cc187f2&hash=79b7cca1543741b195b66cf58e18fbf4&ts=1";
    }
}