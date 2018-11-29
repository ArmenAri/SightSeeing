package io.github.armenari.utils;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

public class Methods {

	public static double distance(float x1, float y1, float x2, float y2) {
		return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
	}
	

	public static FloatBuffer floatBuffer(float a, float b, float c, float d) {
		float[] data = new float[] { a, b, c, d };
		FloatBuffer fb = BufferUtils.createFloatBuffer(data.length);
		fb.put(data);
		fb.flip();
		return fb;
	}

}
