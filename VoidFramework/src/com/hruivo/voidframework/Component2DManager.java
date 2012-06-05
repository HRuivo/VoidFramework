package com.hruivo.voidframework;

import java.util.Vector;

import javax.microedition.khronos.opengles.GL10;

public final class Component2DManager {
	
	private Vector<Sprite> components;
	
	
	public Component2DManager() {
		components = new Vector<Sprite>();
	}
	
	public void update(float dt) {
		int size = components.size();
		for (int i = 0; i < size; i++) {
			components.get(i).update(dt);
		}
	}
	
	public void draw(GL10 gl) {
		int size = components.size();
		for (int i = 0; i < size; i++) {
			components.get(i).draw(gl);
		}
	}
	
	
	public boolean add(Sprite sprite) {
		return components.add(sprite);
	}
	
}
