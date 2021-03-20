package javatime;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class JavaTimeTest {

    @Test
    public void testLocalDateTime() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDate localDate1 = localDate.of(2021, Month.MARCH,10);
        System.out.println(localDate1);
        LocalDate localDate2 = localDate.of(2021, 3,10);
        System.out.println(localDate2);

        LocalDateTime localDateTime1 = LocalDateTime.of(2021,3,5,12,0);
        System.out.println(localDateTime1);

        LocalTime localTime1 = LocalTime.of(16,0);
        System.out.println(localTime1);

        System.out.println(localDateTime1.plusDays(5));
        System.out.println(localTime1.plusHours(11));
        System.out.println(localTime1.isAfter(LocalTime.now()));

        }

    @Test
    public void testConvert() {
        LocalDateTime localDateTime = LocalDateTime.of(2021,1,12,16,00);
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println(localTime);
    }

    @Test
    public void testJavaUtilDate() {
        Date date = new Date();
        LocalDateTime localDateTime =
                LocalDateTime.ofInstant(date.toInstant(),
                        ZoneId.systemDefault());
        System.out.println(localDateTime);

        Date date1 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date1);
    }
    @Test
    public void testChronoUnit() {
        LocalDateTime localDateTime = LocalDateTime.of(2021,1,12,15,00);
        LocalDateTime localDateTime2 = LocalDateTime.of(2021,1,15,10,00);

        System.out.println(ChronoUnit.DAYS.between(localDateTime, localDateTime2));
        System.out.println(ChronoUnit.HOURS.between(localDateTime, localDateTime2));
    }

    @Test
    public void testFormat() {
        LocalDateTime localDateTime = LocalDateTime.of(2021,1,12,15,00);
        DateTimeFormatter formatter =
                DateTimeFormatter.ISO_LOCAL_DATE;
        String s = localDateTime.format(formatter);

        System.out.println(s);
        DateTimeFormatter formatter2 =
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String s2 = localDateTime.format(formatter2);

        System.out.println(s2);
        DateTimeFormatter formatter3 =
                DateTimeFormatter.ofPattern("yyyy. MMMM dd. hh:mm").withLocale(Locale.KOREA);
        String s3 = localDateTime.format(formatter3);

        System.out.println(s3);
    }
    @Test
    public void testParse() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String s = "2018-01-12 16:00";
        LocalDateTime localDateTime = LocalDateTime.parse(s, formatter);
        System.out.println(localDateTime);
    }
}
