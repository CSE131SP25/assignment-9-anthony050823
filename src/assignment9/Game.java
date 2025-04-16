package assignment9;

import java.awt.event.KeyEvent;
import java.util.LinkedList;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Snake snake;
	private LinkedList<Food> foods;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		snake = new Snake();
		foods = new LinkedList<>();
	
		for (int i = 0; i < 8; i++) {
			foods.add(new Food());
		}
	}
	
	public void play() {
		while (snake.isInbounds()) {
			int dir = getKeypress();
			if (dir != -1) {
				snake.changeDirection(dir);
			}
			snake.move();
			for (int i = 0; i < foods.size(); i++) {
				if (snake.eatFood(foods.get(i))) {
					foods.get(i).randomizePosition();
				}
			}

			updateDrawing();
		}
		
		System.out.println("Game Over");
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		snake.draw();
		for (Food food : foods) {
			food.draw();
		}
		StdDraw.pause(50);
		StdDraw.show();
		
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
