package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class juego2 extends AppCompatActivity {

    private String player1Name;
    private String player2Name;

    private GridLayout gridLayout;
    private Button[][] buttons = new Button[3][3];
    private TextView textViewTurno;
    private TextView textViewGanador;
    private Button buttonReiniciar;

    private boolean turnoJugador1 = true;
    private boolean juegoTerminado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego2);

        player1Name = getIntent().getStringExtra("player1Name");
        player2Name = getIntent().getStringExtra("player2Name");

        gridLayout = findViewById(R.id.gridLayout);
        textViewTurno = findViewById(R.id.textViewTurno);
        textViewGanador = findViewById(R.id.textViewGanador);
        buttonReiniciar = findViewById(R.id.buttonReiniciar);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onButtonClick(view);
                    }
                });
            }
        }

        setTurnoText();

        buttonReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reiniciarJuego();
            }
        });
    }

    private void onButtonClick(View view) {
        if (!((Button) view).getText().toString().equals("") || juegoTerminado)
            return;

        if (turnoJugador1) {
            ((Button) view).setText("X");
        } else {
            ((Button) view).setText("O");
        }

        if (verificarGanador()) {
            juegoTerminado = true;
            mostrarGanador();
        } else if (tableroLleno()) {
            juegoTerminado = true;
            textViewGanador.setText("¡Empate!");
            textViewGanador.setVisibility(View.VISIBLE);
            buttonReiniciar.setVisibility(View.VISIBLE);
        } else {
            turnoJugador1 = !turnoJugador1;
            setTurnoText();
        }
    }

    private boolean verificarGanador() {
        String[][] tablero = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (tablero[i][0].equals(tablero[i][1]) && tablero[i][1].equals(tablero[i][2]) && !tablero[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (tablero[0][i].equals(tablero[1][i]) && tablero[1][i].equals(tablero[2][i]) && !tablero[0][i].equals("")) {
                return true;
            }
        }
        if (tablero[0][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][2]) && !tablero[0][0].equals("")) {
            return true;
        }
        if (tablero[0][2].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][0]) && !tablero[0][2].equals("")) {
            return true;
        }

        return false;
    }

    private boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().toString().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void setTurnoText() {
        if (turnoJugador1) {
            textViewTurno.setText("Turno de " + player1Name);
        } else {
            textViewTurno.setText("Turno de " + player2Name);
        }
    }

    private void mostrarGanador() {
        if (turnoJugador1) {
            textViewGanador.setText("Ganador: " + player1Name);
        } else {
            textViewGanador.setText("Ganador: " + player2Name);
        }
        textViewGanador.setVisibility(View.VISIBLE);
        buttonReiniciar.setVisibility(View.VISIBLE);
    }

    private void reiniciarJuego() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }

        textViewGanador.setVisibility(View.GONE);
        buttonReiniciar.setVisibility(View.GONE);
        turnoJugador1 = true;
        juegoTerminado = false;
        setTurnoText();
    }
}
