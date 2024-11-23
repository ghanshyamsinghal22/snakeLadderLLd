package Model;

public class Player {
    String PLayerName;
    Integer Position;
    public Player(String name){
        PLayerName=name;
        Position=0;
    }
    public String getPLayerName() {
        return PLayerName;
    }

    public void setPLayerName(String PLayerName) {
        this.PLayerName = PLayerName;
    }

    public Integer getPosition() {
        return Position;
    }

    public void setPosition(Integer position) {
        Position = position;
    }

}
