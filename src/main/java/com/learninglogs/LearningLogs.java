package com.learninglogs;

import com.learninglogs.entity.Topic;
import com.learninglogs.dao.TopicDao;
import com.learninglogs.dao.TopicDaoImpl;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ╔══════════════════════════════════════════════════════╗
 * ║     Learning Logs Terminal — Main Menu                ║
 * ║                                                      ║
 * ║   This file is PROVIDED for you. No changes needed!  ║
 * ║   Study how it works — it calls YOUR code.           ║
 * ╚══════════════════════════════════════════════════════╝
 */
public class LearningLogs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TopicDao topicDao = new TopicDaoImpl();

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     Welcome to Learning Logs Terminal    ║");
        System.out.println("║     Now with Database Storage!           ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();

        boolean running = true;

        while (running) {
            System.out.println("┌──────────────────────────────┐");
            System.out.println("│         MAIN MENU            │");
            System.out.println("├──────────────────────────────┤");
            System.out.println("│  1. Add a new Topic          │");
            System.out.println("│  2. View all Topics          │");
            System.out.println("│  3. Exit                     │");
            System.out.println("└──────────────────────────────┘");
            System.out.print("Choose an option (1-3): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter topic name: ");
                    String name = scanner.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("⚠ Topic name cannot be empty!\n");
                    } else {
                        Topic topic = new Topic(name);
                        boolean success = topicDao.insertTopic(topic);
                        if (success) {
                            System.out.println("✓ Topic added: " + name);
                        } else {
                            System.out.println("⚠ Failed to add topic.\n");
                        }
                        System.out.println();
                    }
                }
                case "2" -> {
                    ArrayList<Topic> topics = topicDao.fetchAllTopics();

                    if (topics == null || topics.isEmpty()) {
                        System.out.println("No topics yet. Add your first topic!\n");
                    } else {
                        System.out.println("\n── Your Topics ──────────────────");
                        for (Topic topic : topics) {
                            System.out.println("  " + topic);
                        }
                        System.out.println("─────────────────────────────────");
                        System.out.println("  Total: " + topics.size() + " topic(s)\n");
                    }
                }
                case "3" -> {
                    running = false;
                    System.out.println("\nHappy Learning! See you next time.\n");
                }
                default -> System.out.println("Invalid option. Please choose 1-3.\n");
            }
        }

        scanner.close();
    }
}
