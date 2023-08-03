package com.edu.ue.practicaguiada1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Impresion extends AppCompatActivity {

    private TextView tvCantidad;
    private TextView tvInteres;
    private TextView tvTotal;
    private TextView tvSuma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impresion);

        tvCantidad = findViewById(R.id.tvCantidad);
        tvInteres = findViewById(R.id.tvInteres);
        tvTotal = findViewById(R.id.tvTotal);
        tvSuma = findViewById(R.id.tvSuma);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Float cantidad = extras.getFloat("Cantidad");
            Float interes = extras.getFloat("Intereses");
            Double resultado = extras.getDouble("Resultado");

            tvCantidad.setText("La cantidad de dinero es: $" + cantidad);
            tvInteres.setText("La tasa de interes es de: " + interes +"%");
            tvTotal.setText("Los intereses a pagar son: $" + resultado);
            tvSuma.setText("El total a pagar es: $" + (cantidad + resultado));
        }
    }
}