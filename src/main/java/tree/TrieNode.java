package tree;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private Map childNode=new HashMap();
    private boolean isLastChar;

    public Map getChildNode() {
        return childNode;
    }

    public boolean isLastChar() {
        return isLastChar;
    }

    public void setLastChar(boolean lastChar) {
        isLastChar = lastChar;
    }
}
