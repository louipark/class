//UIUC CS125 FALL 2012 MP. File: GeneticCreature.java, CS125 Project: CS125-MidSemesterChallenge, Version: 2012-10-29T13:46:09-0500.344693000
import java.awt.Color;
import java.awt.Graphics;

/**
 * A Creature with genetic code.
 * 
 * @author angrave
 */
public class GeneticCreature extends Sprite {

	private static final int MAX_LOG2 = 7; // Number of bits minus one per gene
	private static final int MAX = 1 << MAX_LOG2; // Total number of integer
	// genes.
	private boolean showReproduced; // true if this creature has a recent
	// offspring.
	private int[] dna; // the genetic information of this creature.

	/**
	 * Creates a new DNA creature. Three genetic operators are used:
	 * Single-point Crossover-breeding. A random proportion of genes is taken
	 * from each parent. Mutation. A single bit is mutated. (see <a href='http://www.obitko.com/tutorials/genetic-algorithms/crossover-mutation.php'>Crossove
	 * r and Mutation</a> for more information) Splice. A small sequence of
	 * genes is copied to another area of the genome. During initialization when
	 * the first parent is null, the genome is filled with random integers in
	 * the range 0...MAX
	 * 
	 * @param x
	 *            the initial position (X component)
	 * @param y
	 *            the initial position (Y component)
	 * @param direction
	 *            the initial direction
	 * @param parent1
	 *            the first parent (possibly null)
	 * @param parent2
	 *            the second parent (possibly null)
	 * @param world
	 *            the world associated with this creature.
	 */
	public GeneticCreature(int x, int y, int direction, GeneticCreature parent1, GeneticCreature parent2,
			GeneticAlgorithmApp world) {

		super(x, y, direction, world);

		if (parent1 != null)
			parent1.showReproduced = true;

		if (parent2 != null)
			parent2.showReproduced = true;

		dna = new int[MAX];

		if (parent1 == null) {
			// start with random genes
			for (int i = 0; i < dna.length; i++)
				dna[i] = (int) (Math.random() * MAX);
		} else {
			for (int i = 0; i < dna.length; i++)
				dna[i] = parent1.dna[i];
		}
		// Overlay a subset of parent2's genes
		if (parent2 != null) {
			int start = (int) (Math.random() * dna.length);
			for (int i = start; i < dna.length; i++)
				dna[i] = parent2.dna[i];
		}
		// random reverse splice
		int i = (int) (Math.random() * dna.length);
		int j = (int) (Math.random() * dna.length);
		int len = (int) (Math.random() * dna.length / 16);
		for (; i < dna.length && j > 0 && len > 0; i++, j--, len--) {
			dna[i] = dna[j];
		}
		// Mutate one bit
		if (Math.random() > 0.9)
			dna[(int) (Math.random() * dna.length)] ^= 1 << (int) (Math.random() * MAX_LOG2);
	}

	/**
	 * Returns the fitness of this creature. The creatures with the best
	 * (highest) fitness values are used to create new individuals.
	 * 
	 * @return the fitness of this individual.
	 */
	public double getFitness() {
		return getX() + getY();
	}

	/**
	 * Moves this creature based on its internal genetic code. The dna integer
	 * array is used as a double lookup table to determine the resulting
	 * behavior. The result value encodes the probability of turning left,
	 * turning right and moving forward bits 0&1:Turn Left , bits 2&3: Turn
	 * Right, bits 4&5: Move Forward. The value of two bits (0,1,2 or 3) is
	 * compared to a random number, Math.random()*2.5 If the value is greater
	 * the creature performs the corresponding action. Note, the turn right bits
	 * are only checked if the creature does not turn to the left.
	 */
	public void tick() {
		int sensors = getSensorState();
		int result = dna[dna[sensors]];

		// Use the lowest two bits (i.e. values 0,1,2,3) to represent the
		// probability of turning left
		if ((result & 3) > 2.5 * Math.random())
			turnLeft();
		// If we don't turn left, use the next two bits to represent the
		// probability of turning right
		else if (((result >> 2) & 3) > 2.5 * Math.random())
			turnRight();
		// The next two bits represent the probability of moving forward one
		// step.
		if (((result >> 4) & 3) > 2.5 * Math.random())
			moveForward();
		// The creature dies if it creature has moved onto a wall.
		if (isWall(getX(), getY()))
			setAlive(false);
	}

	/**
	 * Encodes the possible exits from the current position as a single integer.
	 * Bit 0: True if there's a wall immediately to the left of the creature.
	 * Bit 1: True if there's a wall immediately in front of the creature. Bit
	 * 2: True if there's a wall immediately to the right of the creature.
	 * 
	 * @return an integer in the range 0..7 that represents the presence of
	 *         walls immediately to the left, ahead and right.
	 */
	public int getSensorState() {
		return (isWallOnLeft() ? 1 : 0) + (isWallAhead() ? 2 : 0) + (isWallOnRight() ? 4 : 0);
	}

	/**
	 * Draws the creature at the current (x,y) tile. If the creature recently
	 * reproduced (showReproduced=true) the creature is highlighted with a white
	 * square and showReproduced is reset to false.
	 */
	public void paint(Graphics g, int width, int height) {
		super.paint(g, width, height);
		if (showReproduced) {
			g.setColor(Color.WHITE);
			g.drawRect(getX() * width, getY() * height, width, height);
			showReproduced = false;
		}
	}
}
