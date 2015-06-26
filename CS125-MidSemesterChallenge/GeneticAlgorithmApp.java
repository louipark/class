//UIUC CS125 FALL 2012 MP. File: GeneticAlgorithmApp.java, CS125 Project: CS125-MidSemesterChallenge, Version: 2012-10-29T13:46:09-0500.344693000

import java.awt.Color;
import java.awt.Graphics;

/**
 * Example of an Genetic Algorithm (GA). This GA learns to explore the maze.
 * Initially a creature with random DNA is inserted into the world. Creatures
 * that move onto a wall tile are removed and do not reproduce. At each time
 * step, the two creatures that travel the farthest towards the bottom right
 * corner (large X, large Y) are selected for reproduction. A new creature based
 * is inserted into the population by randomly replacing one of the existing
 * creatures.
 * 
 * @see GeneticCreature
 * @author angrave
 */
public class GeneticAlgorithmApp {
	/**
	 * Main entry point: Creates a window and starts this simulation.
	 * 
	 * @param arguments
	 *            command line arguments.
	 * @see GUIPanel
	 */
	public static void main(String[] arguments) {
		GeneticAlgorithmApp app = new GeneticAlgorithmApp();
		while (true) {
			app.paint(Zen.getBufferGraphics(), Zen.getZenWidth(), Zen.getZenHeight());
			Zen.flipBuffer();
			app.tick();
		}
	}

	/**
	 * Creates the a new GeneticAlgorithmApp instance and populates the world
	 * with 150 DNA creatures with random DNA.
	 */
	public GeneticAlgorithmApp() {
		this.size = 35;
		this.creatures = new GeneticCreature[150];
		initializeMaze();

		while (getCount() < getMaxCount())
			createCreature(null, null); // Create 150 creatures with random DNA
	}

	/**
	 * Performs one simulation tick. All creatures are updated. Dead creatures
	 * are removed. The two fittest individuals are used to create a new
	 * offspring.
	 */
	public void tick() {
		for (int i = 0; i < getCount(); i++)
			getCreature(i).tick();

		removeDeadCreaturesFromList(); // Housekeeping
		// SELECTION:
		GeneticCreature parent1 = findFittestCreature(null);
		GeneticCreature parent2 = findFittestCreature(parent1); // ignore
																// parent1,
		// find the second
		// fittest creature.
		// REPRODUCTION
		createCreature(parent1, parent2);
	}

	/**
	 * Returns the fittest creature. If 'other' is non-null, then do not check
	 * this creature. If there are no other creatures, this function will return
	 * null.
	 * 
	 * @param other
	 *            the creature to be ignored.
	 * @return the fittest creature (excluding other if set); maybe null.
	 * @see GeneticAlgorithmApp#getFitness(int)
	 * @see GeneticCreature#getFitness()
	 */
	public GeneticCreature findFittestCreature(GeneticCreature other) {
		int best = -1;
		for (int i = 0; i < getCount(); i++) {
			if (getCreature(i) != other) {
				if (best == -1)
					best = i;
				else if (getFitness(i) > getFitness(best))
					best = i;
			}
		}
		return best >= 0 ? (GeneticCreature) getCreature(best) : null;
	}

	/**
	 * Returns the fitness of the creature of the given index. If the requested
	 * creature is not an instance of GeneticCreature then this function returns
	 * Double.NEGATIVE_INFINITY.
	 * 
	 * @param index
	 *            the index of the creature to check i.e. getCreature(index);
	 * @return the fitness of the creature (Double.NEGATIVE_INFINITY if not a
	 *         GeneticCreature)
	 * @see GeneticCreature#getFitness()
	 */
	public double getFitness(int index) {
		GeneticCreature c = getCreature(index);
		if (c instanceof GeneticCreature)
			return ((GeneticCreature) c).getFitness();
		return Double.NEGATIVE_INFINITY;
	}

	/**
	 * Creates a new GeneticCreature based on the two parents (possibly null)
	 * and inserts it into this world. If the world is already full an existing
	 * creature is randomly selected and replaced by the new offspring.
	 * 
	 * @param parent1
	 *            the first parent (can be null)
	 * @param parent2
	 *            the second parent (can be null)
	 * @see GeneticCreature
	 * @see #add(GeneticCreature)
	 * @see #replace(GeneticCreature, int)
	 */
	public void createCreature(GeneticCreature parent1, GeneticCreature parent2) {
		int x = 1 + 2 * (int) (Math.random() * 2);
		int y = 1 + 2 * (int) (Math.random() * 2);
		if (isWall(x, y))
			return;
		GeneticCreature c = new GeneticCreature(x, y, 1, parent1, parent2, this);
		if (getCount() < getMaxCount())
			add(c);
		else
			replace(c, (int) (Math.random() * getCount()));
	}

