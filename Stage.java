package cardgames;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Stage extends Applet implements MouseListener{
	Image image;
	Image image2;
	public void drawStage(Graphics g){
		
		g.drawImage(image, 0,340,160,120, this);
		g.drawImage(image2, 640,230,160,120, this);
		g.drawRect(720,350,80,80);
		g.drawRect(0, 270, 80, 80);
		g.drawRect(690, 540, 100, 150);
		g.drawRect(10, 10, 100, 150);
		
		g.drawRect(167, 360, 100, 150);
		g.drawRect(274, 360, 100, 150);
		g.drawRect(381, 360, 100, 150);
		g.drawRect(489, 360, 100, 150);
		g.drawRect(596, 360, 100, 150);
	}
	public void paint(Graphics g){
		drawStage(g);
		g.drawRect(0, 0, 800, 700);
		g.drawLine(0, 350, 800, 350);
	}
	public void init(){
		image = getImage(getCodeBase(),"smile.jpg");
		image2 = getImage(getCodeBase(),"images.jpg");
		addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
