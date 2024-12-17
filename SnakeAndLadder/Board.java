package SnakeAndLadder;

import java.util.HashMap;
import java.util.Queue;

public class Board {
    int size;
    private Dice dice;
    private Queue<Player> turns;
    private HashMap<Integer,Integer> snakes;
    private HashMap<Integer,Integer> ladders;
    private HashMap<String,Integer> playerPosition;

    public Board(int size,Dice dice,Queue<Player> turns,HashMap<Integer,Integer> snakes,HashMap<Integer,Integer> ladders,HashMap<String,Integer> playerPosition){
        this.size=size;
        this.dice=dice;
        this.turns=turns;
        this.snakes=snakes;
        this.ladders=ladders;
        this.playerPosition=playerPosition;
    }
    public void start(){
        while(turns.size()>1){
            Player player=turns.poll();
            int curPosition=playerPosition.get(player.getName());  //to fetch the current position of player from the hashmap
            int roll=dice.roll();
            int nextCell=curPosition+roll;
            if(nextCell > size) turns.add(player);
            else if(nextCell==size){
                System.out.println(player.getName()+" won the game.");
            }
            else{
                int nextPosition=nextCell;

                if(snakes.containsKey(nextCell)){   //search in snakes hashmap
                    nextPosition=snakes.get(nextCell);
                    System.out.println(player.getName()+" got bitten by snake at "+nextCell+" and moved to "+snakes.get(nextCell));
                }
                else if (ladders.containsKey(nextCell)){  //search in ladders hashmap
                    nextPosition=ladders.get(nextCell);
                    System.out.println(player.getName()+" got the ladder at "+nextCell +" and moved to "+ladders.get(nextCell));
                }

                if(nextPosition==size){
                    System.out.println(player.getName()+" won the game.");
                }
                else{
                    playerPosition.put(player.getName(),nextPosition);
                    System.out.println(player.getName()+" is at the position "+nextPosition);
                    turns.add(player);
                }
            }
        }
    }
}
