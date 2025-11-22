package snake;

import java.awt.*;

public class GameWin extends Frame {
    public void Launch(){
        this.setVisible(true);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);//窗口居中
        this.setTitle("贪吃蛇");
    }
    //重写
    public void paint(Graphics g){
        //绘制网格
        HeadObj headObj=new HeadObj(GameUtils.Rimg,30,570,this);//绘制蛇头
        g.setColor(Color.gray);//底色gray
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.black);//画笔
        //g.drawLine(0, 0, 600, 60);//网格线
        for(int i=0;i<=200;i++){
            g.drawLine(0, i*30, 600, i*30);//横线
            g.drawLine(i*30, 0, i*30, 600);//竖线
        }
        headObj.paintSelf(g);
    }
    public static void main(String[] args) {
        GameWin gamewin = new GameWin();
        gamewin.Launch();//调用
    }
}
