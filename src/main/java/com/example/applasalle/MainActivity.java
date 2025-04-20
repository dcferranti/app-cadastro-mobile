package com.example.applasalle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextEmail;
    private RadioGroup radioGroupSexo;
    private Spinner spinnerEscolaridade;
    private Button buttonCadastrar;

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

        editTextNome = findViewById(R.id.editTextText);
        editTextEmail = findViewById(R.id.editTextText2);
        radioGroupSexo = findViewById(R.id.radioGroup);
        spinnerEscolaridade = findViewById(R.id.spinnerEscolaridade);
        buttonCadastrar = findViewById(R.id.button3);

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarCliente();
            }
        });
    }

    private void cadastrarCliente() {
        String nome = editTextNome.getText().toString();
        String email = editTextEmail.getText().toString();
        if (email.isEmpty()) {
            Toast.makeText(this, "Digite seu e-mail.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!email.contains("@")) {
            Toast.makeText(this, "Digite um e-mail válido!", Toast.LENGTH_SHORT).show();
            return;
        }
        String sexo = "";
        int selectedRadioButtonId = radioGroupSexo.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            sexo = selectedRadioButton.getText().toString();
        }
        String escolaridade = spinnerEscolaridade.getSelectedItem().toString();

        if (escolaridade.equals("Selecione a escolaridade")) {
            Toast.makeText(this, "Selecione a escolaridade!", Toast.LENGTH_SHORT).show();
            return;
        }

        String mensagem = "Nome: " + nome + "\n" +
                "Email: " + email + "\n" +
                "Sexo: " + sexo + "\n" +
                "Escolaridade: " + escolaridade;

        Toast.makeText(this, "Cadastro concluído!\n", Toast.LENGTH_LONG).show();
    }
}