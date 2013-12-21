package ua.pp.sar.lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * Created by WildGorn on 21.12.13.
 */
public class lab2 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите значение: а");
        String sb1 = reader.readLine();
        System.out.println("Введите значение: b");
        String sb2 = reader.readLine();
        System.out.println("Введите значение: c");
        String sb3 = reader.readLine();
        double a = Double.valueOf(sb1);
        double b = Double.valueOf(sb2);
        double c = Double.valueOf(sb3);
        double x1, x2;
        double d = Math.pow(b, 2) - 4 * a * c;

        if (d > 0) {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);
            BigDecimal scaleX1 = new BigDecimal(x1);
            scaleX1 = scaleX1.setScale(4, BigDecimal.ROUND_HALF_UP);
            x1 = scaleX1.doubleValue();
            BigDecimal scaleX2 = new BigDecimal(x2);
            scaleX2 = scaleX2.setScale(4, BigDecimal.ROUND_HALF_UP);
            x2 = scaleX2.doubleValue();
            System.out.println("Корень Х1 = " + x1 + ", корень Х2 = " + x2);
        } else if (d == 0) {
            x1 = -b / (2 * a);
            System.out.println("Корень один = " + x1);
        } else
            System.out.println("Корней не существует");


    }
}
