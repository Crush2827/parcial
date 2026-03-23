package com.jp.primerparcialjuandelahoz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvOp = findViewById(R.id.tvOpDetalle);
        TextView tvA = findViewById(R.id.tvADetalle);
        TextView tvB = findViewById(R.id.tvBDetalle);
        TextView tvRes = findViewById(R.id.tvResDetalle);
        ImageView ivDetalle = findViewById(R.id.ivIconoDetalle);
        Button btnRegresar = findViewById(R.id.btnRegresar);

        String op = getIntent().getStringExtra("OPERACION");
        double a = getIntent().getDoubleExtra("A", 0);
        double b = getIntent().getDoubleExtra("B", 0);
        double res = getIntent().getDoubleExtra("RESULTADO", 0);

        tvOp.setText("Operación: " + op);
        tvA.setText("A: " + a);
        tvB.setText("B: " + b);
        tvRes.setText("Resultado: " + res);

        // Configurar icono basado en operación
        if ("POTENCIA".equals(op)) ivDetalle.setImageResource(android.R.drawable.star_on);
        else if ("MODULO".equals(op)) ivDetalle.setImageResource(android.R.drawable.ic_menu_edit);
        else if ("MAXIMO".equals(op)) ivDetalle.setImageResource(android.R.drawable.ic_menu_sort_by_size);

        btnRegresar.setOnClickListener(v -> finish());
    }
}
