import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class PythagoreanTriplet {
    private int a;
    private int b;
    private int c;
    private int maxFactor = 0;
    private int sum = -1;
    public PythagoreanTriplet(int a, int b, int c) {
        this.a = a < b? a : b;
        this.b = a < b? b : a;
        this.c = c;
    }
    public PythagoreanTriplet() {
    }
    static PythagoreanTriplet makeTripletsList() {
        return new PythagoreanTriplet();
    }
    @Override
    public boolean equals(Object obj) {
        PythagoreanTriplet other = (PythagoreanTriplet)obj;
        return obj != null && this.a == other.a && this.b == other.b && this.c == other.c;
    }
    public PythagoreanTriplet withFactorsLessThanOrEqualTo(final int maxFactor) {
        this.maxFactor = maxFactor;
        return this;
    }
    public PythagoreanTriplet thatSumTo(final int sum) {
        this.sum = sum;
        return this;
    }
    public List<PythagoreanTriplet> build() {

        List<PythagoreanTriplet> triplets = new ArrayList<>();

        for (int a = 1; a < maxFactor; a++)
            for (int b = a + 1; b < maxFactor; b++) {
                double sqrt = Math.sqrt(a * a + b * b);
                int c = (int) Math.floor(sqrt);
                if (sqrt == c && a + b + c == sum)
                    triplets.add(new PythagoreanTriplet(a, b, c));
            }
        return triplets;
    }
}