package com.example.tictactoegame;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String turn;
    String[][] board;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onNewGame();
    }

    private void onNewGame() {
        board = new String[3][3];
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                board[row][col] = new String();
        turn = "X";
        count = 0;
    }


    public void onButtonClick(View view) {
        if (view.getId() == R.id.btn_00) {
            handleClick(0, 0, R.id.btn_00);
        }
        if (view.getId() == R.id.btn_01) {
            handleClick(0, 1, R.id.btn_01);
        }
        if (view.getId() == R.id.btn_02) {
            handleClick(0, 2, R.id.btn_02);
        }
        if (view.getId() == R.id.btn_10) {
            handleClick(1, 0, R.id.btn_10);
        }
        if (view.getId() == R.id.btn_11) {
            handleClick(1, 1, R.id.btn_11);
        }
        if (view.getId() == R.id.btn_12) {
            handleClick(1, 2, R.id.btn_12);
        }
        if (view.getId() == R.id.btn_20) {
            handleClick(2, 0, R.id.btn_20);
        }
        if (view.getId() == R.id.btn_21) {
            handleClick(2, 1, R.id.btn_21);
        }
        if (view.getId() == R.id.btn_22) {
            handleClick(2, 2, R.id.btn_22);
        }

    }

    private void handleClick(int row, int col, int id) {
        if (board[row][col].equals("")) {
            board[row][col] = turn;
            Button btn = findViewById(id);
            btn.setText(turn);
            onTurnEnd();
        }
    }

    Boolean isWinner() {
        Log.e("isWinner","line 81");
        if(board[0][0] == board[0][1] &&  board[0][1] == board[0][2])
            return true;
        if(board[1][0] == board[1][1] &&  board[1][1] == board[1][2])
            return true;
        if(board[2][0] == board[2][1] &&  board[2][1] == board[2][2])
            return true;
        if(board[0][0] == board[1][0] && board[1][0] ==board[2][0])
            return true;
        if(board[0][1] == board[1][0] && board[1][0] == board[2][0])
            return true;
        if(board[0][2] == board[1][2] && board[1][2] == board[2][2])
            return true;
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return true;
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return true;

        return false;
    }






    private void onTurnEnd() {
        if (isWinner())
            endGame(turn + " won!");
        else {
            count++;
        }
        if (count == 9)
            endGame("Tie");
        else {
            turn = (turn.equals("X") ? "O" : "X");
        }
    }

    void endGame(String s)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("More Info");
        builder.setMessage(s);
        builder.setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
// Exit handling

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
// Cancel handling

            }
        });



        AlertDialog dialog = builder.show();

    }
}
