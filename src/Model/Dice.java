package Model;

import java.util.Random;

public class Dice {
    Integer Maxvalue;
    public Dice(Integer MaximumResult){
        Maxvalue=MaximumResult;
    }
    Random random=new Random();
    public Integer getDiceOutput(){
        return random.nextInt(Maxvalue)+1;
    }
}
