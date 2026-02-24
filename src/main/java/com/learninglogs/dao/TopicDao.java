package com.learninglogs.dao;

import com.learninglogs.entity.Topic;

import java.util.ArrayList;

/**
 * ╔══════════════════════════════════════════════════════╗
 * ║       Topic DAO Interface                            ║
 * ║                                                      ║
 * ║   This file is PROVIDED for you. No changes needed!  ║
 * ║   Study it — then implement it in TopicDaoImpl.      ║
 * ╚══════════════════════════════════════════════════════╝
 *
 * What is a DAO?
 *   DAO = Data Access Object
 *   It's a design pattern that separates database logic from business logic.
 *
 * Why use an interface?
 *   - The interface defines WHAT operations are available (the contract)
 *   - The implementation (TopicDaoImpl) defines HOW they work
 *   - This makes your code flexible and testable
 *
 * Think of it like a menu at a restaurant:
 *   - The menu (interface) lists what you can order
 *   - The kitchen (implementation) decides how to make it
 */
public interface TopicDao {

    /**
     * Insert a new topic into the database.
     *
     * @param topic The Topic object to insert
     * @return true if inserted successfully, false otherwise
     */
    boolean insertTopic(Topic topic);

    /**
     * Fetch all topics from the database.
     *
     * @return ArrayList of all Topic objects
     */
    ArrayList<Topic> fetchAllTopics();
}
