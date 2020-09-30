import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static Scanner sc = new Scanner(System.in);

    public static Scanner getScanner() {
        return sc;
    }

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static double getUserHeight() {
        Scanner sc = getScanner();
        System.out.println("Enter height in inches (with one decimal place): ");
        double height = sc.nextDouble();
        sc.nextLine();
        if(height < 0.0) {
            System.out.println("Invalid entry.");
            System.exit(1);
        }
        return height;
    }

    public static double getUserWeight() {
        Scanner sc = getScanner();
        System.out.println("Enter weight in pounds (with one decimal place): ");
        double weight = sc.nextDouble();
        sc.nextLine();
        if(weight < 0.0) {
            System.out.println("Invalid entry.");
            System.exit(0);
        }
        return weight;
    }

    public static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.println("BMI: " + BodyMassIndex.calculate(bmi));
        System.out.println("Category: " + BodyMassIndex.category(bmi));
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        double sum = 0.0;
        for(int i = 0; i < bmiData.size(); i++) {
            sum += BodyMassIndex.calculate(bmiData.get(i));
        }
        double average = (double)Math.round((sum / bmiData.size()) * 10) / 10;
        System.out.println("Average: " + average);
    }

    public static boolean moreInput() {
        Scanner sc = getScanner();
        System.out.println("More input? (Y/N): ");
        char answer = sc.next().charAt(0);
        if(answer == 'Y') {
            return true;
        }
        sc.close();
        return false;
    }
}
