package algorithms.noise;

import processing.core.*;

/**
 * This is a template class and can be used to start a new processing Library.
 * Make sure you rename this class as well as the name of the example package
 * 'template' to your own Library naming convention.
 * 
 * (the tag example followed by the name of an example included in folder
 * 'examples' will automatically include the example in the javadoc.)
 *
 * @example Hello
 */

public class OpenSimplexNoise {

	// myParent is a reference to the parent sketch
	PApplet myParent;

	int myVariable = 0;

	public final static String VERSION = "##library.prettyVersion##";
	OpenSimplexNoiseKS generator;

	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the Library.
	 * 
	 * @example Hello
	 * @param theParent the parent PApplet
	 */
	public OpenSimplexNoise(PApplet theParent, long seed) {
		myParent = theParent;
		welcome();
		generator = new OpenSimplexNoiseKS(seed);
	}

	public OpenSimplexNoise(PApplet theParent) {
		this(theParent, System.currentTimeMillis());
	}

	private void welcome() {
		System.out.println("##library.name## ##library.prettyVersion## by ##author##");
	}

	/**
	 * return the version of the Library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}

	public double remap(double xoff) {
		return (1 + xoff) / 2;
	}

	public float noise(float xoff) {
		return (float) remap(generator.eval(xoff, 0));
	}

	public float noise(float xoff, float yoff) {
		return (float) remap(generator.eval(xoff, yoff));
	}

	public float noise(float xoff, float yoff, float zoff) {
		return (float) remap(generator.eval(xoff, yoff, zoff));
	}

	public float noise(float xoff, float yoff, float zoff, float uoff) {
		return (float) remap(generator.eval(xoff, yoff, zoff, uoff));
	}

}
