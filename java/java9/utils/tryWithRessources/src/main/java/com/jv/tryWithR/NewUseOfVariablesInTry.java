package com.jv.tryWithR;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NewUseOfVariablesInTry {

    public static void main(String args[]) throws FileNotFoundException {
        //Java 7 and +
        try(BufferedReader bf = new BufferedReader(new FileReader("test.txt"))){
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Java 9 and +
        //Declaration
        BufferedReader bf2 = new BufferedReader(new FileReader("test.txt"));
        //Final or effectively final in bufferedReader.
        try(bf2){

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
