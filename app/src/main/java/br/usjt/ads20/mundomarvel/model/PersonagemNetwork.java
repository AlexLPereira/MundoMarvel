package br.usjt.ads20.mundomarvel.model;

import androidx.constraintlayout.solver.ArrayLinkedVariables;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PersonagemNetwork {
    public static ArrayList<Personagem> buscarPersonagens(String url) throws IOException {
        ArrayList<Personagem> personagens = new ArrayList<>();
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        String json = response.body().string();
        try {
            JSONObject retorno = new JSONObject(json);
            JSONArray lista = retorno.getJSONArray("results");
            for(int i = 0; i < lista.length(); i++){
                Personagem personagem = new Personagem();
                JSONObject item = (JSONObject) lista.get(i);

                personagem.setId(item.getInt("id"));
                personagem.setTitulo(item.getString("name"));
                personagem.setDescricao(item.getString("description"));

               personagem.setPosterPath(item.getString("path"));
                /*try {
                    personagem.setDataLancamento(formatter.parse(String.valueOf(item.getInt("data"))));
                    } catch (ParseException e) {
                    e.printStackTrace();
                    }*/


                //VERIFICAR SE HÁ GENEROS (HERÓIS, VILÕES, ANTI-HERÓIS) NA API


                }
            }
        catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        return personagens;
        }


    }