	public static final int[][] NESW = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // Four
	// compass
	// directions,{North,East,South,West}
	// as
	// a
	// (x,y) vector

	private GeneticCreature[] creatures; // array of creatures. Only entries
	// between 0 and getCount() are
	// valid
	private boolean walls[][]; // walls[x][y] is true if the tile at (x,y) is
	// blocked.

	private int size;// width and height of the maze
	private int count; // Number of valid entries in creatures array

	/**
	 * Initializes the boolean maze. Note this code is small and not virtuous:
	 * it will occasionally create a maze that is not fully connected.
	 */
	public void initializeMaze() {
		this.walls = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			walls[i][0] = true;
			walls[i][size - 1] = true;
			walls[0][i] = true;
			walls[size - 1][i] = true;
		}
		for (int x = 2; x < size - 2; x += 2)
			for (int y = 2; y < size - 2; y += 2) {
				int[] direction = NESW[(int) (Math.random() * 4)];
				walls[x][y] = true;
				walls[x + direction[0]][y + direction[1]] = true;
			}
	}

	/**
	 * Returns true if the tile at (x,y) is blocked by a wall. This method
	 * returns true if the requested (x,y) position is out of range.
	 * 
	 * @param x
	 *            X component
	 * @param y
	 *            Y component
	 * @return true if the position (x,y) is impassable.
	 */
	public boolean isWall(int x, int y) {
		return x < 0 || y < 0 || x >= size || y >= size || walls[x][y];
	}

	/**
	 * Returns the creature inside the baseCreature array at the requested
	 * index. If the index is invalid this method returns null. Valid index
	 * values are 0..getCount()
	 * 
	 * @param index
	 * @return the creature at index or null
	 */
	public GeneticCreature getCreature(int index) {
		return index < 0 || index >= count ? null : creatures[index];
	}

	/**
	 * Returns the number of creatures in this world.
	 * 
	 * @return number of creatures.
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Returns the maximum number of creatures possible.
	 * 
	 * @return max number of creatures.
	 */
	public int getMaxCount() {
		return creatures.length;
	}

	/**
	 * Returns the number of columns of the world (number of tiles across). As
	 * these worlds are square this value also represents the number of rows.
	 * 
	 * @return world size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Removes dead creatures from the array of active creatures and updates
	 * count. After this call completes (inclusive) 0...count (exclusive)
	 * contains active creatures.
	 */
	public void removeDeadCreaturesFromList() {
		int destination = 0;
		for (int i = 0; i < count; i++) {
			if (creatures[i].isAlive())
				creatures[destination++] = creatures[i];
		}
		count = destination;
	}

	/**
	 * Removes all active creatures (including the human player) from this
	 * world.
	 */
	public void removeAll() {
		count = 0;
	}

	/**
	 * Insert a new creature into this world and increment count.
	 * 
	 * @param c
	 *            the creature to insert.
	 */
	public void add(GeneticCreature c) {
		if (c != null)
			creatures[count++] = c;
	}

	/**
	 * Replace the creature at index with the given creature. This method does
	 * not modify count.
	 * 
	 * @param c
	 *            the creature to be included
	 * @param index
	 *            the index in the array to be used. 0...getCount() (exclusive)
	 */
	public void replace(GeneticCreature c, int index) {
		if (c == null || index < 0 || index >= count)
			return;
		creatures[index] = c;
	}

	/**
	 * Paint the world. This method immediately delegates to paintWorld.
	 * 
	 * @param g
	 *            gameoflife context
	 * @param width
	 *            width of window in pixels
	 * @param height
	 *            height of window in pixels.
	 */
	public void paint(Graphics g, int width, int height) {
		paintWorld(g, width / size, height / size);
	}

	/**
	 * Paint the world implementation.
	 * 
	 * @param g
	 *            gameoflife context.
	 * @param tileWidth
	 *            width of one tile.
	 * @param tileHeight
	 *            height of one tile.
	 */
	public void paintWorld(Graphics g, int tileWidth, int tileHeight) {
		paintMaze(g, tileWidth, tileHeight);
		paintCreatures(g, tileWidth, tileHeight);
	}

	/**
	 * Paints the background maze structure.
	 * 
	 * @param g
	 *            gameoflife context.
	 * @param w
	 *            tile width.
	 * @param h
	 *            tile height.
	 */
	public void paintMaze(Graphics g, int w, int h) {
		g.setColor(Color.DARK_GRAY);
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				g.fill3DRect(i * w, j * h, w, h, walls[i][j]);
		g.setColor(Color.WHITE);
	}

	/**
	 * Paints all of the active creatures.
	 * 
	 * @param g
	 *            gameoflife context.
	 * @param w
	 *            tile width.
	 * @param h
	 *            tile height.
	 */
	public void paintCreatures(Graphics g, int w, int h) {
		for (int i = 0; i < count; i++) {
			creatures[i].paint(g, w, h);
		}
	}
}
