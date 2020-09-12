package br.usjt.ads20.mundomarvel;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.lang.reflect.Field;

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
