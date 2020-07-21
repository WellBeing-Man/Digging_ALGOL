package stack;

public class main {
    public static void main(String[] args) {
        StockPrice stockPrice=new StockPrice();
        int[] a={1,2,3,2,3};
        int[] re=stockPrice.solution(a);
        for(int i:re)
        System.out.print(i);
    }
}
