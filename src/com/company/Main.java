package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file =
                new File("/Volumes/GoogleDrive/My Drive/study/A1/Data/aConsensus.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String touch = sc.nextLine();
            String[] touchArray = touch.split(",");

            System.out.print("[");

            for(String touchData : touchArray){
                System.out.print(touchData + ",");
            }
            System.out.print("]");

            System.out.println();
        }



    }
}
