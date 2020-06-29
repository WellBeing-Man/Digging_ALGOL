import java.util.*;

public class TempClass2 {
        private class Song {
            int number;
            String genre;
            int play;

            public Song(int number, String genre, int play) {
                this.number = number;
                this.genre = genre;
                this.play = play;
            }

            public int getNumber() {
                return number;
            }

            public String getGenre() {
                return genre;
            }

            public int getPlay() {
                return play;
            }
        }

        public int[] solution(String[] genres, int[] plays) {
            ArrayList<Song> songlist= new ArrayList<>();
            HashMap<String,Integer> chart=new HashMap<>();
            Queue<String> genreRank=new ArrayDeque<>();
            ArrayList<Integer> answer=new ArrayList();

            for(int i=0;i<genres.length;i++)
            {
                songlist.add(new Song(i,genres[i],plays[i]));

                if(chart.containsKey(genres[i])){
                    int newValue=chart.get(genres[i])+plays[i];
                    chart.replace(genres[i],newValue);
                }else{
                    chart.put(genres[i],plays[i]);
                }
            }

            //making sorted String array
            while (!chart.isEmpty()) {
                int most = 0;
                String mostPlayed = "";
                for (String s : chart.keySet()) {
                    if (chart.get(s) > most) {
                        most = chart.get(s);
                        mostPlayed = s;
                    }
                }
                genreRank.add(mostPlayed);
                genreRank.add(mostPlayed);
                chart.remove(mostPlayed);
            }


            Collections.sort(songlist, new Comparator<Song>() {

                @Override
                public int compare(Song o1, Song o2) {
                        if (o1.getPlay() < o2.getPlay()) {
                            return 1;
                        } else if(o1.getPlay()==o2.getPlay()){
                            if(o1.getNumber()>o2.getNumber()){
                                return 1;
                            }
                        }
                    return -1;
                }
            });

            while (!genreRank.isEmpty()){
                String g=genreRank.peek();
                for(int i=0;i<songlist.size();){
                    if(songlist.get(i).getGenre().equals(g)){
                        answer.add(songlist.get(i).getNumber());
                        songlist.remove(i);
                        genreRank.poll();
                        g=genreRank.peek();
                        i=0;
                    }else{
                        i++;
                    }
                }
                genreRank.poll();
            }

            int[] result=new int[answer.size()];
            for(int i=0;i<answer.size();i++){
                result[i]=answer.get(i);
            }


            return result;
        }


    public static void main(String[] args) {
        String[] g={"A","B","A","A","B"};
        int[] p={500, 600, 150, 800, 2500};
        new TempClass2().solution(g,p);

    }
}
