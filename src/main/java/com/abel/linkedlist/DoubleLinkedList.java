package com.abel.linkedlist;

/**双向链表的反转
 * Created by fpschina on 16/3/9.
 */
public class DoubleLinkedList {
    public static void main(String[] args) {
        int num = 20;
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        Node root = doubleLinkedList.init(num);
        doubleLinkedList.myPrint(root);
        root = doubleLinkedList.reverse(root);
        System.out.println();
        doubleLinkedList.myPrint(root);
    }

    private Node init(int num) {
        Node root = new Node(0);
        Node pre = root;
        for (int i = 1; i < num; i++) {
            Node tmp = new Node(i);
            pre.right = tmp;
            tmp.left = pre;
            pre = tmp;
        }
        return root;
    }

    private void myPrint(Node root) {
        Node p = root;
        if (p == null) {
            System.out.println("this Linked list is null");
            return;
        }

        while (p.right != null) {
            System.out.print(p.val);
            System.out.print("==>");
            p = p.right;
        }
        System.out.print(p.val);
    }

    private Node reverse(Node root) {
        if (root == null || root.right == null) {
            return root;
        }
        Node p = root;
        Node q = root.right;
        Node tmp;
        p.right = null;
        while (q.right != null) {
            //注意保存下一个节点的地址.
            tmp = q.right;
            q.right = p;
            p.left = q;
            p = q;
            q = tmp;
        }
        q.left = null;
        q.right = p;
        p.left = q;
        return q;
    }

    static class Node {
        int val;
        Node right;
        Node left;

        Node(int val) {
            this.val = val;
            right = null;
            left = null;
        }
    }

}
