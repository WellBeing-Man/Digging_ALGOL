import java.math.BigInteger;

public class SquareCut {
    public long solution(int w,int h) {
        if(w==0 || h==0){
            return 0;
        }

        BigInteger blank=new BigInteger(Long.toString(gcd(w,h)));

        BigInteger x=new BigInteger(Long.toString(w));
        BigInteger y=new BigInteger(Long.toString(h));
        BigInteger answer= x.multiply(y).subtract(x.add(y).subtract(blank));
        return answer.longValue();
    }

    private long gcd(double w, double h) {
            double x=w;
            double y=h;
            double r;
            while (y!=0){
                r=x%y;
                x=y;
                y=r;
            }

            return (long)x;
    }

}
