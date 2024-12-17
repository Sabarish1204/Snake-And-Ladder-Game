package SnakeAndLadder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PlayGame {
    public static void main(String[] args) {
        Dice dice=new Dice(1);
        Player p1=new Player("A",1);
        Player p2=new Player("B",2);

        Queue<Player> turns=new LinkedList<>();
        turns.add(p1);
        turns.add(p2);

        HashMap<Integer,Integer> snakes=new HashMap<>();
        snakes.put(26,5);
        snakes.put(98,25);
        snakes.put(63,7);

        HashMap<Integer,Integer> ladder=new HashMap<>();
        ladder.put(12,72);
        ladder.put(22,39);
        ladder.put(73,92);

        HashMap<String,Integer> playerPosition=new HashMap<>();
        playerPosition.put(p1.getName(),0);
        playerPosition.put(p2.getName(),0);


        Board b=new Board(100,dice,turns,snakes,ladder,playerPosition);
        b.start();
    }
}
