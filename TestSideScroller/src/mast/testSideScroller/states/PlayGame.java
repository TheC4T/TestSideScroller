package mast.testSideScroller.states;

import java.io.IOException;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import mast.testSideScroller.entites.Player;
import mast.testSideScroller.tools.Map;
import mast.testSideScroller.tools.States;

public class PlayGame extends BasicGameState{
	
	String path = "saves/test2.txt";
	
	Map map;
	TextField textField;
	
	private Player player;

	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {

		try {
			map = new Map(path, 512, 512);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player = new Player(gc, 100, 100);
		textField = new TextField(gc, gc.getDefaultFont(), 50, 50, 200, 20);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		g.setBackground(Color.green);
		//g.drawImage(Resources.returnImage("tileSheet"), 0, 0);

		
		map.mapDraw(g, Map.getMapData());

		player.render(g);
		//textField.render(gc, g);
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		player.tick(delta);
		
		String test = textField.getText();
		
		if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
			System.out.println(test);
		}
	}

	@Override
	public int getID() {
		return States.PlayGame;
	}

}
