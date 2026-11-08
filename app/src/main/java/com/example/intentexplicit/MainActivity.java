package com.example.intentexplicit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtNombre, edtApellidos, edtEdad;
    RadioButton rbSi;
    Button btnMostrarInfo;
    TextView txtPolitica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtNombre = findViewById(R.id.edtNombre);
        edtApellidos = findViewById(R.id.edtApellidos);
        edtEdad = findViewById(R.id.edtEdad);
        rbSi = findViewById(R.id.rbSi);
        btnMostrarInfo = findViewById(R.id.btnMostrarInfo);
        txtPolitica = findViewById(R.id.txtPolitica);

        btnMostrarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = edtNombre.getText().toString();
                String apellidos = edtApellidos.getText().toString();
                String edadTexto = edtEdad.getText().toString();

                if (nombre.equals("") || apellidos.equals("") || edadTexto.equals("")) {
                    Toast.makeText(MainActivity.this, "Rellena nombre, apellidos y edad", Toast.LENGTH_LONG).show();
                } else {
                    int edad = Integer.parseInt(edadTexto);
                    boolean matriculado = rbSi.isChecked();

                    // Extra: objeto Persona (Serializable) dentro del Bundle
                    Persona p = new Persona(nombre, apellidos, edad, matriculado);

                    Intent i = new Intent(MainActivity.this, Activity2.class);
                    Bundle container = new Bundle();
                    container.putSerializable("persona", p);
                    i.putExtras(container);
                    startActivityForResult(i, 123); // Crido a Activity2 i quan torni sabre que torno amb el codi 123
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123) {
            boolean aceptada = false;
            if (data != null) {
                aceptada = data.getBooleanExtra("aceptada", false);
            }
            if (aceptada == true) {
                txtPolitica.setText("Política de privacidad: ACEPTADA (true)");
            } else {
                txtPolitica.setText("Política de privacidad: NO aceptada (false)");
            }
        }
    }
}
