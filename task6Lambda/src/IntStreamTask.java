import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class IntStreamTask {

    public static int[] arr=new int[]{1,2,3,43,1,24,42,13,31,31};
    static final int numberToMultiply=5;

    public static void main(String[] args) {
//        IntStream intStream=getIntStream();
        System.out.println("Average value");
        OptionalDouble optionalDouble=getAverage(getIntStream());
        System.out.println(optionalDouble);
        System.out.println("Min elem");
        double min=findMin(getIntStream());
        System.out.println(min);
        System.out.println("Elements that equals 0");
        double result=findEqualsZero(getIntStream());
        System.out.println(result);
        System.out.println("Elements higher that 0");
        double res=findHigherZero(getIntStream());
        System.out.println(res);
        System.out.println("Multiplying all arrays values");
        Arrays.stream(arr).forEach(value -> System.out.print((value *numberToMultiply)+" " ));

    }

    public static OptionalDouble getAverage(IntStream intStream){
        return intStream.average();
    }
    public static double findHigherZero(IntStream intStream){
        return intStream.filter(p->p>0).count();
    }
    public static double findEqualsZero(IntStream intStream){
        return intStream.filter(p->p==0).count();
    }
    public static double findMin(IntStream intStream){
        return intStream.min().getAsInt();
    }
    public static IntStream getIntStream(){
        return Arrays.stream(arr.clone());
    }
}
