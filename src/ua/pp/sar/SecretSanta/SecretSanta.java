package ua.pp.sar.SecretSanta;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by WildGorn on 08.01.14.
 */
public interface SecretSanta {

    public void createGroup(String groupName) throws SQLException;

    public void addUser(Users users) throws SQLException;

    public ArrayList<Users> getAllUsers() throws SQLException;

//    public  void genPair() throws SQLException;
}
