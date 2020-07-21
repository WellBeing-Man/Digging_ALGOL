package greedy;

import java.util.*;

//programmers done
public class JoyStick {
    public int solution(String name) {
        int answer=0;
        int position=0;
        LinkedList<Character> nameList=new LinkedList<>();
        for(Character c:name.toCharArray()){
            nameList.add(c);
        }
        int direction=0;

        while (true){
            int letter;
            if(direction==-1) {
                position = (position + direction < 0) ? nameList.size() + direction : position + direction;
            }else if(direction==1){
                position=(position+direction==nameList.size()) ? 0 : position+direction;
            }
            direction=getDirection(nameList,position);
            letter=nameList.get(position);
            answer+= ((letter - 'A' < 13)  ? letter-'A' : 'Z'-letter+1);
            nameList.set(position,'A');

            int aNumber= (int) nameList.stream().filter(it -> it.equals('A')).count();
            if(aNumber==nameList.size()){
                break;
            }else
            {
                answer++;
            }
        }
        return answer;
    }

    private int getDirection(LinkedList<Character> name,int position) {
        int reverse=position;
        int inverse=position;

        while (true){
            inverse= inverse==name.size()-1 ? 0: inverse+1;
            reverse= reverse==0 ? name.size()-1: reverse-1;
            if(name.get(inverse)!='A'){
                return 1;
            }else if(name.get(reverse) != 'A'){
                return -1;
            }

        }

    }

    public static void main(String[] args) {
        new JoyStick().solution("ABAAAAABA");
    }


}
