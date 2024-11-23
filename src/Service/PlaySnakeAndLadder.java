package Service;

import Model.Dice;
import Model.Game;

public class PlaySnakeAndLadder {
    Game game;
    Dice dice;
    public PlaySnakeAndLadder(Game game, Dice dice){
        this.game=game;
        this.dice=dice;
    }
    public void playGame(){
        while (!game.checkWinner()){
            game.movePlayers(dice.getDiceOutput());
        }
    }
}
