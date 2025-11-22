package snake;

import java.awt.*;

public class GameObj {
    Image img;
    int x;
    int y;
    int w=30;
    int h=30;
    GameWin frame;
    public Image getImg(){
        return img;
    }
    public void setImg(Image img){
        this.img = img;
    }
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return y;
    }
    public void setW(int w){
        this.w = w;
    }
    public int getW(){
        return w;
    }
    public void setH(int h){
        this.h = h;
    }
    public int getH(){
        return h;
    }
    public void setFrame(GameWin frame){
        this.frame = frame;
    }
    public GameWin getFrame(){
        return frame;
    }
    public GameObj(){

    }
    public GameObj(Image img,int x, int y, GameWin frame){
        this.img = img;
        this.x = x;
        this.y = y;
        this.frame = frame;
    }
    public GameObj(Image img,int x, int y, int w, int h, GameWin frame){
        this.img = img;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.frame = frame;
    }
    public void paintSelf(Graphics g){
        g.drawImage(img,x,y,frame);
    }

}
