package com.jimmysun.algorithms.chapter2_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
归并排序
自顶向下的归并排序
 */
public class Merge {
    private static Comparable[] aux;

    /**
     * @param a   待排序的数组
     * @param lo  low
     * @param mid 中间索引
     * @param hi  high
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // 将 a[lo..mid] 和 a[mid+1..hi] 归并
        // 将 a[lo..hi] 复制到 aux[lo..hi]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        // k 从 lo 开始
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++]; // 说明左半边已经比较完成, 将 j(右半边) 赋给 k(lo)
            } else if (j > hi) {
                a[k] = aux[i++]; // 说明右半边已经比较完成, 将 i(左半边) 赋给 k(lo)
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++]; // 若 j值 小于 i值, 将 j(右半边) 赋给 k(lo)
            } else {
                a[k] = aux[i++]; // 若 i值 小于 j值, 将 i(左半边) 赋给 k(lo)
            }
        }
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2; //
        sort(a, lo, mid); // 将左半边排序
        sort(a, mid + 1, hi); // 将右半边排序
        merge(a, lo, mid, hi);
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
