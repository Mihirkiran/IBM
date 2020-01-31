import java.util.Scanner;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
public class DateTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Period tenDays = Period.ofDays(10); 
        Period oneYearTwoMonthsThreeDays = Period.of(1, 2, 3);
        System.out.print("Enter the year: ");
        int year = sc.nextInt();
        System.out.print("Enter the month: ");
        int month = sc.nextInt();
        System.out.print("Enter the day: ");
        int day = sc.nextInt();
        System.out.println("\nPeriod inbetween");
        LocalDate old = java.time.LocalDate.now();
        LocalDate newDate = LocalDate.of(year, month, day);
        System.out.println(old);
        System.out.println(newDate);
        Period period = Period.between(old, newDate);
        System.out.print(period.getYears() + " years,");
        System.out.print(period.getMonths() + " months,");
        System.out.print(period.getDays() + " days");

    }
}