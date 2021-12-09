package Backjoon.Basic;

import java.util.Scanner;

// X보다 작은 수
public class _10871 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int x = sc.nextInt();
    System.out.println();
    int[] arr = new int[n];
    for(int i =0;i<n;i++){
      arr[i] = sc.nextInt();
    }

    for(int i =0;i<arr.length;i++){
      if(arr[i] < x){
        System.out.print(arr[i]+" ");
      }
    }
  }
}
