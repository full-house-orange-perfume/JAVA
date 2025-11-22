package snake;

import java.awt.*;

public class HeadObj extends GameObj {
    private String direction="right";//初始化，向右

    public HeadObj(Image rimg, int x, int y, GameWin gameWin) {
    }

    public String getDirection(){
        return direction;
    }
    public void setDirection(String direction){
        this.direction = direction;
    }
    public HeadObj(Image image, int x, int y,GameObj frame){
        super(image,x,y, frame.get());
    }
    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
    }
}
