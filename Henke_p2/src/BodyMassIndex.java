public class BodyMassIndex {
    double height;
    double weight;

    public BodyMassIndex(double h, double w) {
        height = h;
        weight = w;
    }

    public static double calculate(BodyMassIndex bmi) {
        return (double)Math.round((703.0 * bmi.weight / Math.pow(bmi.height, 2.0)) * 10) / 10;
    }

    public static String category(BodyMassIndex bmi) {
        double a = calculate(bmi);
        if(a < 18.5) {
            return "Underweight";
        }
        else if(a >= 18.5 && a < 25.0) {
            return "Normal weight";
        }
        else if(a >= 25.0 && a < 30) {
            return "Overweight";
        }
        else {
            return "Obesity";
        }
    }
}
