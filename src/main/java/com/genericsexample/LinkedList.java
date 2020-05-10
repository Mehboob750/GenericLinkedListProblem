package com.genericsexample;

public class LinkedList<T> {
    private Node head;

   static class Node<T> {
        T data;
        Node next;
        Node(T data) {
            this.data = data;
            next=null;
        }
    }

    public boolean isEmpty() {
       if(head == null)
           return true;
       return false;
    }

    public int listSize() {
        int length = 0;
        Node current = head;
        while(current != null) {
            length ++;
            current = current.next;
        }
        return length;
    }
    public Node insert(T data) {
        if (data != null && data !=" ") {
            Node newNode = new Node(data);
            newNode.next = null;
            if (head == null) {
                head = newNode;
            } else {
                Node lastPosition = head;
                while (lastPosition.next != null) {
                    lastPosition = lastPosition.next;
                }
                lastPosition.next = newNode;
            }
        } else {
            System.out.println("Please Enter Valid Data");
        }
        return head;
    }

}
