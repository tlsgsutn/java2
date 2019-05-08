import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GalagaGame extends JPanel implements KeyListener {

	private boolean running = true;

	private ArrayList sprites = new ArrayList();
	private Sprite starship;
	private int rerode = 25;
	private int shot = 15;
	private BufferedImage alienImage;
	private BufferedImage shotImage;
	private BufferedImage shipImage;
	private BufferedImage minionImage;;
	private BufferedImage BossImage;;
	private BufferedImage BossKerriganImage;;
	private BufferedImage CardImage;;

	public GalagaGame() {
		JFrame frame = new JFrame("Galaga Game");

		frame.setSize(800, 600);
		frame.add(this);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			shotImage = ImageIO.read(new File("fire.png")); //총알
			shipImage = ImageIO.read(new File("starship.jpg")); // 마린
			alienImage = ImageIO.read(new File("alien.jpg"));  //드론
			minionImage = ImageIO.read(new File("images.jpg")); //저글링
			BossImage = ImageIO.read(new File("download.jpg")); //군단여왕
			BossKerriganImage = ImageIO.read(new File("Kerrigan.jpg")); //칼날여왕
			CardImage = ImageIO.read(new File("Card.jpg")); //함정카드발동! 이게임은 절대 클리어 할수없다!

		} catch (IOException e) {
			e.printStackTrace();
		}
		this.requestFocus();
		this.initSprites();
		addKeyListener(this);

	}

	private void initSprites() {
		starship = new StarShipSprite(this, shipImage, 370, 550);
		sprites.add(starship);
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 12; x++) {
				Sprite images = new AlienSprite(this, minionImage, 60 + (x * 45), (50) + y * 35);
				sprites.add(images);
				Sprite alien = new AlienSprite(this, alienImage, 60 + (x * 45), (50) + y * 35);
				sprites.add(alien);
				Sprite download = new AlienSprite(this, BossImage, 340 + (x * 0), (1) + y * 1);
				sprites.add(download);
				Sprite Kerrigan = new AlienSprite(this, BossKerriganImage, 3000 + (x * 0), (1) + y * 1);
				sprites.add(Kerrigan);
				Sprite Card = new AlienSprite(this, CardImage, 5000 + (x * 0), (1) + y * 1);
				sprites.add(Card);
				
				
					}
				}
			}

	private void startGame() {
		sprites.clear();
		initSprites();
	}

	public void endGame() {
		System.exit(0);
	}

	public void removeSprite(Sprite sprite) {
		sprites.remove(sprite);
	}

	public void fire() {
		ShotSprite shot = new ShotSprite(this, shotImage, starship.getX() + 0, starship.getY() - 10);
		sprites.add(shot);
		ShotSprite shot1 = new ShotSprite(this, shotImage, starship.getX() - 10, starship.getY() - 10);
		sprites.add(shot1);
		ShotSprite shot2 = new ShotSprite(this, shotImage, starship.getX() + 10, starship.getY() - 10);
		sprites.add(shot2);
		
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.PINK);
		g.fillRect(0, 0, 800, 600);
		for (int i = 0; i < sprites.size(); i++) {
			Sprite sprite = (Sprite) sprites.get(i);
			sprite.draw(g);
		}
	}

	public void gameLoop() {

		while (running) {
			for (int i = 0; i < sprites.size(); i++) {
				Sprite sprite = (Sprite) sprites.get(i);
				sprite.move();
			}

			for (int p = 0; p < sprites.size(); p++) {
				for (int s = p + 1; s < sprites.size(); s++) {
					Sprite me = (Sprite) sprites.get(p);
					Sprite other = (Sprite) sprites.get(s);

					if (me.checkCollision(other)) {
						me.handleCollision(other);
						other.handleCollision(me);
					}
				}
			}

			repaint();
			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A)
			starship.setDx(-5);
		if (e.getKeyCode() == KeyEvent.VK_D)
			starship.setDx(+5);
		if (e.getKeyCode() == KeyEvent.VK_W)
			starship.setDy(-5);
		if (e.getKeyCode() == KeyEvent.VK_S)
			starship.setDy(+5);
		
		if(rerode !=0 ){
			if (e.getKeyCode() == KeyEvent.VK_R){
				shot = 20;
				rerode--;
			}
		}
		
		if (shot != 0 ){
			if (e.getKeyCode() == KeyEvent.VK_F){
				fire();
				shot--;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A)
			starship.setDx(0);
		if (e.getKeyCode() == KeyEvent.VK_D)
			starship.setDx(0);
		if (e.getKeyCode() == KeyEvent.VK_W)
			starship.setDy(0);
		if (e.getKeyCode() == KeyEvent.VK_S)
			starship.setDy(0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	public static void main(String argv[]) {
		GalagaGame g = new GalagaGame();
		g.gameLoop();
	}
}
