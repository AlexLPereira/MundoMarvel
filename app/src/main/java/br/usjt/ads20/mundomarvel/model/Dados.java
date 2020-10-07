package br.usjt.ads20.mundomarvel.model;

import android.icu.text.MessagePattern;
import android.os.strictmode.CleartextNetworkViolation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Dados {
    private static ArrayList<Personagem> personagens;
    private static ArrayList<Poster> imagens;

    public static ArrayList<Poster> getImagens() {
        return imagens;
    }

    public static void setImagens(ArrayList<Poster> imagens) {
        Dados.imagens = imagens;
    }

    public static void setPersonagens(ArrayList<Personagem> pPersonagens) {
        personagens = pPersonagens;
    }

    public static Personagem[] buscaPersonagem(String chave) {
        ArrayList<Personagem> lista = personagens;
        ArrayList<Personagem>  filtro;
        Personagem[] personagens;
        if (chave == null || chave.length() == 0) {
            filtro = lista;
        } else {
            filtro = new ArrayList<>();
            for (Personagem personagem : lista) {
                String nome = personagem.getTitulo();
                if (nome.toUpperCase().contains(chave.toUpperCase())) {
                    filtro.add(personagem);
                }
            }
        }
        personagens = filtro.toArray(new Personagem[0]);
        Arrays.sort(personagens);
        return personagens;

    }

    public static Poster[] buscaPosters(String chave) {
        ArrayList<Poster> lista = imagens;
        ArrayList<Poster> filtro;
        Poster[] posters;
        if (chave == null || chave.length() == 0){
            filtro = lista;
        } else {
            filtro = new ArrayList<>();
            for (Poster poster: lista){
                String nome = poster.getTitulo();
                if (nome.toUpperCase().contains(chave.toUpperCase())){
                    filtro.add(poster);
                }

            }
        }
        posters = filtro.toArray(new Poster[0]);
        Arrays.sort(posters);


        return posters;
    }


}
