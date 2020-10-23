package br.usjt.ads20.mundomarvel.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

import java.util.ArrayList;


import static br.usjt.ads20.mundomarvel.model.PersonagemContract.PersonagemEntry;


public class PersonagemDb {
    PersonagemDbHelper dbHelper;

    public PersonagemDb(Context contexto){
        dbHelper = new PersonagemDbHelper(contexto);
    }

    public void salvarPersonagem(ArrayList<Personagem> personagens) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //limpar a base - delete sme Where!
        db.delete(PersonagemContract.PersonagemEntry.TABLE_NAME, null, null);

        for (Personagem personagem:personagens){
            ContentValues values = new ContentValues();
            values.put(PersonagemContract.PersonagemEntry.COLUMN_NAME_ID_PERSONAGEM, personagem.getId());
            values.put(PersonagemContract.PersonagemEntry.COLUMN_NAME_TITULO, personagem.getTitulo());
            values.put(PersonagemContract.PersonagemEntry.COLUMN_NAME_DESCRICAO, personagem.getDescricao());
            values.put(PersonagemContract.PersonagemEntry.COLUMN_NAME_POSTER_PATH, personagem.getPosterPath());
            values.put(PersonagemContract.PersonagemEntry.COLUMN_NAME_BACKDROP_PATH, personagem.getBackdropPath());

            db.insert(PersonagemContract.PersonagemEntry.TABLE_NAME, null, values);
        }
        db.close();
    }

    public ArrayList<Personagem> buscarPersonagens() {
        ArrayList<Personagem> personagens = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] colunas = {
                PersonagemEntry.COLUMN_NAME_ID_PERSONAGEM,
                PersonagemEntry.COLUMN_NAME_TITULO,
                PersonagemEntry.COLUMN_NAME_DESCRICAO,
                PersonagemEntry.COLUMN_NAME_POSTER_PATH,
                PersonagemEntry.COLUMN_NAME_BACKDROP_PATH,
        };
        String where = null;
        String[] conditions = null;
        String order = PersonagemEntry.COLUMN_NAME_TITULO;

        Cursor c = db.query(PersonagemEntry.TABLE_NAME, colunas, where, conditions, order, null, null);

        while (c.moveToNext()) {
            Personagem personagem = new Personagem();
            personagem.setId(c.getInt(c.getColumnIndex(PersonagemEntry.COLUMN_NAME_ID_PERSONAGEM)));
            personagem.setTitulo(c.getString(c.getColumnIndex(PersonagemEntry.COLUMN_NAME_TITULO)));
            personagem.setDescricao(c.getString(c.getColumnIndex(PersonagemEntry.COLUMN_NAME_DESCRICAO)));

            personagem.setPosterPath(c.getString(c.getColumnIndex(PersonagemEntry.COLUMN_NAME_POSTER_PATH)));
            personagem.setBackdropPath(c.getString(c.getColumnIndex(PersonagemEntry.COLUMN_NAME_BACKDROP_PATH)));
            personagens.add(personagem);
        }
        c.close();
        db.close();
        return personagens;
    }


    public void atualizaPosters(ArrayList<Poster> posters){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selecao = PersonagemEntry.COLUMN_NAME_ID_PERSONAGEM + "=?";
        String[] selectionArgs = new String[1];
        for (Poster poster:posters){
            selectionArgs[0] = ""+poster.getId();
            ContentValues values = new ContentValues();
            values.put(PersonagemEntry.COLUMN_NAME_IMG_POSTER, getPictureOfArray(poster.getPoster()));
            db.update(PersonagemEntry.TABLE_NAME, values, selecao, selectionArgs);
        }
    }

    public ArrayList<Poster> buscaPosters(){
        ArrayList<Poster> posters = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] colunas = {
                PersonagemEntry.COLUMN_NAME_ID_PERSONAGEM,
                PersonagemEntry.COLUMN_NAME_TITULO,
                PersonagemEntry.COLUMN_NAME_IMG_POSTER
        };
        String ordem = null;
        String where = null;
        String[] conditions = null;

        Cursor c = db.query(PersonagemEntry.TABLE_NAME, colunas, where, conditions, ordem, null, null);
        while (c.moveToNext()){
            Poster poster = new Poster();
            poster.setId(c.getInt(c.getColumnIndex(PersonagemEntry.COLUMN_NAME_ID_PERSONAGEM)));
            poster.setTitulo(c.getString(c.getColumnIndex(PersonagemEntry.COLUMN_NAME_TITULO)));
            poster.setPoster(getBitmapFromByte(c.getBlob(c.getColumnIndex(PersonagemEntry.COLUMN_NAME_IMG_POSTER))));

            posters.add(poster);
        }
        c.close();
        db.close();

        return posters;
    }


    private byte[] getPictureOfArray(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private Bitmap getBitmapFromByte(byte[] image){
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }


}
