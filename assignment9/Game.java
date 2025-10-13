package assignment9;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake snake;
	private Food food;

	public Game() {
		StdDraw.enableDoubleBuffering();
		this.snake = new Snake();
		this.food = new Food();
	}

	public void play() {
		for (int i = 3; i > 0; i--) {
			printMessage("" + i);
			StdDraw.pause(1000);
		}
		printMessage("Start");
		while (snake.isInbounds()) { 
			int dir = getKeypress();
			if (dir != -1) {
				snake.changeDirection(dir);
			}
			snake.move();
			if (snake.eatFood(food)) {
				food = new Food();
			}
			updateDrawing();
			StdDraw.pause(70);
		}
		printMessage("Game Over!");
	}

	private void printMessage(String message) {
		StdDraw.clear();
		background();
		StdDraw.setPenColor(Color.pink);
		StdDraw.setFont(new java.awt.Font("Comic Sans", java.awt.Font.BOLD, 30));
		StdDraw.text(0.5, 0.5, message);
		StdDraw.show();
	}

	private void background() {
		Color lightGreen = new Color(225, 237, 213);
		StdDraw.setPenColor(lightGreen);
		StdDraw.filledRectangle(1, 1, 1, 1);
	}

	private int getKeypress() {
		if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
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

	private void scoreBoard() {
		StdDraw.setPenColor(Color.pink);
		StdDraw.setFont(new java.awt.Font("Comic Sans", java.awt.Font.PLAIN, 20));
		StdDraw.text(0.15, 0.95, "Food eaten: " + (snake.getSegmentCount() - 1));

	}
	
	private void updateDrawing() {
		StdDraw.clear();
		background();
		snake.draw();
		food.draw();
		scoreBoard();
		StdDraw.pause(50);
		StdDraw.show();
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
