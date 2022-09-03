package ru.netology.data;

import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {

    static String url = System.getProperty("db.url");
    static String user = System.getProperty("db.user");
    static String password = System.getProperty("db.password");

    @SneakyThrows
    public static void cleanTable() {
        val deletePaymentEntity = "DELETE FORM payment_entity";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(url, user, password)) {
            runner.update(conn, deletePaymentEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public static String getPaymentStatus() {
        String statusSQL= "SELECT status FORM payment_entity";
        return getStatus(statusSQL);
    }

    @SneakyThrows
    public static String getStatus(String query) {
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(url, user, password)) {
            String status = runner.query(conn, query, new ScalarHandler<String>());
            return status;
        }
    }
}
