

import java.util.Scanner;
// import lib.*;
import game.*;

public class Main {
    
    public static void main(String[] args) {
//
          // Nhap mang va in mang
//        Scanner input = new Scanner(System.in);
//        System.out.print("Nhap n: ");
//        int n = input.nextInt();
//        int[] lst = new int[n];
//        lst = stdlib.inputlst(lst);
//        stdlib.printlst(lst);
//
//
//
        // Nhap n va in ra hinh tam giac
//        Scanner input = new Scanner(System.in);
//        System.out.print("Nhap n: ");
//        int n = input.nextInt();
//        for(int i=1; i<=n; i++) {
//            for(int j=1; j<=i; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//
//
//
        // Nhap 1 mang n, sap xep tu be den lon va nguoc lai
//        Scanner input = new Scanner(System.in);
//        System.out.print("Nhap n: ");
//        int n = input.nextInt();
//        int[] lst = new int[n];
//        lst = stdlib.inputlst(lst);
//        lst = stdlib.sort(lst,false);
//        stdlib.printlst(lst);
//        lst = stdlib.sort(lst,true);
//        stdlib.printlst(lst);
//
//
        // Hangman
        int score = 6;
        Scanner input = new Scanner(System.in);
        System.out.print(" Welcome to Hangman!\n Press 'Y' and Enter to start the game!\n Choose: ");
        char userinp = input.nextLine().charAt(0);
        if (userinp == 'Y') {
            hangman.run(score);
        }
    }
    
}
