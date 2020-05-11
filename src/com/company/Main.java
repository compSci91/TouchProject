package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // pass the path to the file as a parameter
        File file =
                new File("/Volumes/GoogleDrive/My Drive/study/A1/Data/aConsensus.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());

       // System.out.println("Hello, world!");

        //"/Volumes/GoogleDrive/My Drive/study/A1/Data/aConsensus.txt"
    }
}
