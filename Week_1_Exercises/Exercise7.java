public class Exercise7 {

    public static double Exercise7(double currentValue, double growthRate, int periods) {
        if (periods == 0) {
            return currentValue; 
        }
        return Exercise7(currentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double currentValue = 1000.0; 
        double growthRate = 0.05; 
        int periods = 10; 

        double futureValueRecursive = Exercise7(currentValue, growthRate, periods);
        System.out.println("Future Value (Recursive): " + futureValueRecursive);
    }
}
