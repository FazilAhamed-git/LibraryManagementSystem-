package dao;

import model.User;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public boolean registerUser(User user) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "INSERT INTO users(name,mobile,email,password) VALUES(?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getMobile());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());

            int rows = ps.executeUpdate();

            status = rows > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public User loginUser(String mobile, String password) {

        User user = null;

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "SELECT * FROM users WHERE mobile=? AND password=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, mobile);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                user = new User();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setMobile(rs.getString("mobile"));
                user.setEmail(rs.getString("email"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
