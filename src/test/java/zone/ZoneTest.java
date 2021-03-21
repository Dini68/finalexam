package zone;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.Assert.assertEquals;

public class ZoneTest {

    @Test
    public void testZoneId() {
        System.out.println(ZoneId.getAvailableZoneIds());
        System.out.println(ZoneId.systemDefault());

        ZoneId zoneId = ZoneId.of("Europe/Budapest");
        assertEquals(true, ZoneId.getAvailableZoneIds().contains(zoneId.toString()));
    }

    @Test
    public void testZoneDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2021, 3, 20, 16, 00);
        ZonedDateTime zonedDateTime =
                ZonedDateTime.of(localDateTime, ZoneId.of("Europe/Budapest"));
        System.out.println(zonedDateTime);
        assertEquals("2021-03-20T16:00+01:00[Europe/Budapest]"
                , zonedDateTime.toString());
    }

    @Test
    public void testChange() {
        LocalDateTime localDateTime = LocalDateTime.of(2021, 3, 20, 16, 00);
        ZonedDateTime zonedDateTime =
                ZonedDateTime.of(localDateTime, ZoneId.of("Europe/Budapest"));
        ZonedDateTime zonedDateTime1 =
                zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));
        assertEquals("2021-03-20T15:00Z[UTC]", zonedDateTime1.toString());
    }
    @Test
    public void testDaylightSaving() {
        ZonedDateTime zonedDateTime =
                ZonedDateTime.of(LocalDateTime.of(2017, 3, 26, 1, 59),
                        ZoneId.of("Europe/Budapest"));
        ZonedDateTime zonedDateTime1 = zonedDateTime.plusMinutes(1);
        System.out.println(zonedDateTime1);
        assertEquals("2017-03-26T03:00+02:00[Europe/Budapest]", zonedDateTime1.toString());
    }
}

