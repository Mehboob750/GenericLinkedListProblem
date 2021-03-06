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
    public Node remove(Object data) {
        Node firstPosition = head;
        Node secondPosition = firstPosition.next;
        if (firstPosition.data == data) {
            head = secondPosition;
        } else {
            while (secondPosition.data != data) {
                secondPosition = secondPosition.next;
                firstPosition = firstPosition.next;
            }
            firstPosition.next = secondPosition.next;
        }
        return head;
    }

    public boolean search(T data) {
        Node firstPosition = head;
        if (head.data == data) {
            return true;
        } else {
            while (firstPosition!= null) {
                if (firstPosition.data==data)
                    return true;
                firstPosition = firstPosition.next;
            }
        }
        return false;
    }

    public void append(T... data) {
       for (T element:data){
           insert(element);
       }
    }

    public int index(T data) {
        int indexValue = 1;
       if(!isEmpty()) {
           Node firstPosition = head;
           if (head.data == data) {
               return indexValue;
           } else {
               while (firstPosition != null) {
                   if (firstPosition.data == data)
                       return indexValue;
                   indexValue++;
                   firstPosition = firstPosition.next;
               }
           }
       }
       else
           System.out.println("List should not be empty");
       return 0;
   }

    public int insertAtIndex(int position ,T data) {
        int index=1;
        Node firstNode= head;
        Node newNode=new Node(data);
        if(position-1==listSize()){
            append(data);
            return position;
        }else if(position == 1){
            head=newNode;
            head.next=firstNode;
            return position;
        } else{
            while(firstNode!=null){
                if(position-1==index){
                    newNode.next=firstNode.next;
                    firstNode.next=newNode;
                    return position;
                }
                firstNode=firstNode.next;
                index++;
            }
        }
        return  0;
    }

    public Object pop() {
       Node lastNode=head;
       while(lastNode.next!=null){
           lastNode=lastNode.next;
       }
       Object data= lastNode.data;
       remove(data);
       return  data;
    }

    public Object popAtPosition(int position) {
       if(position<=listSize()) {
           int index = 1;
           Node firstPosition = head;
           if (position == index) {
               remove(head.data);
               return head.data;
           } else {
               while (position != index) {
                   firstPosition = firstPosition.next;
                   index++;
               }
               remove(firstPosition.data);
           }
           Object data = firstPosition.data;
           return data;
       }else
           System.out.println("Position Should not be greater than list size");
       return 0;
    }

    public Object getElement(int position) {
        Object element = null;
        if(position<listSize()){
            if(position==1){
                element=head.data;
            }else{
                int index=1;
                Node elementAtIndex=head;
                while(elementAtIndex.data!=null){
                    if(index==position){
                        element=(T)elementAtIndex.data;
                        break;
                    }
                    index++;
                    elementAtIndex=elementAtIndex.next;
                }
            }
        }
        return element;
    }

    public static void printList(LinkedList linkedList) {
        Node currentData = linkedList.head;
        while (currentData != null) {
            System.out.print(currentData.data + " ");
            currentData = currentData.next;
        }
    }
}
