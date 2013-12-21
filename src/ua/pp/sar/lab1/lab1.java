package ua.pp.sar.lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WildGorn on 21.12.13.
 */
public class lab1 {

    public static void main(String[] args) throws IOException {

        System.out.println("Введите имя");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        StringBuffer sb = new StringBuffer();


        if (s.isEmpty()) {
            System.out.println("Привет незнакомец");
        } else {
            sb.append("Hello, ");
            sb.append(s);
            sb.append("!");
            System.out.println(sb.toString());
        }
    }
}
