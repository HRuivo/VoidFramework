package com.hruivo.voidframework.inputs;

import com.hruivo.voidframework.Vector3;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

public final class Accelerometer {

	private static SensorEvent sensorEvent = null;
	private static Sensor sensor = null;
	
	private static boolean sensorInitialized = false;
	private static boolean sensorSupported = false;
	
	
	public static boolean isSensorSupported() {
		return sensorSupported;
	}
	
	public static void initializeSensor(final SensorEventListener listener,final  SensorManager manager) {
		if(sensorInitialized) return;
		
		Log.d("VoidFramework.Accelerometer", "Initializing sensor...");
		sensor = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		resume(listener, manager);
				
		if(sensor == null) {
			sensorSupported = false;
			Log.d("VoidFramework.Accelerometer", "Sensor is not supported");
		} else {
			sensorSupported = true;
			Log.d("VoidFramework.Accelerometer", "Sensor is supported");
		}
		
		sensorInitialized = true;
		Log.d("VoidFramework.Accelerometer", "Sensor initialized");
	}
	
	public static void pause(final SensorEventListener listener, final SensorManager manager) {
		manager.unregisterListener(listener);
	}
	
	public static void resume(final SensorEventListener listener, final SensorManager manager) {
		manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	public static void update(final SensorEvent event) {
		if(sensorInitialized) {
			if(sensorSupported) {
				sensorEvent = event;
			}
		}
	}
	
	public static final float getAccelerometerX() {
		if(sensorEvent == null) return 0.0f;
		
		return sensorEvent.values[0];
	}
	
	public static final float getAccelerometerY() {
		if(sensorEvent == null) return 0.0f;
		
		return sensorEvent.values[1];
	}
	
	public static final float getAccelerometerZ() {
		if(sensorEvent == null) return 0.0f;
		
		return sensorEvent.values[2];
	}

	public static final Vector3 getAccelerometerValues() {
		if(sensorEvent == null) return new Vector3();
		
		return new Vector3(
				sensorEvent.values[0],
				sensorEvent.values[1],
				sensorEvent.values[2]);
	}
	
}
