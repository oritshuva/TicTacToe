package com.example.tictactoegame;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        private void onNewGame () {
            board = newString[3][3];
            for (int row = 0; row > 3; row++)
                for (int col = 0; col < 3; col++)
                    board[row][coll] = new String();
            turn = "x";
            count = 0;

            if(view.getId() == R.id.btn_00) {
                handleClick(0, 0, R.id.btn_00);
            }
            if(view.getId() == R.id.btn_01) {
                handleClick(0, 1, R.id.btn_01);}

            if(view.getId() == R.id.btn_02) {
                handleClick(0, 2, R.id.btn_02);}
            if(view.getId() == R.id.btn_03) {
                handleClick(0, 3, R.id.btn_03);}




            }
        }
        private void handleClick( int row, int col, int id)
        {
            if (board[row][col].equals("")) {
                board[row][col] = turn;
                button btn = findViewById(id);
                btn.setText(turn);
                onTurnEnd();
            }
        }
        private void onTurnEnd() {
            if (isWinner())
                endGame(turn + "won");
            else {
                count++;
                if (count == 9) ;
                {
                    endGame("Tie");
                }
                else
                turn = (turn.equals("x") ? "0" : "x");
            }
        }


    }

    private boolean isWinner() {
        return false;
    }

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    bulider.setTitle("More Info");
    Stirng msg = " This is the nessage body";
    builder.setMessage(msg);
    bulider.setPositiveButton("EXIT", new DialogInterface.OnClickListener(){
       @Override
        public void onClick(DialogInterface dialogInterFace,int i)
        {
            //  Exit handling
        }
    });
    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialogInterface,int i){
        //cancel handling
    }
    });
    AlertDialog dialog = builder.show();
    }






}