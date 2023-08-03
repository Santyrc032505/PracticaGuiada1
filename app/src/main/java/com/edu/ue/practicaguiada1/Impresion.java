package com.edu.ue.practicaguiada1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Impresion extends AppCompatActivity {

    private TextView tvCantidad;
    private TextView tvInteres;

    public Impresion() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impresion);
        TextView tvCantidad = findViewById(R.id.tvCantidad);
        TextView tvInteres = findViewById(R.id.tvInteres);
        recibirResultado();
    }
    @SuppressLint("SetTextI18n")
    private void recibirResultado(){
        Bundle cantidad = getIntent().getExtras();
        if (cantidad != null){
            double cant = (double) cantidad.get("Cantidad");
            tvCantidad.setText("La cantidad de dinero es: "+cant);}
    }
}