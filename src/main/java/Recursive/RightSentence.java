package Recursive;

public class RightSentence {

    public String solution(String p) {

        String answer=makeRight(p);
      return answer;
    }

    private String makeRight(String s) {

        if(s.equals("")){
            return s;
        }

        String u="",v="";
        int left=0,right=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                u=s.substring(0,i+1);
                v=s.substring(i+1,s.length());
                if(u.length()%2==0) {
                    if(isRight(u)){
                        return u+makeRight(v);
                    }
                    break;
                 }else if(v.length()%2==0){
                    if(isRight(v)){
                        return makeRight(u)+v;
                    }
                    break;
                }
            }
        }


        return "("+makeRight(v)+")"+reverse(u.substring(1,u.length()-1));

    }

    private String reverse(String substring) {
        String result="";
        for(int i=0;i<substring.length();i++){
            if(substring.charAt(i)=='('){
                result+=")";
            }else{
                result+="(";
            }
        }
        return result;
    }


    public boolean isRight(String p){
        String s=p;
        int i=0;
       while (i<s.length()-1){
           if(s.substring(i,i+2).equals("()")){
               s=s.substring(0,i)+s.substring(i+2,s.length());
               i=0;
               continue;
           }
           i++;
       }
        if(s.equals("()") || s.equals(""))
            return true;
        else
            return false;
    }

}
