package ua.pp.sar.SecretSanta;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by WildGorn on 08.01.14.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        SecretSantaImpl test = new SecretSantaImpl(ConnectedToDatabase.getConnection("root", "231187gorn"));
      /*  String name;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//       System.out.println("Введите название группы: ");
//        String inName = reader.readLine();
//        String gName = "CREATE TABLE `" + inName + "`( id_user INT PRIMARY KEY AUTO_INCREMENT NOT NULL, name VARCHAR(45) NOT NULL, last_name VARCHAR(45) NOT NULL )";

//        test.createGroup(gName);


        do{
            System.out.println("Введите пользователя: ");
            name = reader.readLine();
            if(!name.isEmpty()){
            Users user = new Users(name);
            test.addUser(user);
            }
        }while (! name.isEmpty());

        ArrayList<Users> users = new ArrayList<Users>(test.getAllUsers());

        for(Users u : users)
            System.out.println(u.getName());
            */

        ArrayList<String> pair = test.genPair();
        System.out.println();
        for(String p : pair){
            System.out.println(p);
        }
    }

}
