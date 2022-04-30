/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.abhishekojha.server1.aospract5;
import java.util.*;
/**
 *
 * @author aayus
 */
public class AOSPRACT5 {

  double avgst, totst;
 
    void fcfs(int a[], int p) {
        totst = Math.abs(p - a[0]);
        for (int i = 0; i < a.length - 1; i++) {
            totst += Math.abs(a[i] - a[i + 1]);
        }
        avgst = totst / a.length;
        System.out.println("Total seek time: " + totst);
        System.out.println("Average seek time: " + avgst);
    }
 
    void sstf(int a[], int p) {
        boolean done[] = new boolean[a.length];
        int strtpt = p;
        while (!allSelected(done)) {
            int m = 0;
            int mindiff = 1000;
            for (int i = 0; i < a.length; i++) {
                if (!done[i]) {
                    int diff = Math.abs(strtpt - a[i]);
                    if (diff < mindiff) {
                        m = i;
                        mindiff = diff;
                    }
                }
            }
            totst += mindiff;
            strtpt = a[m];
            done[m] = true;
        }
        avgst = totst / a.length;
        System.out.println("Total seek time: " + totst);
        System.out.println("Average seek time: " + avgst);
    }
 
    boolean allSelected(boolean[] a) {
        for (int i = 0; i < a.length; i++) {
            if (!a[i]) {
                return false;
            }
        }
        return true;
    }
 
    public static void main(String arg[]) {
 
        Scanner sc = new Scanner(System.in);
        int c;
        do {
 	  System.out.println("Brijesh Yadav - 013");
            System.out.println("Enter no. of elements:");
            int n = sc.nextInt();
            System.out.println("Enter value of track nos. in the array:");
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println("Enter starting point:");
            int p = sc.nextInt();
            System.out.println("\nEnter your choice:\n1. FCFS\n2. SSTF");
            int ch = sc.nextInt();
            AOSPRACT5 ds = new AOSPRACT5();
            if (ch == 1) {
                ds.fcfs(a, p);
            } else {
                ds.sstf(a, p);
            }
            System.out.println("do u wanna continue(1/0)");
            c = sc.nextInt();
        } while (c == 1);
    }
}
