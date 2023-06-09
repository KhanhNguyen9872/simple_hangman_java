package game;

import java.util.Scanner;

public class hangman {
    private static char[] strfail;
    private static char[] strsucc;
    private static char[] strlist;
    private static String final_answer;
    private static int count_strfail = 0;
    private static int count_strsucc = 0;
    private static int lengthstr = 0;
    private static int is_success = 0;
    private static int score = 0;
    private static boolean is_done = false;
    
    private static void clear() {
        try {
            // replace clear to cls if you use Windows!
            Runtime.getRuntime().exec("clear");
        }
        catch (Exception e) {
            
        }
    }
    
    private static int getlengthstr(char[] lst) {
        int tmp=0;
        for(int i=0; i<lst.length; i++) {
            if (lst[i] != ' ') {
                tmp++;
            }
        }
        return tmp;
    }
    
    private static int[] getindexspace(char[] lst) {
        int[] index = new int[lst.length];
        for(int i=0; i<lst.length; i++) {
            if(lst[i] == ' ') {
                index[i] = i;
            } else {
                index[i] = -1;
            }
        }
        return index;
    }
    
    private static char[] getstringlst() {
        clear();
        Scanner input = new Scanner(System.in);
        while (true) {
           System.out.print("Text: ");
           hangman.final_answer = input.nextLine().toLowerCase();
           if (hangman.final_answer != "") {
               break;
           }
        }
        char[] strlist = new char[hangman.final_answer.length()];
        int count = 0;
        for(char c : hangman.final_answer.toCharArray()) {
            strlist[count] = c;
            count++;
        }
        return strlist;
    }
    
    private static boolean checkinput(String str) {
        if(str == "") {
            return true;
        } else {
            if (str.contentEquals(hangman.final_answer)) {
                hangman.is_success = 1;
                hangman.is_done = true;
                return true;
            }
        }
        for(int i=0; i<hangman.strsucc.length; i++) {
            if (str.charAt(0) == hangman.strsucc[i]) {
                return false;
            }
        }
        return true;
    }
    
    private static void printhidden(int[] lst, int size) {
        boolean tmp = false;
        System.out.println();
        for(int i=0; i<size; i++) {
            System.out.print("|");
            if(lst[i] != -1) {
                System.out.print(" ");
            } else {
                if (!hangman.is_done) {
                    tmp = false;
                    for(int j=0; j<hangman.count_strsucc; j++) {
                        if (hangman.strsucc[j] == hangman.strlist[i]) {
                            System.out.print(hangman.strlist[i]);
                            tmp = true;
                        }
                    }
                    if (!tmp) {
                        System.out.print("_");
                    }
                } else {
                    System.out.print(hangman.strlist[i]);
                }
            }
        }
        System.out.println("|");
    }
    
    private static void process(String str) {
        if (str == "") {
            return;
        }
        if (str == hangman.final_answer) {
            hangman.is_success = 1;
            return;
        }
        int is_not = 1;
        for(int i=0; i<hangman.strlist.length; i++) {
            if (str.charAt(0) == hangman.strlist[i]) {
                is_not = 0;
            }
        }
        if (is_not == 1) {
            hangman.strfail[hangman.count_strfail] = str.charAt(0);
            hangman.count_strfail++;
            hangman.score = hangman.score - 1;
        } else {
            hangman.strsucc[hangman.count_strsucc] = str.charAt(0);
            for(int j=0; j<hangman.strlist.length; j++) {
                if (str.charAt(0) == hangman.strlist[j]) {
                    hangman.count_strsucc++;
                }
            }
        }
        if (hangman.score < 1) {
            hangman.is_success = -1;
        }
        if (hangman.lengthstr <= hangman.count_strsucc) {
            hangman.is_success = 1;
        }
    }
    
    public static void run(int score) {
        Scanner input = new Scanner(System.in);
        hangman.score = score;
        hangman.strlist = getstringlst();
        int[] indexlist = getindexspace(hangman.strlist);
        hangman.lengthstr = getlengthstr(hangman.strlist);
        
        /////
        hangman.strfail = new char[hangman.strlist.length];
        for(int i=0; i<strfail.length; i++) {
            strfail[i] = '~';
        }
        hangman.strsucc = new char[hangman.strlist.length];
        for(int i=0; i<strsucc.length; i++) {
            strsucc[i] = '~';
        }
        /////
        
        clear();
        while (hangman.is_success == 0) {
            System.out.println("\n\nYour score: " + String.valueOf(hangman.score));
            System.out.print("Error: ");
            for(int i=0; i<hangman.strfail.length; i++) {
                if (hangman.strfail[i] != '~') {
                    System.out.print(hangman.strfail[i] + " ");
                }
            }
            printhidden(indexlist,hangman.strlist.length);
            System.out.print("\nInput: ");
            String _userinp = input.nextLine().toLowerCase();
            if (checkinput(_userinp)) {
                if (!hangman.is_done) {
                    process(_userinp);
                }
            } else {
                System.out.println("You already input this!");      
            }
        }
        clear();
        printhidden(indexlist,hangman.strlist.length);
        if (hangman.is_success == -1) {
            System.out.println("\nYou lose!");
        } else {
            System.out.println("\nYou won!");
        }
    }
}
