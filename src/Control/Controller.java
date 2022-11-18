/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.CategoryUser;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class Controller {

    static DatabaseHandler conn = new DatabaseHandler();

    public boolean checkLogin(String username, char[] password) {
        conn.connect();
        String query = "SELECT * FROM user WHERE userName = '" + username + "' AND userPassword='" + password.toString() + "'";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CategoryUser category = getCategoryUserWithId(rs.getInt("userCategory"));
                User curUser = new User(rs.getInt("userId"), rs.getString("userName"), rs.getString("userEmail"), rs.getString("userPassword"), rs.getString("userGender"), category, rs.getInt("userFollowers"));
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public CategoryUser getCategoryUserWithId(int userCategory) {
        conn.connect();
        String query = "SELECT * FROM categoryuser WHERE ";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CategoryUser curCategory = new CategoryUser(rs.getInt("categoryId"), rs.getString("categoryName"));
                return curCategory;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CategoryUser> getAllCategory() {
        ArrayList<CategoryUser> listCategory = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM categoryuser";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CategoryUser curCategory = new CategoryUser(rs.getInt("categoryId"), rs.getString("categoryName"));
                listCategory.add(curCategory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listCategory);
    }
}
