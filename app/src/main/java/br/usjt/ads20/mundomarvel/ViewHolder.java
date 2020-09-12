package br.usjt.ads20.mundomarvel;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private ImageView posterPersonagem;
    private TextView nomePersonagem, detalhePersonagem;

    public ViewHolder(ImageView posterPersonagem, TextView nomePersonagem, TextView detalhePersonagem) {
        this.posterPersonagem = posterPersonagem;
        this.nomePersonagem = nomePersonagem;
        this.detalhePersonagem = detalhePersonagem;
    }

    public ImageView getposterPersonagem() {
        return posterPersonagem;
    }

    public void setposterPersonagem(ImageView posterPersonagem) {
        this.posterPersonagem = posterPersonagem;
    }

    public TextView getnomePersonagem() {
        return nomePersonagem;
    }

    public void setnomePersonagem(TextView nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public TextView getdetalhePersonagem() {
        return detalhePersonagem;
    }

    public void setdetalhePersonagem(TextView detalhePersonagem) {
        this.detalhePersonagem = detalhePersonagem;
    }
}
