package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lyk on 2019-11-12.
 * Package name: Leetcode
 * Porject name: LearnScala
 */
public class QueueReconstructionbyHeight1 {
    public int[][] reconstructQueue(int[][] people) {
        if(people.length == 0) return people;

        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        for(int i = 0; i < people.length; i++){
            System.out.println(people[i][0] + ", " + people[i][1]);
        }
        List<int[]> result = new ArrayList();
        for(int[] person : people) {
            result.add(person[1], person);
        }
        result.forEach(n -> System.out.println(n[0] + " , " + n[1]));
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{
                {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
        };
        QueueReconstructionbyHeight1 qrh = new QueueReconstructionbyHeight1();
        qrh.reconstructQueue(people);
    }
}
