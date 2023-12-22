package org.codeforall.ooptimus;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(" Todo list:");
        TodoList todoList = new TodoList();
        todoList.add(TodoList.ImportanceLevel.LOW, 2, "Wesley");
        todoList.add(TodoList.ImportanceLevel.HIGH, 3, "Zé Cabra");
        todoList.add(TodoList.ImportanceLevel.MEDIUM, 1, "Gil");
        todoList.add(TodoList.ImportanceLevel.HIGH, 2, "Zé das Lacraia");

        while (!todoList.isEmpty()) {
            System.out.println(todoList.remove());


        }
    }
}