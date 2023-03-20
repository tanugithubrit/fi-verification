package ai.lentra.controller;

import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Controller
public class ValidationController {

    public boolean isNumber(String number) {
        System.out.println(number+ " : NUMBER");
        Pattern p = Pattern.compile("#(\\\\d++)[^[^.]+$]");
        //new BigDecimal("0.03")

        // Pattern class contains matcher() method
        // to find matching between given number
        // and regular expression for which
        // object of Matcher class is created
        Matcher m = p.matcher(number);
        // Returning boolean value
        boolean result = m.matches();
        if(!result && number.contains(".")) {
            return false;
        }
        return true;
    }

    public int checkPresicion(BigDecimal currency) {
        BigDecimal noZero = currency.stripTrailingZeros();

        int scale = noZero.scale();
        int precision = noZero.precision();
        if (scale < 0) { // Adjust for negative scale
            precision -= scale;
        }
        return precision;
    }

    public boolean checkCurrency(BigDecimal currency) {
//        /^[1-9][0-9]{9,14}$/
//        /^[1-9][0-9]{9,14}$/


        if (checkPresicion(currency) < 0 || checkPresicion(currency) > 13 || currency.signum() == -1) {
            return false;
        }

        return true;
    }


    public boolean checkEmail(String email){

        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        //Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()){

            return true;
        }
        return false;
    }


    public  boolean isBigDecimal(String in) {
        try {
            BigDecimal.valueOf(Long.parseLong(in));
            // log something useful here
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public int checkLength(Integer otherFindings){
        int length = String.valueOf(otherFindings).length();

        return length;
    }

    public int checkLengthLong(Long value){
        int length = String.valueOf(value).length();

        return length;
    }

    public boolean checkDecimalLong(Long value){

        if(String.valueOf(value).contains(".") )
        {
            return true;
        }
        return false;
    }

    public boolean checkIntegerLong(Integer value){

        if(String.valueOf(value).contains(".") )
        {
            return true;
        }
        return false;
    }

    public boolean isDateFuture(final Date date, final String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy, hh:mm a");

        String dates = (sdf.format(date)).toString();

        LocalDateTime localDate = LocalDateTime.now(ZoneId.systemDefault());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
        LocalDateTime inputDate = LocalDateTime.parse(dates, dtf);

        return inputDate.isAfter(localDate);
    }

    public  boolean isValidFormat(Date value, String format) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = value;
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return date != null;
    }

}


