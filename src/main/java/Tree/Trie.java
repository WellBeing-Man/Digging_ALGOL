package Tree;

public class Trie {
    private TrieNode rootNode;

    public Trie(TrieNode rootNode) {
        this.rootNode = rootNode;
    }

    void insert(String s) {
        TrieNode thisNode = this.rootNode;

        for (int i = 0; i < s.length(); i++) {
            thisNode = (TrieNode) rootNode.getChildNode().computeIfAbsent(s.charAt(i), c -> new TrieNode());
        }
        thisNode.setLastChar(true);
    }

    boolean contain(String s) {
        TrieNode thisNode = this.rootNode;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            TrieNode node = (TrieNode) thisNode.getChildNode().get(c);

            if (node == null) {
                return false;
            }

            thisNode = node;
        }
        return thisNode.isLastChar();

    }

    void delete(String s) {
        delete(this.rootNode, s, 0);
    }

    private void delete(TrieNode thisNode, String s, int i) {
        char c = s.charAt(i);

        if (!thisNode.getChildNode().containsKey(c))
            throw new Error("There is no " + c + " in this Trie");

        TrieNode childNode= (TrieNode) thisNode.getChildNode().get(c);
        i++;

        if(i==s.length()){
            if(!childNode.isLastChar()) throw new Error("There is no " + c + " in this Trie");

            childNode.setLastChar(true);

            if(childNode.getChildNode().isEmpty())
                thisNode.getChildNode().remove(c);

        }else{
            delete(childNode,s,i);

            if(!childNode.isLastChar() && childNode.getChildNode().isEmpty())
                    thisNode.getChildNode().remove(c);
        }
    }

        boolean isEmpty(){
        return this.rootNode.getChildNode().isEmpty();
        }
}
