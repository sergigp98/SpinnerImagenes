package com.example.spinnerpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.spinnerpersonalizado.adaptadores.AdaptadorSpinner;
import com.example.spinnerpersonalizado.utils.Marca;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ArrayList<Marca> listaMarcas;
    AdaptadorSpinner adaptadorSpinner;
    ImageView imagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarLista();
        acciones();
    }

    private void acciones() {
        spinner.setOnItemSelectedListener(this);
    }

    private void rellenarLista() {
        spinner.setAdapter(adaptadorSpinner);
        listaMarcas.add(new Marca("Ford", R.drawable.ford));
        listaMarcas.add(new Marca("BMW", R.drawable.bmw));
        listaMarcas.add(new Marca("AUDI", R.drawable.audi));
        listaMarcas.add(new Marca("MERCEDES", R.drawable.mercedes));
        listaMarcas.add(new Marca("TOYOTA", R.drawable.toyota));
        listaMarcas.add(new Marca("NISSAN", R.drawable.nissan));
        listaMarcas.add(new Marca("MINI", R.drawable.mini));
        listaMarcas.add(new Marca("VOLKSVAGEN", R.drawable.vw));
        listaMarcas.add(new Marca("Otros", R.drawable.car_other));
        listaMarcas.add(new Marca("UP", R.drawable.up));
        adaptadorSpinner.notifyDataSetChanged();
    }


    private void instancias() {
        spinner = findViewById(R.id.spinnerPersonalizado);
        listaMarcas = new ArrayList();
        adaptadorSpinner = new AdaptadorSpinner(listaMarcas,getApplicationContext());
        imagenes = findViewById(R.id.marcas);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Marca marca = (Marca) adaptadorSpinner.getItem(position);
        imagenes.setImageResource(marca.getLogo());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
