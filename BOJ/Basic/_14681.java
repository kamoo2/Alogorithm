package Backjoon.Basic;

import java.util.Scanner;

// 백준: 14681번 - 사분면 고르기
public class _14681 {
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int x = sc.nextInt();
    int y = sc.nextInt();

    if(x>0){
      if(y>0){
        System.out.println(1);
      }else{
        System.out.println(4);
      }
    }else{
      if(y>0){
        System.out.println(2);
      }else{
        System.out.println(3);
      }
    }
  }
}
