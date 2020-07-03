package Heap;


import java.util.ArrayList;


//Heap pratice
public class MaxHeap {
    ArrayList<Integer> heap;
    public MaxHeap() {
        this.heap = new ArrayList();
        heap.add(0);
    }

    public void insert(int val){
        heap.add(val);
        int position=heap.size()-1;
        while (position>1 &&heap.get(position)>heap.get(position/2)){
            int temp=heap.get(position/2);
            heap.set(position/2,heap.get(position));
            heap.set(position,temp);
            position/=2;
        }
    }

    public void delete(){
        int temp=heap.get(heap.size()-1);
        heap.set(1,temp);
        heap.remove(heap.size()-1);
        int position=1;
        while (position*2<=heap.size()-1){
            if(heap.get((position*2)+1)<heap.get(position*2)){
                int temp2=heap.get(position);
                heap.set(position,heap.get(position*2));
                heap.set(position*2,temp2);
                position*=2;
            }else if(heap.get(position*2)<heap.get((position*2)+1)){
                int temp2=heap.get(position);
                heap.set(position,heap.get((position*2)+1));
                heap.set(position*2+1,temp2);
                position=position*2 +1 ;
        }
    }
    }

    public void printHeap(){
        int line=1;
       for(int i=1;i<heap.size();i++){
           if(line%i==0){
               System.out.println("  "+heap.get(i)+"  ");
               line*=2+1 ;
           }else{
               System.out.print(heap.get(i)+" ");
           }
       }
    }

}