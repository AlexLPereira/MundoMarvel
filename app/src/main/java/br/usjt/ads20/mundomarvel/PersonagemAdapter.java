package br.usjt.ads20.mundomarvel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.Hashtable;

import br.usjt.ads20.mundomarvel.model.Personagem;

public class PersonagemAdapter extends BaseAdapter implements SectionIndexer {
     Context context;
     Personagem[] personagem;
     Object[] sectionHeaders;
    Hashtable<Integer, Integer> positionForSectionMap;
    Hashtable<Integer, Integer> sectionForPositionMap;

    public PersonagemAdapter(Context context, Personagem[] personagem) {
        this.context = context;
        this.personagem = personagem;
        sectionHeaders = SectionIndexBuilder.buildSectionHeaders(personagem);
        positionForSectionMap = SectionIndexBuilder.buildPositionForSectionMap(personagem);
        sectionForPositionMap = SectionIndexBuilder.buildSectionForPositionMap(personagem);

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
            TextView Detalhe1Personagem = (TextView) view.findViewById(R.id.detalhe1_personagem);
            TextView Detalhe2Personagem = (TextView) view.findViewById(R.id.detalhe2_personagem);
            TextView Detalhe3Personagem = (TextView) view.findViewById(R.id.detalhe3_personagem);
            view.setTag(new ViewHolder(posterpersonagem, nomepersonagem, Detalhe1Personagem, Detalhe2Personagem, Detalhe3Personagem));
        }
        Drawable drawable = Util.getDrawable(context,
                personagem[i].getPosterPath().substring(0,
                        personagem[i].getPosterPath().length()-4).toLowerCase());
        ViewHolder viewHolder = (ViewHolder)view.getTag();
        viewHolder.getposterPersonagem().setImageDrawable(drawable);
        viewHolder.getnomePersonagem().setText(personagem[i].getTitulo());
        //Locale locale = new Locale("pt", "BR");
        String lbl_gen = context.getResources().getString(R.string.lbl_genero);
        String lbl_lanc = context.getResources().getString(R.string.lbl_lancamento);
        String lbl_pop = context.getResources().getString(R.string.lbl_popularidade);
        viewHolder.getDetalhe1Personagem().setText(String.format("%s: %s", lbl_gen, personagem[i].getGenero().getNome()));
        viewHolder.getDetalhe2Personagem().setText(String.format("%s: %td-%tb-%ty", lbl_lanc,
                personagem[i].getDataLancamento(), personagem[i].getDataLancamento(),
                personagem[i].getDataLancamento()));
        viewHolder.getDetalhe3Personagem().setText(String.format("%s: %.1f", lbl_pop, personagem[i].getPopularidade()));




        return view;
    }

    @Override
    public Object[] getSections() {
        System.out.println(sectionHeaders);
        return sectionHeaders;
    }

    @Override
    public int getPositionForSection(int i) {
        return positionForSectionMap.get(i).intValue();
    }

    @Override
    public int getSectionForPosition(int i) {
        return sectionForPositionMap.get(i).intValue();
    }
}