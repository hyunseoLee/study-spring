import java.util.Collection;
import java.util.*;

public class UniqueNumbers {
    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
       //throw new UnsupportedOperationException("Waiting to be implemented.");
       int n= numbers.size();
       int[] check= new int[n+1];

       Collection<Integer> values= new ArrayList<>(); 
       for(int tmp: numbers){
            check[tmp]++;
       }
       for(int i=0;i<n;i++){
           if(check[i]==1){
               values.add(i);
           }
       }

       return values;
    }

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
        for (int number : findUniqueNumbers(numbers))
            System.out.println(number);
    }
}


/*
import java.util.Collection;
import java.util.Arrays;

public class UniqueNumbers {
    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
        for (int number : findUniqueNumbers(numbers))
            System.out.println(number);
    }
}
*/