package com.example.group4_icms;

import com.example.group4_icms.Functions.DAO.CustomerDAO;
import com.example.group4_icms.Functions.DAO.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** @see<a href=" https://do5do.tistory.com/1">...</a>5
 * @see https://jaeho4646.tistory.com/154
 *  */

public class connectionTest {

    private static final ExecutorService executor = Executors.newFixedThreadPool(10); // 10개의 스레드를 가진 스레드 풀 생성

    public CompletableFuture<List<String>> getAllCustomers() {

        long startTime = System.nanoTime();
        return CompletableFuture.supplyAsync(() -> {
            List<String> customers = new ArrayList<>();
            String sql = "SELECT * FROM customer";
            try (Connection conn = JDBCUtil.connectToDatabase();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    System.out.println(rs.getString("c_id"));
                    String customerData = "ID: " + rs.getString("c_id") + ", password: " + rs.getString("password") + ", phoneNumber: " + rs.getString("phonenumber") + ", address: " + rs.getString("address") + ", email: " + rs.getString("email");
                    customers.add(customerData);
                }

                long endTime = System.nanoTime();
                System.out.println((endTime - startTime));
            } catch (SQLException e) {
                System.out.println("Error fetching customers: " + e.getMessage());
                e.printStackTrace();
            }
            return customers;
        }, executor);
    }

    public static Connection connectToDatabaseAsync() {
        String dbUrl = "jdbc:postgresql://aws-0-ap-northeast-2.pooler.supabase.com:5432/postgres";
        String username = "postgres.cuokhartfcylrlxmhutx";
        String password = "fRvT6yOa8tmcejwE";
        try {
            return DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void disconnectAsync(PreparedStatement pstmt, Connection conn) {
        CompletableFuture.runAsync(() -> {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        connectionTest c1 = new connectionTest();
        System.out.println(c1.getAllCustomers());
        // 스레드 풀 생성
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//
//        // 비동기적으로 데이터베이스에 연결
//        CompletableFuture<Connection> connectFuture = CompletableFuture.supplyAsync(connectionTest::connectToDatabaseAsync, executor);
//
//        // 연결된 데이터베이스로부터 데이터를 가져오는 작업
//        connectFuture.thenAcceptAsync(conn -> {
//            // 데이터베이스 작업 수행
//            try {
//                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM customer");
//                ResultSet rs = pstmt.executeQuery();
//                while (rs.next()) {
//                    // 데이터 처리
//                }
//                // ResultSet, PreparedStatement, Connection 닫기
//                connectionTest.close(rs);
//                connectionTest.close(pstmt);
//                connectionTest.disconnectAsync(pstmt, conn); // 비동기적으로 연결 해제
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }, executor);
//
//        // 스레드 풀 종료
//        executor.shutdown();
//        long endTime = System.nanoTime();
//        System.out.println("Database connection time: " + (endTime - startTime) + " nanoseconds");
//    }
//
//    // ResultSet, PreparedStatement, Connection 닫기
//    public static void close(ResultSet rs) {
//        if (rs != null) {
//            try {
//                rs.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void close(PreparedStatement pstmt) {
//        if (pstmt != null) {
//            try {
//                pstmt.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
}

