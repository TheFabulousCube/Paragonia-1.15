package com.thefabulouscube.paragonia.util;

public class Helpers {

	public static int toBlockPos(double pos) {
		if (pos > 0) {
			return (int) Math.floor(pos);
		} else {
			return (int) Math.ceil(pos);
		}
	}
}
