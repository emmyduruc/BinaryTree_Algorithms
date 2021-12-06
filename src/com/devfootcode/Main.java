package com.devfootcode;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        SortedBinaryTree<Node> ageTree = new SortedBinaryTree<Node>();

        int min = 20;
        int max = 70;
        int count = 1;

        for (int i = 0; i < 100; i++) {
            int ages = (int) (Math.random() * (max - min)) + min;
            Employee employeeAges = new Employee(ages);
            ageTree.insert(employeeAges);
            System.out.println("the employees age" + employeeAges.getKey());
        }

        System.out.println("iteration counts for the first 50 elements");
        Iterator<Node> tree = ageTree.iterator();
        while (tree.hasNext()) {
            while (count <= 50) {
                System.out.print(tree.next().getKey() + ",");
                count++;
            }
            tree = ageTree.iterator();
            count = 1;
            break;
        }

        System.out.println();
        System.out.println("iteration counts for the first 20 elements ");
        while (tree.hasNext()) {
            int secondCounter = 1;
            while (secondCounter <= 20) {
                System.out.print(tree.next().getKey() + ",");
                secondCounter++;
            }
            break;
        }

        System.out.println();
        System.out.println("iteration counts for the first 50 elements");
        while (tree.hasNext()) {
            count = 80;
            while (count < 100) {
                System.out.print(tree.next().getKey() + ",");
                count++;
            }
            break;
        }
        System.out.println();

    }
}
