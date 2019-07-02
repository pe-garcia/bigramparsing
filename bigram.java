/***************************************************************************************
Compilation: javac bigram.java
Execution: java bigram

Author: Pedro Garcia
Language: Java
Date: 7/2/19
Purpose: This program accepts a text file as input and then creates a bigram from all 
        adjacent words in the text. The program then outputs all unique bigrams
        and the number of times they appeared in the text. Specify text file path name
        if it is not within the working directory. 

****************************************************************************************/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class bigram {

    public static void main(String[] args)throws Exception{
        Scanner myScan = new Scanner(System.in);

        System.out.println("Enter text file to be read: ");
        String text = myScan.nextLine();

        File file = new File(text);

        BufferedReader buff = new BufferedReader(new FileReader(file));

        String lines;
        String caplines ="";

        //Capture all the lines and store inside a string
        while((lines = buff.readLine()) != null){
            //System.out.println((lines));
            caplines += lines;
        }
        
        //Remove all the punctuations, convert to lowercase, and separate by words. 
        ArrayList<String> wordlist = new ArrayList<String>();
        for(String word:caplines.split("[\\.,\\s!;?:\"]+",0)){
            word = word.toLowerCase();
            wordlist.add(word);
        }

        //Combine words and omit adding if it already exists in the list. 
        ArrayList<String> bigramlist = new ArrayList<String>();
        ArrayList<Integer> bigramcount = new ArrayList<Integer>();
        String combo;
        for(int i = 0; i+1 < wordlist.size();i++){
            combo = wordlist.get(i) + " " + wordlist.get(i+1);
            if(!bigramlist.contains(combo)){
                bigramlist.add(combo);
                bigramcount.add(1);
            } else{
                int index = bigramlist.lastIndexOf(combo);
                bigramcount.set(index,bigramcount.get(index)+1);

            }
            combo = "";
        }
        
        //Output all bigrams and the number of times they appeared. 
        int start = 0;
        while (bigramlist.size() > start) {
            System.out.println(bigramlist.get(start) + " " + bigramcount.get(start));
                start++;
        }
    }
}