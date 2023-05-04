import java.util.Scanner;

public class DepositCalculator {
    double CalculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        int months = 12;
        double pay = amount * Math.pow((1 + yearRate / months), months * depositPeriod);

        return roundVar(pay, 2);
    }

    double CalculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount + amount * yearRate * depositPeriod;

        return roundVar(pay, 2);
    }

    double roundVar(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }

    void executeProgram() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double returnAmount = 0;

        if (action == 1) {
            returnAmount = CalculateSimplePercent(amount, 0.06, period);}
        else if (action == 2) {
            returnAmount = CalculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + returnAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().executeProgram();
    }

}
