package com.hruivo.voidframework.primitives;

import com.hruivo.voidframework.Mesh;

public class TexturedPlane extends Mesh {

	public TexturedPlane() {
			this(1,1);
	}
	
	public TexturedPlane(float width, float height) {
		// Mapping coordinates for the vertices
		float textureCoordinates[] = {
				0.0f, 0.0f, //
				0.0f, height/2, //
				width/2, height/2, //
				width/2, 0.0f, //
		};
		
		short[] indices = new short[] { 0, 1, 2, 0, 2, 3 };
		
		width /= 2;
		height /= 2;
        float[] vertices = new float[] {
        		-width,  height, 0.0f,  // 0, Top Left
        		-width, -height, 0.0f,  // 1, Bottom Left
        		width, -height, 0.0f,  // 2, Bottom Right
        		width,  height, 0.0f};  // 3, Top Right };
         
		setIndices(indices);
		setVertices(vertices);
		setTextureCoordinates(textureCoordinates);
	}
	
}
