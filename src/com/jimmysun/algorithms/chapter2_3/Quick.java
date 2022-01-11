package com.jimmysun.algorithms.chapter2_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        // 切分元素
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /*
    partition 分区
    返回索引 j 使得
    	a[lo] 到 a[j-1] 中的所有元素都不大于 a[j]
    	a[j+1] 到 a[hi] 中的所有元素都不小于 a[j]
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            // 从低位lo开始，依次比较 lo 与 ++lo(i)
            // 找到第一个元素a[i], 使得a[i] >= a[lo], 则退出循环
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            // 从高位hi开始，依次比较 --hi(j) 与 lo
            // 找到第一个元素a[j], 使得a[j] <= a[lo], 则退出循环
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            // 如果 i < j, 交换 a[i] a[j], 继续循环
            exch(a, i, j);
        }
        // 交换 a[lo], a[j]
        exch(a, lo, j);
        return j;
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
