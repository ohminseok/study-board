package com.minseok.studyboard.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.assertj.core.api.Fail.fail;

public class DataSoruceTest {

    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {

        try(Connection con =
                    DriverManager.getConnection(
                            "jdbc:mariadb://localhost:3306/test?serverTimezone=UTC&characterEncoding=UTF-8",
                            "root",
                            "root")){
            System.out.println(con);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
}
