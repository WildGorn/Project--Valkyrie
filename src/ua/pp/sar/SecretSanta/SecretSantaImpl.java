package ua.pp.sar.SecretSanta;

//import java.sql.Statement;

import sun.net.www.content.text.plain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by WildGorn on 08.01.14.
 */
public class SecretSantaImpl implements SecretSanta {
    private Connection connection;

    public SecretSantaImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void createGroup(String groupName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(groupName);
        statement.executeUpdate();
        System.out.println("Запись добавлена");
    }

    @Override
    public void addUser(Users users) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO santa(name) value (?)");
        statement.setString(1, users.getName());
        statement.executeUpdate();
        System.out.println("Запись добавлена");
    }

    @Override
    public ArrayList<Users> getAllUsers() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM santa");
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Users> users = new ArrayList<Users>();
        while (resultSet.next()) {
            Users user = resultSetToUsers(resultSet);
            users.add(user);
        }
        return users;
    }


    public ArrayList<String> genPair() throws SQLException {
        Random r = new Random();
        ArrayList<Users> users1 = new ArrayList<Users>(getAllUsers());
        ArrayList<Users> users2 = new ArrayList<Users>(getAllUsers());
        Users u1;
        Users u2;
        ArrayList<String> pair = new ArrayList<String>();
        while (users2.size() != 1) {
            int indexOfUser1 = r.nextInt(users1.size());
            int indexOFUser2 = r.nextInt(users2.size());
            u1 = users1.get(indexOfUser1);
            u2 = users2.get(indexOFUser2);
            int userID1 = u1.getId();
            int userID2 = u2.getId();
            if (userID1 != userID2) {
                String pair1 = u1.getName() + " дарить подарок " + u2.getName();
                System.out.println(pair1 + " String");
                pair.add(pair1);
                users1.remove(indexOfUser1);
                users2.remove(indexOFUser2);
            }
        }
//        int indexOfUser1 = r.nextInt(users1.size());
//        int indexOFUser2 = r.nextInt(users2.size());
        u1 = users1.get(0);
        u2 = users2.get(0);
        int userID1 = u1.getId();
        int userID2 = u2.getId();
        if (userID1 != userID2) {
            String pair1 = u1.getName() + " дарить подарок " + u2.getName();
            System.out.println(pair1 + " last String");
            pair.add(pair1);
            users1.remove(0);
            users2.remove(0);

        } else {
            genPair();
        }return pair;
    }


    private Users resultSetToUsers(ResultSet resultSet) throws SQLException {
        Users users = new Users();
        users.setId(resultSet.getInt("id_user"));
        users.setName(resultSet.getString("name"));
        return users;
    }


}