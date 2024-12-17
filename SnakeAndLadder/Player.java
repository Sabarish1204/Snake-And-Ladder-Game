package SnakeAndLadder;

public class Player {
    private String name;
    private int id;
    Player(String name,int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return this.name;
    }
}
