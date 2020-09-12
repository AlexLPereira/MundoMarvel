package br.usjt.ads20.mundomarvel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.usjt.ads20.mundomarvel.model.Personagem;

public class PersonagemAdapter extends BaseAdapter {
    private Context context;
    private Personagem[] personagem;

    public PersonagemAdapter(Context context, Personagem[] personagem) {
        this.context = context;
        this.personagem = personagem;
    }

    @Override
    public int getCount() {
        return personagem.length;
    }

    @Override
    public Object getItem(int i) {
        if (i>=0 && personagem.length>0){
            return personagem[i];
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_personagem, viewGroup, false);
            ImageView posterpersonagem = (ImageView) view.findViewById(R.id.poster_personagem);
            TextView nomepersonagem = (TextView) view.findViewById(R.id.nome_personagem);
            TextView detalhepersonagem = (TextView) view.findViewById(R.id.detalhe_personagem);
            view.setTag(new ViewHolder(posterpersonagem, nomepersonagem, detalhepersonagem));
        }
        ViewHolder holder = (ViewHolder)view.getTag();
        Drawable drawable = Util.getDrawable(context,
                personagem[i].getPosterPath().substring(0,
                        personagem[i].getPosterPath().length()-4).toLowerCase());
        holder.getposterPersonagem().setImageDrawable(drawable);
        holder.getnomePersonagem().setText(personagem[i].getTitulo());
        holder.getdetalhePersonagem().setText(String.format(personagem[i].getGenero().getNome()));



        return view;
    }
}