package cardgames;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;


public class Stage extends Applet implements MouseListener{
	Card[] playerField = new Card[5];
	Card[] npcField = new Card[5];
	Card[] hands_p1 = new Card[8];
	Card[] hands_p2 = new Card[8];
	boolean T = false;
	Image image;
	Image image2;
	Deck player;
	Deck npc;
	AudioClip ac;
	List<Card> d2 ;
	
	Duelist player_st = new Duelist();
	Duelist npc_st = new Duelist();
	
	CardDAO cd = new CardDAO();
	DeckDao dd = new DeckDao();
	
	Deck playerDeck = dd.findDeckList(1);
	Deck npcDeck = dd.findDeckList(2);

	public void drawStage(Graphics g){
		

		//this. = dao.findDeckList(1);
		//this.npc = dao.findDeckList(2);
		g.drawImage(image, 0,350,160,120, this);
		g.drawImage(image2, 640,230,160,120, this);
		g.drawRect(720,350,80,80);
		g.drawRect(0, 270, 80, 80);
		g.drawRect(690, 540, 100, 150);
		g.drawRect(10, 10, 100, 150);
		g.drawRect(10, 610, 80, 80);
		g.drawRect(710, 10, 80, 80);
		
		//場
		//自分
		g.setColor(Color.black);
		Font fo3 = new Font("SansSerif",Font.BOLD,16);
		g.setFont(fo3);
		//Card[] playerField = new Card[5];
		if(T == false){
			d2 = cd.findCardListData(playerDeck);
			T = true;
		}
		Card card= d2.get(0);
		playerField[0] = card;
		d2.remove(0);
		for(int j = 0;j < playerField.length;j++){
			if(playerField[j] != null){
				g.drawRect(167+107*j, 360, 100, 150);
				
				g.setColor(Color.black);
				g.drawString(card.name, 167+107*j, 380);
				g.drawString("ATTACK:"+card.attack, 167+107*j, 440);
				g.drawString("DEFENCE:"+card.defence, 167+107*j, 460);
				g.drawString("COST:"+card.cost, 167+107*j, 480);
			}
		}
		//相手
		//Card[] npcField = new Card[5];
		if(T == false){
			d2 = cd.findCardListData(npcDeck);
			T = true;
		}
		Card card2= d2.get(1);
		npcField[0] = card2;
		d2.remove(0);
		for(int a = 0;a < 5;a++){
			if(npcField[a] != null){
			g.drawRect(105+107*a, 190, 100, 150);
			g.setColor(Color.black);
			g.drawString(card2.name, 105+107*a, 210);
			g.drawString("ATTACK:"+card2.attack, 105+107*a, 270);
			g.drawString("DEFENCE:"+card2.defence, 105+107*a, 290);
			g.drawString("COST:"+card2.cost, 105+107*a, 310);
			}
		}
		//手札
		//自分
		g.setColor(Color.black);
		Font fohands = new Font("SansSerif",Font.BOLD,12);
		g.setFont(fohands);
		//Card[] hands_p1 = new Card[8];
		if(T == false){
			d2 = cd.findCardListData(playerDeck);
			T = true;
		}
		Card cardt1= d2.get(0);
		hands_p1[0] = card;
		d2.remove(0);
		for(int l = 0;l < hands_p1.length;l++){
			if(hands_p1[l] != null){
				g.drawRect(110+70*l, 585, 70, 105);
				
				g.setColor(Color.black);
				g.drawString(card.name, 110+70*l, 605);
				g.drawString("ATTACK:"+card.attack, 110+70*l, 635);
				g.drawString("DEFENCE:"+card.defence, 110+70*l, 655);
				g.drawString("COST:"+card.cost, 110+70*l, 675);
			}
		}
		//相手
		//Card[] hands_p2 = new Card[8];
		if(T == false){
			d2 = cd.findCardListData(npcDeck);
			T = true;
		}
		Card npc= d2.get(1);
		hands_p2[0] = card2;
		d2.remove(0);
		for(int b = 0;b < hands_p1.length;b++){
			if(hands_p2[b] != null){
			g.drawRect(130+b*70, 10, 70, 105);
			g.setColor(Color.black);
			g.drawString(card2.name, 130+b*70, 40);
			g.drawString("ATTACK:"+card2.attack, 130+b*70, 60);
			g.drawString("DEFENCE:"+card2.defence, 130+b*70, 80);
			g.drawString("COST:"+card2.cost,130+b*70, 100);
			}
		}
		//ステータス
		//自分
		g.setColor(Color.black);
		Font fo2 = new Font("SansSerif",Font.BOLD,20);
		g.setFont(fo2);
		g.drawString("HP       :"+player_st.hp, 15, 490);
		g.drawString("MP       :"+player_st.mp+"/"+npc_st.max_mp, 15, 510);
		g.drawString("デッキ  :"+player_st.deck, 15, 570);
		g.drawString("手札     :"+player_st.tehuda, 15, 530);
		g.drawString("墓地", 10, 630);
		g.drawString(""+player_st.boti, 50, 670);
		//相手
		g.setColor(Color.black);
		Font fo1 = new Font("SansSerif",Font.BOLD,20);
		g.setFont(fo1);
		g.drawString("HP       :"+npc_st.hp, 640, 220);
		g.drawString("MP       :"+npc_st.mp+"/"+player_st.max_mp, 640, 200);
		g.drawString("デッキ  :"+npc_st.deck, 640, 180);
		g.drawString("手札     :"+npc_st.tehuda, 640, 160);
		g.drawString("墓地", 710, 30);
		g.drawString(""+npc_st.boti, 750, 70);
		
		
		
		
		//List<Card> d2 = cd.findCardListData(deck);
		//Card card= d2.get(2);
		/*g.setColor(Color.black);
		g.drawString(card.name, 167, 380);
		g.drawString("ATTACK:"+card.attack, 167, 440);
		g.drawString("DEFENCE:"+card.defence, 167, 460);
		g.drawString("COST:"+card.cost, 167, 480);*/
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

		ac = getAudioClip(getDocumentBase(), "o-dio/test.wav");
	}
	/*public void start() {
		ac.loop();
	}
		    // アプレットが停止したら再生も停止
	public void stop() {
		           ac.stop();
		    }*/
	//public void drawRandom(){
		//int random = new java.util.Random;
	//}
	@Override
	public void mouseClicked(MouseEvent e) {
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		int x = e.getX();
		int y = e.getY();
		System.out.println(x+" "+y);
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
