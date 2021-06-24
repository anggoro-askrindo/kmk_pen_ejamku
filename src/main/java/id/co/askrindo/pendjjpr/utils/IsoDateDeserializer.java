package id.co.askrindo.pendjjpr.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;
import java.util.Date;

/**
 * Created by abian on 13/04/2018.
 */
public class IsoDateDeserializer extends JsonDeserializer<Date> {
    DateTimeFormatter parser = ISODateTimeFormat.dateTimeParser();

    @Override
    public Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
            throws IOException{
        String str = paramJsonParser.getText().trim();
        DateTime dateTimeIso = parser.parseDateTime(str);

        return dateTimeIso.toDate();
//        return paramDeserializationContext.parseDate(str);
    }
}
