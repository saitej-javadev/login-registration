package com.saitej.repos;

import com.saitej.model.User;
import com.saitej.utils.DBUtil;
import com.saitej.utils.DateUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UserRepository {

    public static final String SELECT = "SELECT USER_NAME,PASSWORD FROM USER_TBL WHERE USER_NAME=? AND PASSWORD=?";
    private static final String INSERT = "INSERT INTO USER_TBL(USER_NAME,PASSWORD,EMAIL,MOBILE_NUMBER,TIMESTAMP) VALUES (?,?,?,?,?)";

    public int saveUser(User user) {
        System.out.println("UserRepository.saveUser()");
        int count = 0;
        Connection con = DBUtil.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(INSERT);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPass());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getContact());
            ps.setString(5, DateUtil.format(LocalDateTime.now()));
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void loginUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
        System.out.println("UserRepository.loginUser");

        Connection con = DBUtil.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement(SELECT);
            ps.setString(1, request.getParameter("username"));
            ps.setString(2,  request.getParameter("password"));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                session.setAttribute("name", rs.getString(1));
                dispatcher = request.getRequestDispatcher("index.jsp");
            } else {
                request.setAttribute("status", "failed");
            }
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}

