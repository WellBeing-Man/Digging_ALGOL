package Stack;

//Written by LDG
public class mStackCalculator{

    private String f;
    private mLinkedStack<Integer> mStack;               //using LinkedStack

    public mStackCalculator(String s) {
        mStack=new mLinkedStack<Integer>(s.length());
        this.f = s;
    }


    public void calculating(){
        int temp;
        for(int i=0;i<f.length();i++){
            if(f.charAt(i)=='+' || f.charAt(i)=='-'||f.charAt(i)=='*'||f.charAt(i)=='/'){       //expression Check if number or not
                switch (f.charAt(i)){
                    case '+':
                        int back=mStack.pop();
                        int front=mStack.pop();
                        temp=front+back;
                        mStack.push(temp);
                        break;
                    case '-':
                        back=mStack.pop();
                        front=mStack.pop();
                        temp=front-back;
                        mStack.push(temp);
                        break;
                    case '/':
                        back=mStack.pop();
                        front=mStack.pop();
                        temp=front/back;
                        mStack.push(temp);
                        break;
                    case '*':
                        back=mStack.pop();
                        front=mStack.pop();
                        temp=front*back;
                        mStack.push(temp);
                        break;

                    default:
                }
            }else{

                int number=Integer.parseInt(f.substring(i,i+1));
                mStack.push(number);
            }

        }
    }

    public int getResult(){
        return mStack.peek();
    }

}
