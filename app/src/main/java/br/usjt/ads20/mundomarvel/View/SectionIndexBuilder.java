package br.usjt.ads20.mundomarvel.View;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.TreeSet;

import br.usjt.ads20.mundomarvel.model.Personagem;

public class SectionIndexBuilder {

    public static Object[] buildSectionHeaders(Personagem[] personagens) {
        ArrayList<String> results = new ArrayList<>();
        TreeSet<String> used = new TreeSet<>();


        if(personagens != null) {
            for (Personagem personagem : personagens) {
                String letter = personagem.getTitulo().substring(0, 1);
                if (!used.contains(letter)) {
                    results.add(letter);
                }
                used.add(letter);
            }
        }
        return results.toArray(new Object[0]);
    }

    public static Hashtable<Integer, Integer> buildPositionForSectionMap(Personagem[] personagens) {
        Hashtable<Integer, Integer> results = new Hashtable<>();
        TreeSet<String> used = new TreeSet<>();
        int section = -1;

        if(personagens != null){
            for(int i = 0; i < personagens.length; i++){
                String letter = personagens[i].getTitulo().substring(0,1);
                if(!used.contains(letter)){
                    section++;
                    used.add(letter);
                    results.put(section, i);
                }
            }
        }
        return results;
    }

    public static Hashtable<Integer, Integer> buildSectionForPositionMap(Personagem[] personagens) {
        Hashtable<Integer, Integer> results = new Hashtable<>();
        TreeSet<String> used = new TreeSet<>();
        int section = -1;

        if(personagens != null){
            for(int i = 0; i < personagens.length; i++){
                String letter = personagens[i].getTitulo().substring(0,1);
                if(!used.contains(letter)){
                    section++;
                    used.add(letter);
                }
                results.put(i, section);
            }
        }
        return results;
    }
}
