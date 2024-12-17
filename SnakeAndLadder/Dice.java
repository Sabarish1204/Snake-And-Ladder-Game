package SnakeAndLadder;

import java.util.Random;

public class Dice {
    private int numberOfDice;
    Dice(int numberOfDice){
        this.numberOfDice=numberOfDice;
    }
    public int roll(){
        return (int) (Math.random()*(6*numberOfDice - 1*numberOfDice))+1;
    }
}
