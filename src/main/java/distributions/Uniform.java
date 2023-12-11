package distributions;

/** A random number generator based on the uniform distribution.
  * automatically generated by <code>MetaGenerator</code> 
  * @version 1.0, Thu Oct 03 11:04:34 BST 2002
  * @author F.Mallet from C.Simatos's original
  */

public class Uniform extends Generator implements ContinuousGenerator {
    private double min;
    private double max;
    /**
     * the seed is aumatically provided by the <code>SeedGenerator</code>
     */
    public Uniform(double min, double max) {
        super();
        set(min, max);
    }

    /**
     * The constructor with which a specific seed is set for the random
     * number generator
     * @param seed The initial seed for the generator, two instances with
     *             the same seed will generate the same sequence of numbers
     */
    public Uniform(double min, double max, long seed) {
        super(seed);
        set(min, max);
    }

    private void set(double min, double max) {
        if (max<=min)
            throw new ParameterException("Uniform: The maximum must be greater than the minimum.");
        this.min = min;
        this.max = max;
    }

    /**
     * Generate a new random number.
     * @return The next random number in the sequence
     */
    public double sample() { 
         return distrib.uniform(min, max);
    }
}
