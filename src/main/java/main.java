public class main {
    public static void main(String[] args) {
        int M=Integer.MAX_VALUE;
        final int[][] map={
                {0,3,5,M,M,M},
                {M,0,2,6,M,M},
                {M,1,0,4,6,M},
                {M,M,M,0,2,3},
                {3,M,M,M,0,6},
                {M,M,M,M,M,0}
        };
        Dijkstra dijkstra=new Dijkstra(map.length);
        dijkstra.setMap(map);
        dijkstra.shortestPath(1,5);

    }
}
