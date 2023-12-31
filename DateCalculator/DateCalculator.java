import java.time.LocalDate;
import java.time.Period;

public class DateCalculator {
  public static void main(String[] args) {
    LocalDate start = LocalDate.of(2022, 1, 1);
    LocalDate end = LocalDate.of(2022, 1, 31);
    Period period = Period.between(start, end);
  //  int days = period.getDays();
    //System.out.println(days);  // Outputs: 30

	//Period period = Period.between(start, end);
	int years = period.getYears();
	int months = period.getMonths();
	int days = period.getDays();

	System.out.println(years+" "+months+" "+days);
  }
}