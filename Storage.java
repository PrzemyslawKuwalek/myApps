package sample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Storage  {


    Storage(String sendMail){


        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("baza.txt", true));
            printWriter.append(sendMail);
            printWriter.println();


            printWriter.close();


        } catch (
                IOException ex) {
            System.out.println(ex.getMessage( ));
        }





    }











}
