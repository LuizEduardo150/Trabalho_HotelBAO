package IFMG_LuizEduardo_RenatoZampiere.utils;

import java.util.Scanner;


public class InputOutputPers {

    private final Scanner scanner;

    public InputOutputPers(){
        scanner = new Scanner(System.in);
    }

    public void print(String text){
        System.out.print(text);
    }

    public String input(String text){
        this.print(text);
        return scanner.nextLine();
    }


}
