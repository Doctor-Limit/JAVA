package Work.homework8;

/**
 * ********概述：
 */

interface ComputerAverage {
    double averageScore(double[] arr);
}

class School implements ComputerAverage {

    @Override
    public double averageScore(double[] arr) {
        double score = 0;
        for (int i = 0; i < arr.length; i++) {
            score += arr[i];
        }
        return (score / arr.length);
    }
}

class Swimming implements ComputerAverage {

    @Override
    public double averageScore(double[] arr) {
        double max = 0 , min = 0, score = 0;
        for (int i = 0; i < arr.length; i++) {
            score += arr[i];
            if(min > arr[i]) {
                min = arr[i];
            }
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        return (score-max-min) / (arr.length-2);
    }
}

public class homework {
    public static void main(String[] args) {
        double[] arr = new double[]{2,2,9,4,5,7,7,6,9,11};
        Swimming swimming = new Swimming();
        School school = new School();
        System.out.println("学校成绩:"+school.averageScore(arr));
        System.out.println("游泳成绩:"+swimming.averageScore(arr));
    }
}
