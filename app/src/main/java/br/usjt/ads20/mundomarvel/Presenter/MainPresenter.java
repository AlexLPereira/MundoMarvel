package br.usjt.ads20.mundomarvel.Presenter;

import br.usjt.ads20.mundomarvel.View.MainView;
import br.usjt.ads20.mundomarvel.model.Personagem;

public class MainPresenter  implements Presenter {
    private Personagem model;
    MainView view;

    public MainPresenter(MainView view){
        this.view = view;
        model = new Personagem(); //Para os testes
    }


    @Override
    public void onCreate() {
        model = new Personagem();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    public void persona(String id, String titulo, String descricao,
                        String posterPath, String backdropPath){
        model.setId(Integer.parseInt(id));
        model.setTitulo(titulo);
        model.setDescricao(descricao);
        model.setPosterPath(posterPath);
        model.setBackdropPath(backdropPath);
        model.toString();
        this.configurarView();
    }

    private void configurarView() {
        view.configurarView(model.getId()+"");
    }


}
