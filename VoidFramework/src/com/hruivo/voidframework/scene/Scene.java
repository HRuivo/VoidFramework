package com.hruivo.voidframework.scene;

import java.util.Vector;

import javax.microedition.khronos.opengles.GL10;

import com.hruivo.voidframework.Mesh;
import com.hruivo.voidframework.cameras.CameraManager;

public class Scene {
	
	private Vector<Mesh> sceneNodes;
	private CameraManager cameraManager;
	
	
	public Scene(GL10 gl) {
		sceneNodes = new Vector<Mesh>();
	
		cameraManager = new CameraManager(gl);
	}
	
	public void update(float dt) {
		cameraManager.update(dt);
		
		int size = sceneNodes.size();
		for (int i = 0; i < size; i++)
			sceneNodes.get(i).update(dt);
	}
	
	public void draw(GL10 gl) {
		int size = sceneNodes.size();
		for (int i = 0; i < size; i++)
			sceneNodes.get(i).draw(gl);
	}
	
	public void add(int location, Mesh object) {
		sceneNodes.add(location, object);
	}
	
	public boolean add(Mesh object) {
		return sceneNodes.add(object);
	}
	
	public void clear() {
		sceneNodes.clear();
	}
	
	public Mesh get(int location) {
		return sceneNodes.get(location);
	}
	
	public Mesh remove(int location) {
		return sceneNodes.remove(location);
	}
	
	public boolean remove(Object object) {
		return sceneNodes.remove(object);
	}
	
	public int size() {
		return sceneNodes.size();
	}
	
}