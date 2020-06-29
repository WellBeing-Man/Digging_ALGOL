package Hash;


import java.util.Arrays;
import java.util.HashMap;

public class OpenChat {
    HashMap<String, String> uid = new HashMap<>();
    public String[] solution(String[] record) {

        for (String sentence:record) {
            String[] temp = sentence.split(" ");
            if (temp.length == 3) {
                uid.put(temp[1],temp[2]);
            }
        }

        String[] answer=new String[record.length];
        int i=0;
        for(String string:record){
            String[] temp= string.split(" ");
            if(temp[0].contains("Enter")){
                answer[i++]=uid.get(temp[1])+"has entered.";
            }else if(temp[0].contains("Leave")){
                answer[i++]=uid.get(temp[1])+"has entered.";
            }
        }
        String[] result= Arrays.copyOf(answer,i);
        return result;
    }

}
