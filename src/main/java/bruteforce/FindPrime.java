package bruteforce;


import java.util.ArrayList;


//programmers problem
public class FindPrime {

    public int solution(String numbers) {
        ArrayList<String> primeList=new ArrayList<>();
        ArrayList index=new ArrayList();
        findPrime(numbers, "0",index,primeList);
        return primeList.size();
    }

    private void findPrime(String numbers,String nowString,ArrayList<Integer> index, ArrayList<String> primeList) {

            if(isPrime(nowString) && !primeList.contains(nowString)){
                primeList.add(nowString);
            }
            if(index.size()==numbers.length()){
                return;
            }

            for(int i=0;i<numbers.length();i++){
                ArrayList<Integer> list=(ArrayList)index.clone();
                if(!list.contains(i)){
                    String newString=String.valueOf(Integer.parseInt(nowString+numbers.charAt(i)));
                    list.add(i);
                    findPrime(numbers,newString,list,primeList);
                }


            }
    }

    private boolean isPrime(String nowString) {
        int number = Integer.parseInt(nowString);
        if (number != 0 && number!=1) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
