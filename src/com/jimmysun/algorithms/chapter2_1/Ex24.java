package com.jimmysun.algorithms.chapter2_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * 插入排序的哨兵
 * 在插入排序的实现中，先找出最小的元素并将其置于数组最左边
 * 这样就能去掉内循环的判断条件 j > 0
 * ps: 这是一种常见的规避边界测试的方法，
 * 能够省略判断条件的元素通常称为哨兵
 */
public class Ex24 {
	public static void sort(Comparable[] a) {
		int N = a.length;
		boolean isExchanged = false;
		for (int i = N - 1; i > 0; i--) {
			if (less(a[i], a[i - 1])) {
				exch(a, i, i - 1);
				isExchanged = true;
			}
		}
		if (!isExchanged) {
			return;
		}
		for (int i = 2; i < N; i++) {
			for (int j = i; less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
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
		SortCompare.main("Ex24 Insertion 10000 100".split(" "));
	}
}
