package com.devfootcode;

import java.util.Iterator;

public class SortedBinaryTree<T> implements Iterable<Node> {
    private Node root;

    public SortedBinaryTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void insert(Node key) {
        if (root == null) {
            root = key;
        } else {
            insert(getRoot(), key, null);
        }
    }

    public Node find(int data) {
        Node current = getRoot();
        System.out.println(current);
        Node target = null;
        target.setKey(data);
        return search(current, target);
    }

    public Node mini(Node key) {
        while (key.getLeft() != null) {
            key = key.getLeft();
        }
        return key;
    }

    public Node successor(Node key) {
        Node model;
        if (key.getRight() != null) {
            return mini(key.getRight());
        } else
            model = key.getParent();

        while (model != null && model.getKey() <= key.getKey()) {
            model = model.getParent();
        }
        return model;
    }

    @Override
    public Iterator iterator() {

        return new Iterator<Node>() {
            private Node bookmark = mini(root);

            @Override
            public boolean hasNext() {
                return bookmark != null;
            }

            @Override
            public Node next() {
                Node nextNode = bookmark;
                bookmark = successor(nextNode);
                return nextNode;
            }

        };
    }

    private Node insert(Node root, Node key, Node pre) {
        if (root == null) {
            root = key;
            key.setLeft(null);
            key.setRight(null);
            key.setParent(pre);
        } else {
            if (key.getKey() < root.getKey()) {
                Node left = insert(root.getLeft(), key, root);
                root.setLeft(left);
            } else {
                Node right = insert(root.getRight(), key, root);
                root.setRight(right);
            }
        }
        return root;

    }

    private Node search(Node root, Node key) {
        if (root == null) {
            return null;
        } else if (root == key) {
            return root;
        } else if (root.getKey() > key.getKey()) {
            return search(root.getLeft(), key);
        } else
            return search(root.getRight(), key);

    }

}
