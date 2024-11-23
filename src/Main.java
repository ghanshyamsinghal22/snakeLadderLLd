import Model.Dice;
import Model.Game;
import Model.Player;
import Service.PlaySnakeAndLadder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter maximum Board Size");
        Integer MaxSize =scanner.nextInt();
        System.out.println("Enter Number of Players");
        int numOfPlayers = scanner.nextInt();
        System.out.println("Enter Max Dice Value");
        Integer dicemaxValue= scanner.nextInt();
        Game game=new Game(MaxSize,numOfPlayers);
        Dice dice=new Dice(dicemaxValue);
        System.out.println("Enter Player names");
        while(numOfPlayers>0){
            numOfPlayers--;
            String name =scanner.next();
            Player player=new Player(name);
            game.addPlayer(player);
        }
        System.out.println("Enter Number of snakes");
        int numofsnakes=scanner.nextInt();
        while(numofsnakes>0){
            int mouth = scanner.nextInt();;
            int tail = scanner.nextInt();;
            boolean verified = game.addSnake(mouth,tail);
            if(verified){
                numofsnakes--;
            }else{
                System.out.println("Invalid entry");
            }
        }
        System.out.println("Enter Number of ladders");

        int numofladders=scanner.nextInt();
        while(numofladders>0){
            int start = scanner.nextInt();;
            int end = scanner.nextInt();;
            boolean verified = game.addLadder(start,end);
            if(verified){
                numofladders--;
            }else{
                System.out.println("Invalid entry");
            }
        }
        PlaySnakeAndLadder playSnakeAndLadder=new PlaySnakeAndLadder(game,dice);
        playSnakeAndLadder.playGame();
    }
}