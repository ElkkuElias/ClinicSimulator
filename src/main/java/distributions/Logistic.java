package distributions;

/** A random number generator based on the logistic distribution.
  * automatically generated by <code>MetaGenerator</code> 
  * @version 1.0, Thu Oct 03 10:51:22 BST 2002
  * @author F.Mallet from C.Simatos's original
  */

public class Logistic extends Generator implements ContinuousGenerator {
    private double location;
    private double scale;
    /**
     * the seed is aumatically provided by the <code>SeedGenerator</code>
     */
    public Logistic(double location, double scale) {
        super();
        set(location, scale);
    }

    /**
     * The constructor with which a specific seed is set for the random
     * number generator
     * @param seed The initial seed for the generator, two instances with
     *             the same seed will generate the same sequence of numbers
     */
    public Logistic(double location, double scale, long seed) {
        super(seed);
        set(location, scale);
    }

    private void set(double location, double scale) {
        if (scale<=0)
            throw new ParameterException("Logistic: The scale parameter must be greater than 0.");
        this.location = location;
        this.scale = scale;
    }

    /**
     * Generate a new random number.
     * @return The next random number in the sequence
     */
    public double sample() { 
         return distrib.logistic(location, scale);
    }
}
