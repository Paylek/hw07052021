package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LambdaTask {

    public static void main(String[] args) {
        String[] string1 = {"мадина"};
        String[] string2 = {"мадина", "паша", "вася"};
        String[] string3 = {"мадина", "паша"};

        ArrayList<String[]> stringArrayList = new ArrayList<>();
        stringArrayList.add(string1);
        stringArrayList.add(string2);
        stringArrayList.add(string3);

        stringArrayList.sort((s1,s2) -> s2.length - s1.length);

        for (String[] e : stringArrayList) {
            System.out.println(Arrays.toString(e));
        }

        stringArrayList.sort(Comparator.comparingInt(s -> s.length));

        for (String[] e : stringArrayList) {
            System.out.println(Arrays.toString(e));
        }


    }
}
