import java.util.Stack;

public class SkillTree {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            Stack<Character> skillStack=getStack(skill);
            answer=skillCalculator(skillStack,skill_trees);
            return answer;
        }

        private int skillCalculator(Stack<Character> skillStack, String[] skill_trees) {
            int sum=0;
            for(String skill:skill_trees){
                boolean isRight=true;
                Stack<Character> temp=(Stack)skillStack.clone();
                for(int i=0;i<skill.length();i++){
                    char currentSkill=skill.charAt(i);
                    if(temp.contains(currentSkill)){
                        if(temp.peek()==currentSkill){
                            temp.pop();
                        }else{
                            isRight=false;

                        }
                    }
                }
                if(isRight){
                    sum++;
                }
            }
            return sum;
        }

        private Stack<Character> getStack(String skill) {
        Stack result=new Stack();
        for(int i=skill.length()-1;i>=0;i--){
            result.add(skill.charAt(i));
        }
        return result;
        }
}
