/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Users;

/**
 *
 * @author GIA KHANH
 */
public class UserDao extends DBContext {

    public Users getUserByID(String id) {
        String sql = "select * from users\n"
                + "where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return (new Users(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9)));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void deleteUser(String pid) {
        String sql = "delete from users\n"
                + "  where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertUser(String username, String password,
            String email, String name, String phone,
            String address, String image) {
        String sql = "insert into users(username, password, email, name, phone, address, image)\n"
                + "  values(?,?,?,?,?,?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, name);
            ps.setString(5, phone);
            ps.setString(6, address);
            ps.setString(7, image);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editUser(String username, String password,
            String email, String name, String phone,
            String address, String image, String id) {
        String sql = "update users\n"
                + "  set username = ?,\n"
                + "  password = ?,email = ?,\n"
                + "  [name] = ?,phone = ?,"
                + "  address = ?, image = ?\n"
                + "  where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, name);
            ps.setString(5, phone);
            ps.setString(6, address);
            ps.setString(7, image);
            ps.setString(8, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateUser(String name,
            String email, String address,
            String phone, String image,
            String id) {
        String sql = "update users\n"
                + "  set name = ?,\n"
                + "  email = ?,\n"
                + "  address = ?,"
                + "  phone = ?\n, "
                + "  image = ?"
                + "  where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, phone);
            ps.setString(5, image);
            ps.setString(6, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getTotalUser() {
        String sql = "select count (*) from users";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Users> pagingUser(int index) {
        List<Users> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "    *\n"
                + "FROM\n"
                + "    users\n"
                + "ORDER BY id\n"
                + "OFFSET ? ROWS \n"
                + "FETCH NEXT 4 ROWS ONLY\n"
                + "\n"
                + "";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 4);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Users(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
     public Users checkDuplicateUserName(String username) {
        String sql = "select * from users\n"
                + "where username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
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

    public static void main(String[] args) {
        UserDao ud = new UserDao();
//        ud.updateUser("giakhanhpro9x", "giakhanh27403@gmail.com", "Long Bien, Ha Noi", "0372454714", "2");
//        ud.deleteUser("2");
        Users u = ud.checkDuplicateUserName("giakhanh");
        System.out.println(u);
    }
}
