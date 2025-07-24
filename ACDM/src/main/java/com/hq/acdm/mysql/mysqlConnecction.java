//package com.hq.acdm.mysql;
//
///**
// * @author wangshuhao
// * @date 2018/11/12 0012 20:15
// */
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//import org.springframework.stereotype.Service;
//
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@Service("mysqlConnecction")
//public class mysqlConnecction {
//    private static Connection getConn() {
//        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://10.161.130.30:3400/seccheck2";
//        String username = "anjian";
//        String password = "anjian123";
//        Connection conn = null;
//        try {
//            Class.forName(driver); //classLoader,加载对应驱动
//            conn = (Connection) DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
//
//    public List<AreaPeopleNumber> getInfoFromMysql() {
//        Connection conn = getConn();
//        String sql = "SELECT * FROM v_area_pcnt";
//        PreparedStatement pstmt;
//        List<AreaPeopleNumber> list = new ArrayList<>();
//        try {
//            pstmt = (PreparedStatement) conn.prepareStatement(sql);
//            ResultSet rs = pstmt.executeQuery();
//            System.out.println("============================");
//            while (rs.next()) {
//                String terminal = rs.getString("ternimal");
//                String area = rs.getString("area");
//                String lstu = rs.getString("lstu");
//                int pcnt = rs.getInt("pcnt");
//                AreaPeopleNumber areaPeopleNumber = new AreaPeopleNumber(terminal,area,pcnt,lstu);
//                list.add(areaPeopleNumber);
//                System.out.println("");
//            }
//            System.out.println("============================");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//}
