/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Users;

/**
 *
 * @author GIA KHANH
 */
public class LoginDao extends DBContext {

    public Users login(Users user) {
        String sql = "select * from users\n"
                + "where username = ? and password = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users users = new Users(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getInt("role"),
                        rs.getString("image"));
                return users;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Users checkDuplicateUser(Users user) {
        String sql = "select * from users\n"
                + "where username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users users = new Users(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getInt("role"),
                        rs.getString("image"));
                return users;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
     public Users checkDuplicatePhone(Users user) {
        String sql = "select * from users\n"
                + "where phone = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getPhone());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users users = new Users(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getInt("role"),
                        rs.getString("image"));
                return users;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
     
      public Users checkDuplicateEmail(Users user) {
        String sql = "select * from users\n"
                + "where email = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users users = new Users(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getInt("role"),
                        rs.getString("image"));
                return users;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    

    public void register(Users users) {
        String sql = "insert into users(username, [password], email, [name], phone, [address], image)\n"
                + "values(?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, users.getUsername());
            ps.setString(2, users.getPassword());
            ps.setString(3, users.getEmail());
            ps.setString(4, users.getName());
            ps.setString(5, users.getPhone());
            ps.setString(6, users.getAddress());
            ps.setString(7, users.getImage());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
