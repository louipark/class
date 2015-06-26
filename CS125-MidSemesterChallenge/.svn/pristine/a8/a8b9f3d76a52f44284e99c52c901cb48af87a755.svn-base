//UIUC CS125 FALL 2012 MP. File: Sprite.java, CS125 Project: CS125-MidSemesterChallenge, Version: 2012-10-29T13:46:09-0500.344693000


import java.awt.Color;
import java.awt.Graphics;

/**
 * The base class of all creatures that can exist inside the world.
 * Each creature has an x,y position, direction (0,1,2,3 => North,East,South,West)
 * and other attributes. Each time the tick() method is called the creature moves
 * one square around the maze, avoiding the world walls.
 * Subclasses will typically override tick() and paint() methods.
 * @author angrave
 */
public class Sprite {
	private int x, y, direction;
	private Color color;
	private boolean alive = true;
	private GeneticAlgorithmApp world;

	/** Initializes the MazeRunner with the x,y values */
	public Sprite(int x, int y, int direction, GeneticAlgorithmApp world) {
		this.x = x;
		this.y = y;
		this.world = world;
		setDirection(direction); // use setDirection to ensure this.direction is in the range 0..3
		// Create a random color using random hue and fixed saturation and brightness.
		// Google "Hue Saturation Brightness" or "HSB color" to find out more
		this.color = Color.getHSBColor((float) Math.random(), 0.69f, 0.99f);
	}

	/**
	 * Sets the creatures color.
	 * @param c the new color.
	 */
	public void setColor(Color c) {
		color = c;
	}

	/**
	 * Returns the creatures current color.
	 * @return the color.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Paints the creature on the screen. The creature should be painted within the rectangle
	 * (this.x * width, this.y *height) to ( (this.x +1)*width, (this.y+1)*height).
	 * Note: (0,0) is at the top left hand of the display.
	 * @param g the gameoflife context
	 * @param width the tile width. The creature should not be larger than this width.
	 * @param height the tile height. The creature should not be taller than this height.
	 */
	public void paint(Graphics g, int width, int height) {
		g.setColor(color);
		g.fillArc(x * width, y * height, width, height, direction * 90 + 280,
				330);
	}
/**
 * Changes the direction of the creature.  The direction is interpreted as follows:
 * 0=>North(Increasing y)
 * 1=>East(Increasing x)
 * 2=>South(Decreasing y)
 * 3=>West(Descreasing x)
 * Integers outside of 0,1,2,3 are automatically mapped back into the range 0-3 using modulo arithmetic.
 * @param d the new direction (maybe negative)
 */
	public void setDirection(int d) {
		// this.direction will always be set to one of  four values: 0,1,2, or 3
		direction = d < 0 ?( 4+ (d % 4))%4 : (d % 4);
	}
/**
 * The current vertical position
 * @return the y component of the creature's position
 */
	public int getY() {
		return y;
	}
	/**
	 * The current horizontal position
	 * @return the x component of the creature's position.
	 */
	public int getX() {
		return x;
	}
/**
 * The current orientation of the creature (0,1,2,3).
 * @see #setDirection(int)
 * @return the orientation
 */
	public int getDirection() {
		return direction;
	}
/**
 * Returns the current direction as a unit vector.
 * direction=0(North): returns {0,1} (increasing Y)
 * direction=1(East): returns {1,0} (increasing X)
 * direction=2(South): returns {0,-1} (decreasing Y)
 * direction=3(West)): returns {-1,0} (decreasing X)
 * @return an integer array of length 2 that represents the current orientation.
 */
	public int[] getDirectionVector() {
		return GeneticAlgorithmApp.NESW[getDirection()];
	}

/**
 * Returns true if there is a wall immediately to the
 * right of the current position. For example, if the creature
 * is at (4,10) looking North(Increasing Y), then this function
 * will check for a wall to the East (Increasing X) i.e. (5,10).
 * @return true if the world contains a wall immediately to the right.
 */
	public boolean isWallOnRight() {
		int[] vector = GeneticAlgorithmApp.NESW[(direction + 1) % 4];
		return world.isWall(x + vector[0], y + vector[1]);
	}

	/**
	 * Returns true if there is a wall immediately in front of the creature.
	 * For example, if the Creature is at (2,8) looking West (Decreasing X)
	 * then this function will check for a wall to the West i.e. (1,8).
	 * @return true if the world contains a wall immediately infront of the creature.
	 */
	public boolean isWallAhead() {
		int[] vector = getDirectionVector();
		return world.isWall(x + vector[0], y + vector[1]);
	}
/**
 * Returns true if there is a wall immediately to the
 * left of the current position. For example, if the creature
 * is at (4,10) looking North(Increasing Y), then this function
 * will check for a wall to the West (Decreasing X) i.e. (3,10).
 * @return true if the world contains a wall immediately to the left.
 */
	public boolean isWallOnLeft() {
		int[] vector = GeneticAlgorithmApp.NESW[(direction + 3) % 4];
		return world.isWall(x + vector[0], y + vector[1]);
	}
	public boolean isWall(int x, int y) {
		return world.isWall(x,y);
	}
	
/**
 * Changes the orientation (direction of the creature) by turning to the right (turning clockwise).
 * For example if the creature is originally looking West (direction =3), the creature will turns right to face North(direction=0).
 * The resulting value of direction will always be in the range 0..3
 */
	public void turnRight() { // Clockwise
		setDirection(direction + 1);
	}

	/**
	 * Changes the orientation (direction of the creature) by turning to the left (turning counter clockwise).
	 * For example if the creature is originally looking North (direction =0), the creature will turns left to face West(direction=3).
	 * The resulting value of direction will always be in the range 0..3
	 */
	public void turnLeft() { // CounterClockwise
		setDirection(direction -1);
	}

	/**
	 * Moves the creature forward one square based on the current direction.
	 * For example if creature at (2,8) is facing South(Decreasing Y,direction-=2)
	 * the creature will move to (2,7).
	 * This method does not check for walls or other obstacles.
	 * It is the callers responsibility to ensure that this move is valid.
	 */
	public void moveForward() {
		int[] deltaXY = GeneticAlgorithmApp.NESW[getDirection()];
		x += deltaXY[0];
		y += deltaXY[1];
	}

	
/**
 * Returns true if the creature is alive.
 * Creatures that are dead generally do not move. In some worlds
 * dead creatures may be removed from the world.
 * @return true if this creature is alive.
 */
	public boolean isAlive() {
		return alive;
	}
/** Changes the alive status of this creature.
 * 
 * @param alive the new value of the alive status.
 */
	public void setAlive(boolean alive) {
			this.alive = alive;
	}

}
