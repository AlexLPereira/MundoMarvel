package br.usjt.ads20.mundomarvel.model;

import android.provider.BaseColumns;

public final class PersonagemContract {
    public static abstract class PersonagemEntry implements BaseColumns {
            public static final String TABLE_NAME = "personagem";
            public static final String COLUMN_NAME_ID_PERSONAGEM = "idPersonagem";
            public static final String COLUMN_NAME_TITULO = "titulo";
            public static final String COLUMN_NAME_DESCRICAO = "descricao";
            public static final String COLUMN_NAME_POSTER_PATH = "posterPath";
            public static final String COLUMN_NAME_BACKDROP_PATH = "backdropPath";
            public static final String COLUMN_NAME_IMG_POSTER = "imgPoster";
            public static final String COLUMN_NAME_IMG_BACKDROP = "imgBackdrop";
        }

}
