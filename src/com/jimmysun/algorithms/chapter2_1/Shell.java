package com.jimmysun.algorithms.chapter2_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 希尔排序
 * 基于插入排序
 * 适用于子数组部分有序
 */
public class Shell {
	/**
	 * 将 a[] 按升序排列
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		// 确定 h 大小，1，4，13，40，121，364
		while (h < N / 3) {
			h = 3 * h + 1;
		}
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				// j 为 i 之前 h 长度
				// 将 a[i] 插入到 a[i-h], a[i-2*h]...
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			h = h / 3;
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] a = new In().readAllStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
