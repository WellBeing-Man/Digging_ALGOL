package hash;


import java.util.Stack;

public class LastWord {
    public int[] solution(int n, String[] words) {
        int[] answer = play(n,words);

        return answer;
    }

    private int[] play(int n, String[] words) {
        int[] result=new int[2];
        Stack<String> playedWords=new Stack<>();
        playedWords.add(words[0]);
        int player=0;
        String lastWord=words[0];
        for(int i=1;i<words.length;i++){
            if(playedWords.contains(words[i]) || lastWord.charAt(lastWord.length()-1)!=words[i].charAt(0)){
                result[0]=(i+1)%n==0? n : (i)%n;
                result[1]=(int)Math.ceil((double)(i+1)/(double)n);
                break;
            }
            playedWords.add(words[i]);
            lastWord=words[i];
        }

    return result;
    }
}
