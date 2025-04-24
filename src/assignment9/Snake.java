package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.2;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		segments = new LinkedList<>();
		segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE));
		
		deltaX = 0;
		deltaY = 0;
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		for (int i = segments.size() - 1; i > 0; i--) { //last -> first but no head
			BodySegment current = segments.get(i); //assign segment
			BodySegment previous = segments.get(i-1);//assign segment before it
			current.setX(previous.getX()); 
			current.setY(previous.getY());
			//move current 1 front
		}
		
		BodySegment head = segments.get(0); // move head according to key
		head.setX(head.getX() + deltaX);
		head.setY(head.getY() + deltaY);
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (BodySegment segment : segments) {
			segment.draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		BodySegment head = segments.get(0);//get head
		double distance = Math.sqrt(Math.pow(head.getX() - f.getX(), 2) + Math.pow(head.getY() - f.getY(), 2));//calculate distance
		if (distance < SEGMENT_SIZE) {
			BodySegment tail = segments.get(segments.size()-1); //get tail
			segments.add(new BodySegment(tail.getX(), tail.getY(), SEGMENT_SIZE)); //add to tail
			return true; //eaten
		}
		return false; // not eaten
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() { //check in canvas or not
		BodySegment head = segments.getFirst();
		return head.getX() >= 0 && head.getX() <= 1 && head.getY() >= 0 && head.getY() <= 1; 
	}
	
	public boolean hasSelfCollision() { //game over when head touch tail
	    BodySegment head = segments.get(0);
	    for (int i = 1; i < segments.size() - 1; i++) {
	        BodySegment segment = segments.get(i);
	        double dx = head.getX() - segment.getX();
	        double dy = head.getY() - segment.getY();
	        double distance = Math.sqrt(dx * dx + dy * dy);
	        if (distance < SEGMENT_SIZE / 2) {
	            return true;
	        }
	    }
	    return false;
	}
}
