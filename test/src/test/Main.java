package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = readTimestamp("2020-07-05 12:32:11");	
	}
	
    protected static Date readTimestamp(String timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());
        try {
            return dateFormat.parse(timestamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

}
