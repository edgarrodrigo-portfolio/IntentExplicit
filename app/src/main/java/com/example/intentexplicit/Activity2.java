package com.example.intentexplicit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {

    CheckBox chkPolitica;
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle container = getIntent().getExtras();
        Persona p = (Persona) container.getSerializable("persona");

        TextView txtNombre = findViewById(R.id.txtNombre);
        TextView txtApellidos = findViewById(R.id.txtApellidos);
        TextView txtEdad = findViewById(R.id.txtEdad);
        TextView txtMatriculado = findViewById(R.id.txtMatriculado);

        txtNombre.setText("Nombre: " + p.getNombre());
        txtApellidos.setText("Apellidos: " + p.getApellidos());
        txtEdad.setText("Edad: " + p.getEdad());
        if (p.isMatriculado()) {
            txtMatriculado.setText("Matriculado: Sí");
        } else {
            txtMatriculado.setText("Matriculado: No");
        }

        chkPolitica = findViewById(R.id.chkPolitica);
        btnSalir = findViewById(R.id.btnSalir);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("aceptada", chkPolitica.isChecked());
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
