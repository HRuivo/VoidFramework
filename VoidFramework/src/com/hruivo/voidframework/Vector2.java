package com.hruivo.voidframework;

/**
 * Defines a vector with two components.
 * @author HRuivo
 *
 */
public class Vector2 {
	
	public float X, Y;
	
	
	/**
	 * Initializes a new instance of Vector2.
	 */
	public Vector2() {
		this(0.0f, 0.0f);
	}
	
	/**
	 * Initializes a new instance of Vector2.
	 * @param Initial value for the x-component of the vector.
	 * @param Initial value for the y-component of the vector.
	 */
	public Vector2(float x, float y) {
		this.X = x;
		this.Y = y;
	}
	
	public final void add(final Vector2 vec) {
		this.X += vec.X;
		this.Y += vec.Y;
	}
	
	public final void add(final float x, final float y) {
		this.X = x;
		this.Y = y;
	}
	
	public final void subtract(final Vector2 vec) {
		this.X -= vec.X;
		this.Y -= vec.Y;
	}
	
	public final void subtract(final float x, final float y) {
		this.X -= x;
		this.Y -= y;
	}
	
	/**
	 * Calculates the length of the vector.
	 * @return The length of the vector.
	 */
	public final float length() {
		return (float)Math.sqrt(X * X + Y * Y);
	}
	
	/**
	 * Adds two vectors.
	 * @param Source vector.
	 * @param Source vector.
	 * @return Sum of the source vectors.
	 */
	public static final Vector2 add(final Vector2 value1, final Vector2 value2) {
		Vector2 r = new Vector2();
		r.X = value1.X + value2.X;
		r.Y = value1.Y + value2.Y;
		
		return r;
	}
	
	/**
	 * Subtracts a vector from a vector.
	 * @param Source vector.
	 * @param Source vector.
	 * @return Result of the subtraction.
	 */
	public static final Vector2 subtract(final Vector2 value1, final Vector2 value2) {
		Vector2 r = new Vector2();
		r.X = value1.X - value2.X;
		r.Y = value1.Y - value2.Y;
		
		return r;
	}
	
	/**
	 * Multiplies a vector by a scalar value.
	 * @param Source vector
	 * @param Scalar value
	 * @return Result of the multiplication.
	 */
	public static final Vector2 multiply(final Vector2 vector, final float scalar) {
		Vector2 r = new Vector2();
		r.X = vector.X * scalar;
		r.Y = vector.Y * scalar;
		
		return r;
	}
	
}
