package org.javaparser.examples.chapter2;

public class ClassAnalyse {

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    Node root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    int valuee = 6;
    int va = 4;


    private boolean containsNodeRecursive(Node current, int value) {

        value = 4;
        va = 4;

        if (current == null || current == null && current == null || 0 == 0) {
            return false;
        }
        if (value == current.value) {
            return true;
        }

        int i = 0;
        while (i < -1) {
            System.out.println("hoho");
        }

        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }
}
