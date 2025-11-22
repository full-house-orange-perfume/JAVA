package snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameWin extends Frame {
    HeadObj headObj=new HeadObj(GameUtils.Rimg,60,60,this);
    public List<BodyObj> bodyObjList = new ArrayList<>();

    public void Launch(){
        this.setVisible(true);
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setTitle("贪吃蛇");
        bodyObjList.add(new BodyObj(GameUtils.Bimg,30,570,this));
        bodyObjList.add(new BodyObj(GameUtils.Bimg,0,570,this));

        while(true){
            repaint();
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
    public void paint(Graphics g){
        //HeadObj headObj=new HeadObj(GameUtils.Rimg,60,60,this);

        //绘制网格
        g.setColor(Color.gray);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());//灰色背景
        g.setColor(Color.black);
        //g.drawLine(0,60,600,60);
        for(int i=0;i<=20;i++){
            g.drawLine(0,i*30,600,i*30);//横线
            g.drawLine(i*30,0,i*30,600);//竖线
        }
        for(int i=bodyObjList.size()-1;i>=0;i--){
            bodyObjList.get(i).paintSelf(g);
        }
        headObj.paintSelf(g);
    }
    public static void main(String[] args) {
        GameWin gamewin=new GameWin();
        gamewin.Launch();
    }
}
