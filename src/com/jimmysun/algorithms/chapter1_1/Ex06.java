package com.jimmysun.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

public class Ex06 {
	public static void main(String[] args) {
		int f = 0;
		int g = 1;
		for (int i = 0; i <= 15; i++) {
			StdOut.println(f);//0 1 1 2
			f = f + g;
			g = f - g;
		}
	}
}
