package Recursive;

import List.LinkedList.ListNode;


public class Recursive {

    int pay(int[] bills, int money, int n) {
        int count=0,t;
        if(n==1) {
            if (money % bills[0] == 0) {
                  System.out.println(bills[n-1]+"x"+money/bills[n-1]+" = "+100);
                return 1;
            } else {
                return 0;
            }
        }
            t=money/bills[n-1];
            for(int i=0;i<=t;i++){
                    if(i>0 && 100-money!=0){
                        System.out.print(bills[n]+"x"+(100-money)/bills[n]+" + ");
                   }
                System.out.print(bills[n-1]+"x"+(i)+" + ");
                 count+=pay(bills,money-bills[n-1]*i,n-1);
            }
        return count;
        }


    //print linked list recursive
    public void printList(ListNode node){
        if(node==null){
            return;
        }

        System.out.print(node.data);
        printList(node.next);
    }

    //reverse
    public void printListReverse(ListNode node){

        if(node==null){
            return;
        }
        printListReverse(node.next);
        System.out.print(node.data);

    }

    //factorial
   public int factorial(int n){
        if(n==1)
            return 1;

        return n*factorial(n-1);
    }
}
