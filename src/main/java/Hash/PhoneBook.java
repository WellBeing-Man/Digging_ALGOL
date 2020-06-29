package Hash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class PhoneBook {

    private class TrieNode{
        HashMap<Character,TrieNode> child;

        public boolean isIsleaf() {
            return isleaf;
        }

        public void setIsleaf(boolean isleaf) {
            this.isleaf = isleaf;
        }

        boolean isleaf;

        public TrieNode() {
            child=new HashMap<>();
            isleaf=false;
        }
    }
    public boolean solution(String[] phone_book) {
        TrieNode root=new TrieNode();


        for(int j=0;j<phone_book.length;j++){
            String p=phone_book[j];
            TrieNode node=root;
            for(int i=0;i<p.length();i++){
                char letter=p.charAt(i);
                    node=node.child.computeIfAbsent(letter,c->new TrieNode());
                    if(node.isIsleaf()){
                        return false;
                    }
                }
            if(!node.child.isEmpty() || node.isIsleaf()){
                return false;
            }
            node.setIsleaf(true);
        }

        return true;
    }




    public static void main(String[] args) {
        String[] pb={"119","97674223","1195524421"};
       new PhoneBook().solution(pb);

    }
}
