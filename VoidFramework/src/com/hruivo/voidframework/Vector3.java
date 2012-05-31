package com.hruivo.voidframework;

/**
 * Defines a vector with three components.
 * @author HRuivo
 *
 */
public class Vector3 {
	
	public float X, Y, Z;
	
	
	/**
	 * Initializes a new instance of Vector3.
	 */
	public Vector3() {
		this(0.0f, 0.0f, 0.0f);
	}
	
	/**
	 * Initializes a new instance of Vector3.
	 * @param Initial value for the x-component of the vector.
	 * @param Initial value for the y-component of the vector.
	 * @param Initial value for the z-component of the vector.
	 */
	public Vector3(float x, float y, float z) {
		this.X = x;
		this.Y = y;
		this.Z = z;
	}
	
	public final void add(final Vector3 vec) {
		this.X += vec.X;
		this.Y += vec.Y;
		this.Z += vec.Z;
	}
	
	public final void add(final float x, final float y, final float z) {
		this.X = x;
		this.Y = y;
		this.Z = z;
	}
	
	public final void subtract(final Vector3 vec) {
		this.X -= vec.X;
		this.Y -= vec.Y;
		this.Z -= vec.Z;
	}
	
	public final void subtract(final float x, final float y, final float z) {
		this.X -= x;
		this.Y -= y;
		this.Z -= z;
	}
	
	/**
	 * Calculates the length of the vector.
	 * @return The length of the vector.
	 */
	public final float length() {
		return (float)Math.sqrt(X * X + Y * Y + Z * Z);
	}
	
	/**
	 * Adds two vectors.
	 * @param Source vector.
	 * @param Source vector.
	 * @return Sum of the source vectors.
	 */
	public static final Vector3 add(final Vector3 value1, final Vector3 value2) {
		Vector3 r = new Vector3();
		r.X = value1.X + value2.X;
		r.Y = value1.Y + value2.Y;
		r.Z = value1.Z + value2.Z;
		
		return r;
	}
	
	/**
	 * Subtracts a vector from a vector.
	 * @param Source vector.
	 * @param Source vector.
	 * @return Result of the subtraction.
	 */
	public static final Vector3 subtract(final Vector3 value1, final Vector3 value2) {
		Vector3 r = new Vector3();
		r.X = value1.X - value2.X;
		r.Y = value1.Y - value2.Y;
		r.Z = value1.Z - value2.Z;
		
		return r;
	}
	
	/**
	 * Multiplies a vector by a scalar value.
	 * @param Source vector
	 * @param Scalar value
	 * @return Result of the multiplication.
	 */
	public static final Vector3 multiply(final Vector3 vector, final float scalar) {
		Vector3 r = new Vector3();
		r.X = vector.X * scalar;
		r.Y = vector.Y * scalar;
		r.Z = vector.Z * scalar;
		
		return r;
	}
	
}
