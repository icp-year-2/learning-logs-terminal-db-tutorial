package com.learninglogs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ╔══════════════════════════════════════════════════════╗
 * ║       QUEST: Build the Database Connection Utility   ║
 * ║                                                      ║
 * ║   Complete all TODOs below to earn XP!               ║
 * ║   Total XP available in this file: 70 XP             ║
 * ╚══════════════════════════════════════════════════════╝
 *
 * This utility class manages the connection to your MySQL database.
 *
 * Think of it like a **reception desk** at a hotel:
 *   - getConnection()   → "Check in" — gives you a room key (Connection)
 *   - closeConnection() → "Check out" — returns the key so others can use it
 *
 * Why keep this in a separate class?
 *   - DB credentials stay in ONE place (easy to change)
 *   - Every DAO class reuses the same connection logic
 *   - If you switch databases later, you only change this file
 *
 * XAMPP Default Credentials:
 *   - URL:      jdbc:mysql://localhost:3306/learning_logs
 *   - Username: root
 *   - Password: (empty — no password by default in XAMPP)
 */
public class DatabaseConnection {

    // ============================================================
    // TODO 5: Declare the connection constants (+30 XP)
    // ============================================================
    // Declare these three private static final String constants:
    //
    //   DB_URL      = "jdbc:mysql://localhost:3306/learning_logs"
    //   DB_USER     = "root"
    //   DB_PASSWORD  = ""
    //
    // What does each part of the URL mean?
    //
    //   jdbc:mysql://localhost:3306/learning_logs
    //   ├── jdbc:mysql://   → Protocol — tells Java to use JDBC with MySQL
    //   │                     (like http:// tells a browser to use HTTP)
    //   ├── localhost        → Host — the database is on YOUR computer
    //   │                     (in production, this would be a server address)
    //   ├── 3306             → Port — MySQL's default port number
    //   │                     (like a door number in a building)
    //   └── learning_logs    → Database name — which database to connect to
    //                          (you created this when you imported learninglog.sql)
    //
    // Why "root" with an empty password?
    //   XAMPP creates a default MySQL user called "root" with no password.
    //   In a real production app, you'd NEVER do this — you'd use a
    //   secure username and password. But for learning, this is fine.
    //
    // Why static final?
    //   - static  → belongs to the class, not to any instance
    //   - final   → the value can never change (it's a constant)
    //   Together, they mean: "one fixed value shared by everyone"
    //
    // Hint:
    //   private static final String DB_URL = "jdbc:mysql://localhost:3306/learning_logs";
    //   private static final String DB_USER = "root";
    //   private static final String DB_PASSWORD = "";
    // ============================================================



    // ============================================================
    // TODO 6: Implement getConnection() (+20 XP — ACHIEVEMENT: Connector!)
    // ============================================================
    // This method should:
    //   Use DriverManager.getConnection() to create and return
    //   a new database connection.
    //
    // What is DriverManager?
    //   It's Java's built-in "phone operator" — you give it a URL,
    //   username, and password, and it finds the right JDBC driver
    //   (mysql-connector-j) and connects you to the database.
    //
    // Why does this method throw SQLException?
    //   If the database is down, credentials are wrong, or the URL
    //   is invalid, DriverManager will throw a SQLException.
    //   We let the caller handle it (the DAO classes catch it).
    //
    // Hint:
    //   return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    // ============================================================
    public static Connection getConnection() throws SQLException {
        // Write your code here

        return null; // ← Replace this
    }

    // ============================================================
    // TODO 7: Implement closeConnection() (+20 XP)
    // ============================================================
    // This method should:
    //   1. Check if the connection is NOT null
    //   2. If not null, call connection.close()
    //
    // Why check for null first?
    //   If getConnection() failed (threw an exception), the connection
    //   variable will still be null. Calling .close() on null would
    //   throw a NullPointerException — a crash!
    //   The null check prevents this: "only close if there's
    //   something to close."
    //
    // Why is closing important?
    //   A database can only handle ~150 connections at once.
    //   If you open connections without closing them, eventually
    //   the database runs out — like leaving every tap in a
    //   building running until there's no water pressure.
    //
    // Hint:
    //   try {
    //       if (connection != null) {
    //           connection.close();
    //       }
    //   } catch (SQLException e) {
    //       System.out.println("Error closing connection: " + e.getMessage());
    //   }
    // ============================================================
    public static void closeConnection(Connection connection) {
        // Write your code here
    }
}
