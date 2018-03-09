package com.abel.linkedlist;

/**单项链表的反转
 * Created by fpschina on 16/3/9.
 */
public class SingleLinkedList {
    public static void main(String[] args) {
        int num = 20;
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node root = singleLinkedList.init(num);
        singleLinkedList.myPrint(root);
        System.out.println();
        root = singleLinkedList.reverse(root);
        singleLinkedList.myPrint(root);
    }

    private Node init(int num) {
        Node root = new Node(0);
        Node q = root;
        for (int i = 1; i < num; i++) {
            Node p = new Node(i);
            q.next = p;
            q = p;
        }
        return root;
    }

    private void myPrint(Node root) {
        Node p = root;
        if (p == null) {
            System.out.println("the list is null");
            return;
        }

        while (p != null) {
            System.out.print(p.val);
            System.out.print(" ");
            p = p.next;
        }
    }

    private Node reverse(Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        Node p, q, tmp;
        p = root;
        q = root.next;
        p.next = null;

        while (q.next != null) {
            tmp = q.next;
            q.next = p;
            p = q;
            q = tmp;
        }
        q.next = p;
        return q;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            next = null;
        }
    }


}
