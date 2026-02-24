package com.learninglogs.entity;

import java.sql.Timestamp;

/**
 * ╔══════════════════════════════════════════════════════╗
 * ║           QUEST: Build the Topic Entity              ║
 * ║                                                      ║
 * ║   Complete all TODOs below to earn XP!               ║
 * ║   Total XP available in this file: 110 XP            ║
 * ╚══════════════════════════════════════════════════════╝
 *
 * A Topic represents a subject you are learning about.
 * This class maps to the `topics` table in your database:
 *
 *   ┌─────────────────────────────────────────────┐
 *   │  topics table                                │
 *   ├────────────┬────────────────────────────────┤
 *   │ id         │ INT, AUTO_INCREMENT, PRIMARY KEY│
 *   │ name       │ VARCHAR(100), NOT NULL          │
 *   │ created_at │ TIMESTAMP                       │
 *   │ updated_at │ TIMESTAMP                       │
 *   └────────────┴────────────────────────────────┘
 *
 * Each field in this class matches a column in the table.
 * When you read from the database, you create a Topic object
 * and fill it with the row data.
 */
public class Topic {

    // ============================================================
    // TODO 1: Declare the fields (+10 XP each = 40 XP)
    // ============================================================
    // Declare these private fields below this comment:
    //   - int id
    //   - String name          ← (provided — needed by the constructor below)
    //   - Timestamp createdAt
    //   - Timestamp updatedAt
    //
    // Why Timestamp instead of LocalDateTime?
    //   The database stores timestamps as java.sql.Timestamp.
    //   Using Timestamp here makes it easy to map database columns
    //   directly to Java fields using ResultSet.getTimestamp().
    //
    // Hint: private int id;
    // ============================================================
    private String name; // ← provided (needed by the simple constructor)



    /**
     * Simple constructor for creating a topic to INSERT into the database.
     * (PROVIDED — no changes needed)
     *
     * When inserting, you only need the name — the database generates
     * the id and timestamps automatically.
     */
    public Topic(String name) {
        this.name = name;
    }

    // ============================================================
    // TODO 2: Create the full constructor (+20 XP)
    // ============================================================
    // Create a constructor that takes (int id, String name,
    //   Timestamp createdAt, Timestamp updatedAt)
    // Inside the constructor:
    //   - Set this.id = id
    //   - Set this.name = name
    //   - Set this.createdAt = createdAt
    //   - Set this.updatedAt = updatedAt
    //
    // Why do you need this constructor?
    //   When READING from the database, you already have the id,
    //   timestamps, etc. So you pass them all in to recreate the
    //   full Topic object from the database row.
    //
    // Hint:
    //   public Topic(int id, String name, Timestamp createdAt, Timestamp updatedAt) {
    //       this.id = id;
    //       this.name = name;
    //       this.createdAt = createdAt;
    //       this.updatedAt = updatedAt;
    //   }
    // ============================================================



    // ============================================================
    // TODO 3: Create getters and setters (+30 XP)
    // ============================================================
    // Fill in each method body below:
    //   - getId()        → returns id
    //   - getName()      → returns name
    //   - getCreatedAt() → returns createdAt
    //   - getUpdatedAt() → returns updatedAt
    //   - setName(String name) → sets name
    //
    // Hint: return this.id;
    // ============================================================
    public int getId() {
        // Write your code here
        return 0; // ← Replace this
    }

    public String getName() {
        // Write your code here
        return null; // ← Replace this
    }

    public Timestamp getCreatedAt() {
        // Write your code here
        return null; // ← Replace this
    }

    public Timestamp getUpdatedAt() {
        // Write your code here
        return null; // ← Replace this
    }

    public void setName(String name) {
        // Write your code here
    }

    // ============================================================
    // TODO 4: Override toString() (+20 XP — ACHIEVEMENT: Architect!)
    // ============================================================
    // Return a readable string like:
    //   "[1] Java Basics (Created: 2026-02-24 10:30:00.0)"
    //
    // Why override toString()?
    //   So when you print a Topic object, it shows useful info
    //   instead of something like "Topic@4a574795".
    //
    // Hint: return "[" + id + "] " + name + " (Created: " + createdAt + ")";
    // ============================================================


}
