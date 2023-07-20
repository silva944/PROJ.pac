package com.example.siii;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    private List<String> selectedProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializar as views
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Configurar o click listener para o botão de login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obter as credenciais do usuário
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Verificar se as credenciais são válidas
                if (isValidCredentials(username, password)) {
                    // Credenciais válidas, mostrar uma mensagem de sucesso
                    Toast.makeText(MainActivity.this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();

                    // Abrir a página das mesas
                    openMesasPage();
                } else {
                    // Credenciais inválidas, mostrar uma mensagem de erro
                    Toast.makeText(MainActivity.this, "Credenciais inválidas!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Verificar se as credenciais são válidas
    private boolean isValidCredentials(String username, String password) {
        // Aqui você pode implementar a lógica de validação das credenciais
        // Por exemplo, verificar se o usuário e senha correspondem a um registro no banco de dados
        return username.equals("davi") && password.equals("7005");
    }

    // Método para abrir a página das mesas
    private void openMesasPage() {
        setContentView(R.layout.activity_mesas);

        // Configurar os botões das mesas
        Button buttonMesa1 = findViewById(R.id.buttonMesa1);
        Button buttonMesa2 = findViewById(R.id.buttonMesa2);
        Button buttonMesa3 = findViewById(R.id.buttonMesa3);
        Button buttonMesa4 = findViewById(R.id.buttonMesa4);
        Button buttonMesa5 = findViewById(R.id.buttonMesa5);
        Button buttonMesa6 = findViewById(R.id.buttonMesa6);
        Button buttonMesa7 = findViewById(R.id.buttonMesa7);
        Button buttonMesa8 = findViewById(R.id.buttonMesa8);

        // Configurar o click listener para os botões das mesas
        buttonMesa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a nova página
                openNovaPagina(1);
            }
        });

        buttonMesa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a nova página
                openNovaPagina(2);
            }
        });

        buttonMesa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a nova página
                openNovaPagina(3);
            }
        });

        buttonMesa4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a nova página
                openNovaPagina(4);
            }
        });

        buttonMesa5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a nova página
                openNovaPagina(5);
            }
        });

        buttonMesa6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a nova página
                openNovaPagina(6);
            }
        });

        buttonMesa7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a nova página
                openNovaPagina(7);
            }
        });

        buttonMesa8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a nova página
                openNovaPagina(8);
            }
        });
    }

    // Método para abrir a nova página
    private void openNovaPagina(int mesa) {
        setContentView(R.layout.activity_nova_pagina);

        EditText editTextMesa = findViewById(R.id.editTextMesa);
        editTextMesa.setText(String.valueOf(mesa));

        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Voltar para a página das mesas
                openMesasPage();
            }
        });

        Button buttonPagar = findViewById(R.id.buttonPagar);
        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obter os produtos selecionados
                selectedProducts = getSelectedProducts();

                // Abrir a página de pagamento
                Intent intent = new Intent(MainActivity.this, ActivityPagamento.class);
                intent.putStringArrayListExtra("selectedProducts", (ArrayList<String>) selectedProducts);
                startActivity(intent);
            }
        });
    }

    // Método para obter os produtos selecionados
    private List<String> getSelectedProducts() {
        List<String> selectedProducts = new ArrayList<>();

        CheckBox checkBoxCafe = findViewById(R.id.checkBoxCafe);
        CheckBox checkBoxLeite = findViewById(R.id.checkBoxLeite);
        CheckBox checkBoxCha = findViewById(R.id.checkBoxCha);
        CheckBox checkBoxDescafeinado = findViewById(R.id.checkBoxDescafeinado);
        CheckBox checkBoxGalao = findViewById(R.id.checkBoxGalao);
        CheckBox checkBoxCarioca = findViewById(R.id.checkBoxCarioca);
        CheckBox checkBoxImperial = findViewById(R.id.checkBoxImperial);
        CheckBox checkBoxMedia = findViewById(R.id.checkBoxMedia);
        CheckBox checkBoxCerveja = findViewById(R.id.checkBoxCerveja);

        if (checkBoxCafe.isChecked()) {
            selectedProducts.add("Café");
        }

        if (checkBoxLeite.isChecked()) {
            selectedProducts.add("Leite");
        }

        if (checkBoxCha.isChecked()) {
            selectedProducts.add("Chá");
        }

        if (checkBoxDescafeinado.isChecked()) {
            selectedProducts.add("Descafeinado");
        }

        if (checkBoxGalao.isChecked()) {
            selectedProducts.add("Galão");
        }

        if (checkBoxCarioca.isChecked()) {
            selectedProducts.add("Carioca");
        }

        if (checkBoxImperial.isChecked()) {
            selectedProducts.add("Imperial");
        }

        if (checkBoxMedia.isChecked()) {
            selectedProducts.add("Média");
        }

        if (checkBoxCerveja.isChecked()) {
            selectedProducts.add("Cerveja");
        }

        return selectedProducts;
    }

    @Override
    public void onBackPressed() {
        // Verificar se a tela atual é a página das mesas ou a página de pagamento
        if (getCurrentFocus() != null && (getCurrentFocus().getId() == R.id.buttonBack ||
                getCurrentFocus().getId() == R.id.buttonPagar)) {
            // Voltar para a página de login
            setContentView(R.layout.activity_login);
        } else {
            super.onBackPressed();
        }
    }
    public class ActivityPagamento extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main); // Defina o layout activity_main.xml como o layout desta atividade
        }
    }






}
