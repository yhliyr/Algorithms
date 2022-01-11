package com.jimmysun.algorithms.chapter2_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * 不需要交换的插入排序
 */
public class Ex25 {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			Comparable temp = a[i];
			int j = i;
			// 将 a[i] 插入到已排序的列表中
			// 插入的方式是将原来的列表中较大的元素右移
			for (; j > 0 && less(temp, a[j - 1]); j--) {
				a[j] = a[j - 1];
			}
			// 比较完后将 a[i] 放在合适的位置
			a[j] = temp;
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
		SortCompare.main("Ex25 Insertion 10000 100".split(" "));
	}
}
