package br.usjt.ads20.mundomarvel.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Dados {

    public static Personagem[] buscaPersonagem(String chave){
        ArrayList<Personagem> lista = criaPersonagens();
        ArrayList<Personagem> filtro;
        Personagem[] personagens;
        if(chave == null || chave.length() == 0){
            filtro = lista;
        } else {
            filtro = new ArrayList<>();
            for(Personagem personagem: lista){
                String nome = personagem.getTitulo();
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    filtro.add(personagem);
                }
            }
        }
        personagens = filtro.toArray(new Personagem[0]);
        Arrays.sort(personagens);
        return personagens;

    }
    public static ArrayList<String> geraListaPersonagens(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Motoqueiro Fantasma");
        lista.add("O Incrível Hulk");
        lista.add("Gavião Arqueiro");
        lista.add("Soldado Invernal");
        lista.add("Visão");
        lista.add("Thor");
        lista.add("Drax,o Destruidor");
        lista.add("Dr. Estranho");
        lista.add("Vespa");
        lista.add("Viúva Negra");
        return lista;
    }

    public static ArrayList<Genero> criaGeneros() {
        ArrayList<Genero> lista = new ArrayList<>();
        lista.add(new Genero(1, "Herói"));
        lista.add(new Genero(2, "Vilão"));
        lista.add(new Genero(3, "Anti-Herói"));

        return lista;
    }

    public static ArrayList<Personagem> criaPersonagens() {
        ArrayList<Personagem> lista = new ArrayList<>();
        Personagem personagem;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        personagem = new Personagem();
        personagem.setPosterPath("motoqueiro_fantasma.jpg");
        personagem.setBackdropPath("gEjNlhZhyHeto6Fy5wWy5Uk3A9D.jpg");
        personagem.setGenero(new Genero(3, "Anti-Herói"));
        personagem.setTitulo("Motoqueiro Fantasma");
        personagem.setDescricao("Johnathon Richard Thomas Blaze era um artista de manobras em motocicletas que aceitou hospedar" +
                "a alma de Zarathos, em troca da salvação de Barton Blaze, pai biológico de Blaze e dono do local de exibições das motos." +
                "Esse Motoqueiro Fantasma fez parte, nos anos 70, do supergrupo conhecido como Campeões, juntamente com Anjo, Homem de Gelo, Viúva Negra, Hércules e Estrela Negra.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1972-08-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPosterPath("dr_estranho.jpg");
        personagem.setBackdropPath("qVygtf2vU15L2yKS4Ke44U4oMdD.jpg");
        personagem.setGenero(new Genero(1, "Herói"));
        personagem.setTitulo("Dr. Estranho");
        personagem.setDescricao("Doutor Stephen Vincent Strange, mais conhecido como Doutor Estranho," +
                "é um super-herói fictício muito poderoso que aparece nos quadrinhos americanos publicados pela Marvel Comics.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1963-07-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPosterPath("drax.jpg");
        personagem.setBackdropPath("fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg");
        personagem.setGenero(new Genero(3, "Anti-Herói"));
        personagem.setTitulo("Drax, o Destruidor");
        personagem.setDescricao("Drax, o Destruidor ( Arthur Douglas ) é um personagem fictício que apareceu nos quadrinhos americanos" +
                "publicados pela Marvel Comics . Criado por Jim Starlin , o personagem apareceu pela primeira vez em The Invincible Iron Man # 55.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1973-02-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPosterPath("gaviao_arqueiro.jpg");
        personagem.setBackdropPath("fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg");
        personagem.setGenero(new Genero(1, "Herói"));
        personagem.setTitulo("Gavião Arqueiro");
        personagem.setDescricao("Gavião Arqueiro (nome original em inglês, Hawkeye) alter-ego de Clint Barton, é um personagem de quadrinhos americanos da Marvel Comics." +
                "Criado por Stan Lee e Don Heck, o herói fez sua primeira aparição em Tales of Suspense #57, antes de se juntar aos Vingadores em Avengers #16." +
                "Desde então, Barton tem sido membro proeminente da equipe.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1964-09-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPosterPath("hulk.jpg");
        personagem.setBackdropPath("fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg");
        personagem.setGenero(new Genero(1, "Herói"));
        personagem.setTitulo("O Incrível Hulk");
        personagem.setDescricao("O \"Gigante Esemeralda\", teve sua primeira aparição junto ao público original dos Estados Unidos na revista The Incredible Hulk n°1," +
                "lançada no mercado americano pela Marvel Comics em maio de 1962, um título solo do personagem," +
                "garantindo-lhe o acesso ao que mais tarde seria popularmente conhecido como Universo Marvel dos quadrinhos/banda desenhada.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1962-05-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPosterPath("soldado_invernal.jpg");
        personagem.setBackdropPath("fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg");
        personagem.setGenero(new Genero(3, "Anti-Herói"));
        personagem.setTitulo("Soldado Invernal");
        personagem.setDescricao("James Buchanan \"Bucky\" Barnes é um super-herói mascarado fictício dos quadrinhos da Marvel Comics." +
                "Foi criado por Joe Simon e Jack Kirby e era o jovem parceiro do Capitão América." +
                "Apareceu pela primeira vez na revista Captain America Comics #1, quando a Marvel se chamava Timely Comics.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1941-03-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPosterPath("thor.jpg");
        personagem.setBackdropPath("fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg");
        personagem.setGenero(new Genero(1, "Herói"));
        personagem.setTitulo("Thor");
        personagem.setDescricao("Thor é um personagem fictício que aparece nas histórias em quadrinhos publicadas pela Marvel Comics." +
                "Baseado no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee, Larry Lieber e Jack Kirby." +
                "Estreando na Era de Prata dos quadrinhos, o personagem apareceu pela primeira vez em Journey into Mystery #83" +
                "Ele é um membro fundador da equipe de heróis Vingadores.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1962-08-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPosterPath("vespa.jpg");
        personagem.setBackdropPath("fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg");
        personagem.setGenero(new Genero(1, "Herói"));
        personagem.setTitulo("Vespa");
        personagem.setDescricao("Vespa (do inglês Wasp) é uma personagem de histórias em quadrinhos da editora norte-americana Marvel Comics." +
                "Além de grande heroína e fundadora dos Vingadores, tornou-se também uma estilista extremamente renomada e altamente conceituada obtendo uma carreira de sucesso no Universo Marvel.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1963-06-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPosterPath("visao.jpg");
        personagem.setBackdropPath("fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg");
        personagem.setGenero(new Genero(1, "Herói"));
        personagem.setTitulo("Visão");
        personagem.setDescricao("O Visão (The Vision em inglês) é um super-herói fictício que aparece nos quadrinhos americanos publicados pela Marvel Comics." +
                                "Ele é um androide e um membro dos Vingadores que apareceu pela primeira vez em The Avengers #57. Ele é vagamente baseado no personagem da Timely Comics (primeiro nome da Marvel) com o mesmo nome.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1968-10-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPosterPath("viuva_negra.jpg");
        personagem.setBackdropPath("fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg");
        personagem.setGenero(new Genero(1, "Herói"));
        personagem.setTitulo("Viúva Negra");
        personagem.setDescricao("Viúva Negra (em inglês Black Widow), também conhecida como Natasha Romanoff é uma personagem das histórias em quadrinhos do Universo Marvel, publicado pela Marvel Comics." +
                "Criada por Stan Lee (edição), Don Rico (roteiro) e Don Heck (desenhos), a personagem apareceu pela primeira vez em Tales of Suspense #52 (abril de 1964)." +
                "A personagem foi introduzida pela primeira vez como uma espiã russa, antagonista do super-herói Homem de Ferro. Mais tarde, ela fugiu para os Estados Unidos, tornando-se uma agente da S.H.I.E.L.D. e membro da equipe de super-heróis Vingadores.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1964-04-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(personagem);

        return lista;
    }
}
