package Search;


import List.LinkedList.ListNode;

import java.util.List;

//Written by LDH, Sequential search
public class Sequential<E> {

    ListNode head;           //Acting in LinkedList
    E target;

    public Sequential(ListNode head, E target) {
        this.head = head;
        this.target = target;
    }

    public ListNode searching() {            //just searching
        ListNode current = head;
        while (current.next != null) {
            if (current.data == target) {
                return current;
            } else {
                current = current.next;
            }
        }
        throw new NullPointerException();
    }

    public ListNode moveToFirst() {      //if it matches, it moves to head;
        ListNode current = head.next;
        ListNode previous = head;
        ListNode temp;
        if (head.data == target) {         //it doesn't need to search and switch
            return head;
        }
        while (current.next != null) {
            if (current.data == target) {
                temp = current;
                current.next = head.next;
                previous.next = head;
                head.next = temp.next;
                head = current;
                return current;
            } else {
                previous = current;
                current = current.next;
            }
        }
        throw new NullPointerException();
    }


    public ListNode transpose() {      //if it matches, it moves to previous;
        ListNode current = head.next.next;
        ListNode previous = head.next;
        ListNode preprevious=head;
        ListNode temp;
        if (head.data == target) {         //it doesn't need to search and switch
            return head;
        }else if(previous.data==target){
            head.next=current;
            previous.next=head;
            head=previous;
            return current;
        }
        while (current.next != null) {
            if (current.data == target) {
                preprevious.next=current;
                previous.next=current.next;
                current.next=previous;
                return current;
            } else {

            }
        }
        throw new NullPointerException();
    }
}