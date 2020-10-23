package br.usjt.ads20.mundomarvel.model;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static br.usjt.ads20.mundomarvel.model.PersonagemContract.PersonagemEntry;


public class PersonagemDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Personagens.db";
    public static final String SQL_CREATE_PERSONAGEM =
            "CREATE TABLE " + PersonagemEntry.TABLE_NAME + " ( " +
                    PersonagemEntry._ID + " INTERGER PRIMARY KEY," +
                    PersonagemEntry.COLUMN_NAME_ID_PERSONAGEM + " INTEGER," +
                    PersonagemEntry.COLUMN_NAME_TITULO + " TEXT," +
                    PersonagemEntry.COLUMN_NAME_DESCRICAO + " TEXT," +
                    PersonagemEntry.COLUMN_NAME_POSTER_PATH + " TEXT," +
                    PersonagemEntry.COLUMN_NAME_BACKDROP_PATH + " TEXT," +
                    PersonagemEntry.COLUMN_NAME_IMG_POSTER + " BLOB," +
                    PersonagemEntry.COLUMN_NAME_IMG_BACKDROP + " BLOB)";

    public static final String SQL_DROP_PERSONAGEM =
            "DROP TABLE IF EXISTS " + PersonagemEntry.TABLE_NAME;

    public PersonagemDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_PERSONAGEM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
        sqLiteDatabase.execSQL(SQL_DROP_PERSONAGEM);
        sqLiteDatabase.execSQL(SQL_CREATE_PERSONAGEM);
    }

    @Override
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int  oldVersion, int newVersion){
        super.onDowngrade(sqLiteDatabase, oldVersion, newVersion);
        onUpgrade(sqLiteDatabase, newVersion, oldVersion);
    }

}

