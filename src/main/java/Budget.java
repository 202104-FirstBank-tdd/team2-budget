import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

public class Budget {
    String yearMonth;
    Integer amount;

    public Budget(String yearMonth, Integer amount) {
        this.yearMonth = yearMonth;
        this.amount = amount;
    }

    public int days() {
        YearMonth myYearMonth = getMonth();
        return myYearMonth.lengthOfMonth();
    }

    public LocalDate lastDay() {
        return getMonth().atEndOfMonth();
    }

    public LocalDate firstDay() {
        return getMonth().atDay(1);
    }

    double dailyAmount() {
        return (double) amount / days();
    }

    private YearMonth getMonth() {
        return YearMonth.parse(yearMonth, DateTimeFormatter.ofPattern("yyyyMM"));
    }

    Period createPeriod() {
        return new Period(firstDay(), lastDay());
    }

    double overlappingAmount(Period period) {
        return dailyAmount() * period.getOverlappingDays(createPeriod());
    }
}
