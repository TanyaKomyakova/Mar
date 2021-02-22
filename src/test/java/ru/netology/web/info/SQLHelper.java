package ru.netology.web.info;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    public static String getPurchaseInformation() {
        val statusSQL = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1;";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "app", "pass"
        );
        ) {
            val statuses = runner.query(conn, statusSQL, new ScalarHandler<>());
            return String.valueOf(statuses);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public static String getInformationAboutBuyingOnCredit() {
        val statusSQL = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1;";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "app", "pass"
        );
        ) {
            val statuses = runner.query(conn, statusSQL, new ScalarHandler<>());
            return String.valueOf(statuses);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public static String getPaymentInformation() {
        val paymentSQL = "SELECT COUNT * FROM payment_entity ORDER BY created DESC LIMIT 1;";
        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "app", "pass"
        );
        ) {
            int count = runner.query(conn, paymentSQL, new ScalarHandler<>());
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}

