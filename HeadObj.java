package snake;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class HeadObj extends GameObj {
    private String direction="right";
    public String getDirection(){
        return direction;
    }
    public void setDirection(String direction){
        this.direction = direction;
    }
    public HeadObj(Image image, int x, int y, GameWin frame){

        super(image, x, y, frame);
        this.frame.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                changeDirection(e);
            }
        });
    }
    public void changeDirection(KeyEvent e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                direction = "right";
                img = GameUtils.Rimg;
                break;
            case KeyEvent.VK_LEFT:
                direction = "left";
                img = GameUtils.Limg;
                break;
            case KeyEvent.VK_UP:
                direction = "up";
                img = GameUtils.Uimg;
                break;
            case KeyEvent.VK_DOWN:
                direction = "down";
                img = GameUtils.Dimg;
                break;
            default:
                break;
        }
    }

    public void move(){ //判断方向
        List<BodyObj>bodyObjList=this.frame.bodyObjList;
        for(int i=1; i<bodyObjList.size(); i++){
            bodyObjList.get(i).x=bodyObjList.get(i-1).x;
            bodyObjList.get(i).y=bodyObjList.get(i-1).y;
        }
        bodyObjList.get(0).x=this.x;
        bodyObjList.get(0).y=this.y;
        switch(direction) {
            case "right":
                x = x + w;
                break;
            case "left":
                x = x - w;
                break;
            case "up":
                y = y - h;
                break;
            case "down":
                y = y + h;
                break;
            default:
                break;
        }
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        move();
        if(x<0){
            x=570;
        }else if(x>570){
            x=0;
        }else if(y<0){
            y=570;
        }else if(y>570){
            y=30;
        }
    }
}
