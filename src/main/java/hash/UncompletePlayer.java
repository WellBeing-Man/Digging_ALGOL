package hash;

public class UncompletePlayer {

    private class HashSet<String> extends java.util.HashSet{
        @Override
        public boolean add(Object o) {
            if(contains(o)){
                add(o+"-");
            }
            return super.add(o);
        }
    }

    public String solution(String[] participant, String[] completion) {


        HashSet<String> nicePlayer=new HashSet<>();
        HashSet<String> allPlayer=new HashSet<>();
        String answer="";
        for(String c:completion){
                nicePlayer.add(c);
        }
        for(String p:participant){
                allPlayer.add(p);
        }
        allPlayer.removeAll(nicePlayer);
        String before=((String)allPlayer.toArray()[0]);

        allPlayer.removeAll(nicePlayer);
        return ((String)allPlayer.toArray()[0]).replaceAll("[-]","");
    }

    public static void main(String[] args) {
        String[] parti={"mislav","mislav","mislav","mislav" };
        String[] compl={"mislav", "mislav","mislav"};

       System.out.print(new UncompletePlayer().solution(parti,compl));
    }
}