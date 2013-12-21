package ua.pp.sar.lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WildGorn on 21.12.13.
 */
public class lab1{

    public static void main(String[] args) throws IOException {

        System.out.println("ВВедите имя");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        StringBuffer sb = new StringBuffer();
        sb.append("Hello,");
        sb.append(" ");
        sb.append(s);
        System.out.println(sb.toString());
    }
}
