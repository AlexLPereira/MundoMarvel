package br.usjt.ads20.mundomarvel.View;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.lang.reflect.Field;

import br.usjt.ads20.mundomarvel.R;

public class Util {
    public static Drawable getDrawable(Context context, String name){
        Class<?> c = R.drawable.class;
        try {
            Field idField = c.getDeclaredField(name);
            int id = idField.getInt(idField);
            return  context.getResources().getDrawable(id);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return null;
    }
}
