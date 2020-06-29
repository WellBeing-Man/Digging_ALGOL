package BruteForce;

import java.util.ArrayList;

public class BruteForce {

    class Solution {
        private class Poza{
            int[] pattern;

            public Poza(int[] pattern) {
                this.pattern = pattern;
            }

            int checking(int[] problem){
                int score=0;
                for(int i =0;i<problem.length;i++){
                    if(problem[i]==pattern[i%pattern.length]){
                        score++;
                    }
                }

                return score;
            }
        }
        public int[] solution(int[] answers) {

            int[] patternA={1,2,3,4,5};
            int[] patternB={2, 1, 2, 3, 2, 4, 2, 5};
            int[] patternC={3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            ArrayList<Poza> students=new ArrayList<Poza>();
            students.add(new Poza(patternA));
            students.add(new Poza(patternB));
            students.add(new Poza(patternC));

            int[] result=new int[students.size()];

            int high=0;
            for(int i=0;i<result.length;i++){
                result[i]=students.get(i).checking(answers);
                if(high<result[i]){
                    high=result[i];
                }
            }
            ArrayList answerArray=new ArrayList();
            for(int i=0;i<result.length;i++){
                if(result[i]==high){
                    answerArray.add(i+1);
                }
            }

            int[] answer=new int[answerArray.size()];

            for(int i=0;i<answer.length;i++){
                answer[i]=(int)answerArray.get(i);
            }

            return answer;
        }



    }

}
