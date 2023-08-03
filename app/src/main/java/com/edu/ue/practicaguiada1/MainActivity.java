package com.edu.ue.practicaguiada1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etCantidad;
    private EditText etInteres;
    private TextView tvResultadoDias;
    private SeekBar barraDias;
    private Button btnCalcular;
    private Button btnLimpiar;
    private Button btnImpresion;
    private TextView tvResultado;
    public double total;
    private Float cantidad;
    private Float interes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.etCantidad =findViewById(R.id.etCantidad);
        this.etInteres =findViewById(R.id.etInteres);
        this.btnImpresion = findViewById(R.id.btnImpresion);

        initializeVariables();

    tvResultadoDias.setText(barraDias.getProgress()+"/"+barraDias.getMax());
    barraDias.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        int progress = 0;

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            progress = progress+5;
            tvResultadoDias.setText(barraDias.getProgress()+"/"+barraDias.getMax());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    });
        btnImpresion.setOnClickListener(v -> {
            Log.d("MainActivity", "Cantidad: " + cantidad);
            Log.d("MainActivity", "Intereses: " + interes);
            Log.d("MainActivity", "Resultado: " + total);

            Intent intent = new Intent(MainActivity.this, Impresion.class);
            intent.putExtra("Cantidad", cantidad);
            intent.putExtra("Intereses", interes);
            intent.putExtra("Resultado", total);
            startActivity(intent);
        });
    }


    public void calcular(View view){
        int porcentaje = 100;
        cantidad = Float.parseFloat(this.etCantidad.getText().toString());
        interes = Float.parseFloat(this.etInteres.getText().toString());
        float resultadoDias = Float.parseFloat(String.valueOf(this.barraDias.getProgress()));

        total = ((cantidad * interes * resultadoDias)/ (365 * porcentaje));
        Toast.makeText(this, "El valor del interés es: "+total, Toast.LENGTH_SHORT).show();
        tvResultado.setText("El valor del interés es: $"+total);
    }



    public void limpiar(View v){
        etCantidad.setText("");
        etInteres.setText("");
        barraDias.setProgress(0);
        tvResultado.setText("");
    }
    private void initializeVariables() {
        etCantidad = findViewById(R.id.etCantidad);
        etInteres = findViewById(R.id.etInteres);
        tvResultadoDias = findViewById(R.id.tvResultadoDias);
        barraDias = findViewById(R.id.barraDias);
        btnCalcular = findViewById(R.id.btnCacular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnImpresion = findViewById(R.id.btnImpresion);
        tvResultado = findViewById(R.id.tvResultado);
    }
}