/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.abhishekojha.server1.aospract7;
import java.io.*;
/**
 *
 * @author aayus
 */
public class AOSPRACT7 {

   public static void main(String[] args) throws IOException {
        {
            System.out.println("Brijesh Yadav - 013 ");
 
            int n = 0;
            int fifo[] = new int[5];
 
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter no of inputs : ");
            n = Integer.parseInt(br.readLine());
            int inp[] = new int[5];
            System.out.println("Enter the inputs : ");
            for (int i = 0; i < 5; i++) {
                inp[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < 5; i++) {
                fifo[i] = -1;
            }
            int hit = 0;
            int fault = 0;
            int j = 0;
            boolean check;
            for (int i = 0; i < 5; i++) {
                check = false;
                for (int k = 0; k < 5; k++) {
                    if (fifo[k] == inp[i]) {
                        check = true;
                        hit = hit + 1;
                    }
                }
                if (check == false) {
                    fifo[j] = inp[i];
                    j++;
                    if (j >= 4) {
                        j = 0;
                    }
                    fault = fault + 1;
                }
            }
            System.out.println("hits are : " + hit + "\nfaults are :" + fault);
 
        }
 
    }

}
