package com.learninglogs.dao;

import com.learninglogs.entity.Topic;
import com.learninglogs.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * ╔══════════════════════════════════════════════════════╗
 * ║       QUEST: Build the Topic DAO Implementation      ║
 * ║                                                      ║
 * ║   Complete all TODOs below to earn XP!               ║
 * ║   Total XP available in this file: 120 XP             ║
 * ╚══════════════════════════════════════════════════════╝
 *
 * This class implements the TopicDao interface.
 * It contains the actual database queries for topics.
 *
 * Key JDBC concepts you'll use:
 *   - Connection      → your link to the database
 *   - PreparedStatement → a safe way to run SQL queries
 *   - ResultSet        → the rows returned by a SELECT query
 *
 * Pattern for every database method:
 *   1. Get a connection
 *   2. Prepare an SQL statement
 *   3. Execute the query
 *   4. Process the results
 *   5. Close the connection (in a finally block)
 */
public class TopicDaoImpl implements TopicDao {

    // ============================================================
    // TODO 8: Implement insertTopic() (+50 XP — ACHIEVEMENT: Engineer!)
    // ============================================================
    // This method should:
    //   1. Get a database connection
    //   2. Prepare an INSERT SQL statement
    //   3. Set the topic name as a parameter
    //   4. Execute the update
    //   5. Return true if successful, false if not
    //   6. Close the connection in a finally block
    //
    // SQL to use: "INSERT INTO topics (name) VALUES (?)"
    //
    // The ? is a placeholder — you fill it with:
    //   statement.setString(1, topic.getName());
    //
    // Why use PreparedStatement instead of string concatenation?
    //   It prevents SQL injection attacks!
    //   BAD:  "INSERT INTO topics (name) VALUES ('" + name + "')"
    //   GOOD: "INSERT INTO topics (name) VALUES (?)"
    //
    // Hint:
    //   Connection conn = null;
    //   try {
    //       conn = DatabaseConnection.getConnection();
    //       String sql = "INSERT INTO topics (name) VALUES (?)";
    //       PreparedStatement statement = conn.prepareStatement(sql);
    //       statement.setString(1, topic.getName());
    //       statement.executeUpdate();
    //       return true;
    //   } catch (SQLException e) {
    //       System.out.println("Error inserting topic: " + e.getMessage());
    //       return false;
    //   } finally {
    //       DatabaseConnection.closeConnection(conn);
    //   }
    // ============================================================
    @Override
    public boolean insertTopic(Topic topic) {
        // Write your code here
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO topics (name) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, topic.getName());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error inserting topic: " + e.getMessage());
            return false;
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
    }

    // ============================================================
    // TODO 9: Implement fetchAllTopics() (+70 XP — ACHIEVEMENT: Builder!)
    // ============================================================
    // This method should:
    //   1. Create an empty ArrayList<Topic>
    //   2. Get a database connection
    //   3. Prepare a SELECT SQL statement
    //   4. Execute the query to get a ResultSet
    //   5. Loop through each row in the ResultSet
    //   6. For each row, create a Topic object and add it to the list
    //   7. Return the list
    //   8. Close the connection in a finally block
    //
    // SQL to use: "SELECT * FROM topics"
    //
    // Reading columns from a ResultSet:
    //   rs.getInt("id")              → gets the id column
    //   rs.getString("name")         → gets the name column
    //   rs.getTimestamp("created_at") → gets the created_at column
    //   rs.getTimestamp("updated_at") → gets the updated_at column
    //
    // Loop through results:
    //   while (rs.next()) {
    //       // each call to rs.next() moves to the next row
    //   }
    //
    // Hint:
    //   ArrayList<Topic> topics = new ArrayList<>();
    //   Connection conn = null;
    //   try {
    //       conn = DatabaseConnection.getConnection();
    //       String sql = "SELECT * FROM topics";
    //       PreparedStatement statement = conn.prepareStatement(sql);
    //       ResultSet rs = statement.executeQuery();
    //       while (rs.next()) {
    //           Topic topic = new Topic(
    //               rs.getInt("id"),
    //               rs.getString("name"),
    //               rs.getTimestamp("created_at"),
    //               rs.getTimestamp("updated_at")
    //           );
    //           topics.add(topic);
    //       }
    //   } catch (SQLException e) {
    //       System.out.println("Error fetching topics: " + e.getMessage());
    //   } finally {
    //       DatabaseConnection.closeConnection(conn);
    //   }
    //   return topics;
    // ============================================================
    @Override
    public ArrayList<Topic> fetchAllTopics() {
        // Write your code here
        ArrayList<Topic> topics = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM topics";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Topic topic = new Topic(                    
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
                );
                topics.add(topic);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching topics: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(conn);
        }
        return topics;
    }
}
