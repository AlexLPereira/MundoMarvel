package br.usjt.ads20.mundomarvel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import br.usjt.ads20.mundomarvel.model.Personagem;
import br.usjt.ads20.mundomarvel.model.PersonagemNetwork;

public class DetalhePersonagemActivity extends AppCompatActivity {
    private TextView nomeDoPersonagem, genero, lancamento, popularidade, descricao;
    private ImageView backdrop;
    private ProgressBar progressBar;
    private Personagem personagem;
    private String imgUrl = "https://image.tmdb.org/t/p/w780"; //****COORRIGIR URL


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalhe_personagem);
        nomeDoPersonagem = (TextView) findViewById(R.id.txt_titulo);
        genero = (TextView) findViewById(R.id.txt_genero);
        lancamento = (TextView) findViewById(R.id.txt_lancamento);
        popularidade = (TextView) findViewById(R.id.txt_popularidade);
        descricao = (TextView) findViewById(R.id.txt_descricao);
        backdrop = (ImageView) findViewById(R.id.poster_personagem);
        Intent intent = getIntent();
        personagem = (Personagem) intent.getSerializableExtra(ListarPersonagemActivity.PERSONAGEM);
        nomeDoPersonagem.setText(personagem.getTitulo());
        descricao.setText(personagem.getDescricao());

        progressBar = (ProgressBar) findViewById(R.id.progressBarDetalhe);
        if (PersonagemNetwork.isConnected(this)) {
            progressBar.setVisibility(View.VISIBLE);
            new DownloadBackdrop().execute(imgUrl + personagem.getBackdropPath());
        } else {
            String msg = this.getResources().getString(R.string.erro_rede);
            Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private class DownloadBackdrop extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap img = null;
            try {
                img = PersonagemNetwork.buscarImagens(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return img;
        }

        protected void onPostExecute(Bitmap img) {
            backdrop.setImageBitmap(img);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}