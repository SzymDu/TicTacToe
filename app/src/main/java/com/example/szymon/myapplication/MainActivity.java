package com.example.szymon.myapplication;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int player = 0;
    int[] state = {2,2,2,2,2,2,2,2,2};
    int[][] win = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    public void drop(View view) {
        ImageView counter = (ImageView) view;
        int tapped = Integer.parseInt(counter.getTag().toString());
        for( int[] endgame: win){
          if(state[endgame[0]] == state[endgame[1]] &&
                  state[endgame[1]] == state[endgame[2]] &&
                  state[endgame[0]] != 2){
              System.out.println("Its end game");
          }
        }
        if(state[tapped] == 2) {
            state[tapped] = player;

            counter.setTranslationY(-1000f);
            System.out.println(state.toString());
            if (player == 0) {
                counter.setImageResource(R.drawable.x);
                counter.animate().translationY(1f).setDuration(500);
                player = 1;
            } else {
                counter.setImageResource(R.drawable.o);
                counter.animate().translationY(1f).setDuration(500);
                player = 0;
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  }
}
