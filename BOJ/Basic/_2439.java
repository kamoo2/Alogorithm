package Backjoon.Basic;

import java.util.Scanner;

// 별찍기
public class _2439 {
  public static void main(String[] args) {

    Scanner sc =new Scanner(System.in);
    int num = sc.nextInt();

    for(int i=1;i<=num;i++){
      for(int j=num-i;j>0;j--){
        System.out.print(" ");
      }
      for(int k = 1;k<=i;k++){
        System.out.print("*");
      }
      System.out.println();
    }
  }
}