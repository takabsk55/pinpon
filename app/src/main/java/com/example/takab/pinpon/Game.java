package com.example.takab.pinpon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Random;

/**
 * Created by takab on 2017/12/19.
 */

public class Game extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);

        start();


        pin();

    }

    private void start() {
        for (int n=0;n<10;n++) {
            int i;
            int pinNum=0;
            Random rnd = new Random();
            i = rnd.nextInt() % 6;
            if (i == 0) {
                pinNum++;
                pin();
            }else if (i==1){
                pinNum=0;
                pinpon();
            }else if (i==2){
                pinNum=0;
                ponpin();
            }else if (i==3){
                pinNum=0;
                pinponpan();
            }else if (i==4){
                pinNum=0;
                pinponpanponpin();
            }else if (i==5){
                pinNum=0;
                pinponpanrice();
            }
        }
    }

    private void pinponpanrice() {
    }

    private void pinponpanponpin() {
    }

    private void pinponpan() {
    }

    private void ponpin() {
    }

    private void pinpon() {
    }

    public void pin(){

    }
}
