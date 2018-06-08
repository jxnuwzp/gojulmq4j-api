package org.gojul.gojulmq4j.kafka.avroutils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Class {@code DateTimeConverter} provides easy-to-use methods
 * that make it possible to convert date and times from/to Avro
 * long and int formats.
 *
 * @author jaubin
 */
public class DateTimeConverter {

    /**
     * Jan 1st, 1970
     */
    final static LocalDate EPOCH = LocalDate.ofEpochDay(0L);

    private DateTimeConverter() {

    }

    /**
     * Return the number days since epoch (Jan 1st, 1970, 00:00:00 GMT)
     * in date {@code d}, or {@code null} if {@code d} is {@code null}.
     *
     * @param d the date for which the conversion must be done.
     *
     * @return the number days since epoch (Jan 1st, 1970, 00:00:00 GMT)
     * in date {@code d}, or {@code null} if {@code d} is {@code null}.
     */
    public static Integer dateToEpochDays(final Date d) {
        if (d == null) {
            return null;
        }

        LocalDate localDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        // The lib will probably be dead far before 1 million of years... ;-)
        return (int) ChronoUnit.DAYS.between(EPOCH, localDate);
    }
}
