package Model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    Integer currentPlayer=-1;
    Integer MaxSize;
    Integer numOfPlayers;
    HashMap<Integer, Integer> snakes;
    HashMap<Integer, Integer> ladders;
    List<Player> Players;
    public Game(Integer maxsize, Integer PlayersCount){
        numOfPlayers=PlayersCount;
        MaxSize=maxsize;
        snakes=new HashMap<>();
        ladders=new HashMap<>();
        Players =new ArrayList<>();
    }
    public void addPlayer(Player player){
        Players.add(player);
    }
    public boolean addSnake(Integer mouth,Integer tail){
        if(mouth<=tail){
            return false;
        }
        if(snakes.containsKey(mouth)){
            return false;
        }
        snakes.put(mouth,tail);
        return true;
    }
    public boolean addLadder(Integer start,Integer end){
        if(start>=end){
            return false;
        }
        if(ladders.containsKey(start)){
            return false;
        }
        ladders.put(start,end);
        return true;
    }
    public boolean checkWinner(){
        int  i;
        for(i=0;i<Players.size();i++){
            if(Players.get(i).getPosition()==MaxSize){
                System.out.println(Players.get(i).getPLayerName()+" is the Winner");
                return true;
            }
        }
        return false;
    }
    public void movePlayers(Integer diceface){
        currentPlayer++;
        currentPlayer%=numOfPlayers;
        Player currPlayer = Players.get(currentPlayer);
        if(currPlayer.getPosition()+diceface<=100){
            Integer destination=currPlayer.getPosition()+diceface;
            if(snakes.containsKey(destination)){
                destination=snakes.get(destination);
                System.out.println("Eaten By Snake ---------------------------------------------------");
            }else if(ladders.containsKey(destination)){
                destination=ladders.get(destination);
                System.out.println("using Ladders ---------------------------------------------------");

            }
            System.out.println("moving with diceface "+ diceface);
            System.out.println(currPlayer.getPLayerName()+"moving from "+currPlayer.getPosition().toString() +" to"+ destination);
            currPlayer.setPosition(destination);
        }
    }
}