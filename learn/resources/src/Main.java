import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class Main {


    public static void main(String[] args ) throws Exception {
 //       //alternate1();
        File f = new File("file.txt");
 //       FileReader r = new FileReader(f);


        alternate2();


        String a = "";
        String b = "x";
        a += "b" + "c";
        a += b;

    }


    private static void alternate2()  {
        Object x = new Object();
        try {
            Test t = new Test();
        }finally{
            System.out.println("hi");
        }
        x.hashCode();

        System.gc();
    }

    private static void alternate1() {
        // Try w/ resources. Will close
        Object x = new Object();

        try (Test t = new Test()) {

            //throw new Exception("inside try-resource");

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println( x.hashCode() );
        }

        System.gc();
    }


}
