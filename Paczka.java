import java.io.*;
import java.util.zip.ZipOutputStream;
import java.util.zip.*;

public class Paczka {


    public static void main(String[] args) {


        try{
            String tab = "baza.txt";

            ZipOutputStream zOutS = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("Paczka.zip", true)));
            BufferedInputStream inS = new BufferedInputStream(new FileInputStream(tab));

            zOutS.putNextEntry(new ZipEntry(tab));


            zOutS.closeEntry();

            inS.close();


        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage() );

        }









    }

}
