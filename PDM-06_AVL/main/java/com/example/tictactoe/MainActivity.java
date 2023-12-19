package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonGo = findViewById(R.id.buttonGo);

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String player1Name = ((EditText) findViewById(R.id.editTextPlayer1)).getText().toString();
                String player2Name = ((EditText) findViewById(R.id.editTextPlayer2)).getText().toString();

                Intent intent = new Intent(MainActivity.this, juego2.class);
                intent.putExtra("player1Name", player1Name);
                intent.putExtra("player2Name", player2Name);
                startActivity(intent);
            }
        });
    }
}
