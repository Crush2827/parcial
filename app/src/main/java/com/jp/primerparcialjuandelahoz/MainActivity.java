package com.jp.primerparcialjuandelahoz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etA, etB;
    private TextView tvResultado;
    private ImageView ivOperacion;
    private String operacion = "";
    private double valA = 0, valB = 0, resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etA = findViewById(R.id.etNumeroA);
        etB = findViewById(R.id.etNumeroB);
        tvResultado = findViewById(R.id.tvResultado);
        ivOperacion = findViewById(R.id.ivOperacion);

        findViewById(R.id.btnPotencia).setOnClickListener(v -> realizarCalculo("POTENCIA"));
        findViewById(R.id.btnModulo).setOnClickListener(v -> realizarCalculo("MODULO"));
        findViewById(R.id.btnMaximo).setOnClickListener(v -> realizarCalculo("MAXIMO"));
        findViewById(R.id.btnLimpiar).setOnClickListener(v -> limpiar());
        findViewById(R.id.btnVerDetalle).setOnClickListener(v -> navegarDetalle());
    }

    private void realizarCalculo(String op) {
        try {
            valA = Double.parseDouble(etA.getText().toString());
            valB = Double.parseDouble(etB.getText().toString());
            operacion = op;

            switch (op) {
                case "POTENCIA":
                    resultado = Math.pow(valA, valB);
                    ivOperacion.setImageResource(android.R.drawable.star_on); // Placeholder icono
                    break;
                case "MODULO":
                    if (valB == 0) {
                        Toast.makeText(this, "El número B no puede ser 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    resultado = valA % valB;
                    ivOperacion.setImageResource(android.R.drawable.ic_menu_edit); // Placeholder icono
                    break;
                case "MAXIMO":
                    resultado = Math.max(valA, valB);
                    ivOperacion.setImageResource(android.R.drawable.ic_menu_sort_by_size); // Placeholder icono
                    break;
            }
            tvResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingrese números válidos", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpiar() {
        etA.setText("");
        etB.setText("");
        tvResultado.setText("Resultado: ");
        ivOperacion.setImageDrawable(null);
        operacion = "";
    }

    private void navegarDetalle() {
        if (operacion.isEmpty()) {
            Toast.makeText(this, "Realice una operación primero", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("OPERACION", operacion);
        intent.putExtra("A", valA);
        intent.putExtra("B", valB);
        intent.putExtra("RESULTADO", resultado);
        startActivity(intent);
    }
}
