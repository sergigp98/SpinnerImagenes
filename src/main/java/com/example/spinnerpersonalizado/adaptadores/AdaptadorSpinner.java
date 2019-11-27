package com.example.spinnerpersonalizado.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spinnerpersonalizado.R;
import com.example.spinnerpersonalizado.utils.Marca;

import java.util.ArrayList;

public class AdaptadorSpinner extends BaseAdapter {

    ArrayList<Marca> listaDatos;
    Context context;

    public AdaptadorSpinner(ArrayList<Marca> listaDatos, Context c) {
        this.listaDatos = listaDatos;
        context = c;
    }

    //numero de filas o elementos que tendra el spinner
    //del array de elementos (de marcas)
    @Override
    public int getCount() {
        return listaDatos.size();
    }

    //obtiene el objeto de la posicion correspondiente (position)
    //lista.get(i);
    @Override
    public Object getItem(int position) {
        return listaDatos.get(position);
    }

    //obtiene el id del elemento de la posicion correspondiente
    //lista.get(i).get(ID);
    @Override
    public long getItemId(int position) {
        return position;
    }

    //renderiza cada una de las filas
    //traigo el xml creado

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.spinner_personalizado,parent,false);
        //El metodo se ejecuta una vez por cada fila


        Marca mActual = listaDatos.get(position);
        TextView nombre = convertView.findViewById(R.id.texto_Spinner);
        ImageView imagen = convertView.findViewById(R.id.imagenSpinner);

        nombre.setText(mActual.getNombre());
        imagen.setImageResource(mActual.getLogo());



        return convertView;
    }
}
