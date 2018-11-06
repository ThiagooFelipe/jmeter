package br.com.yaman.apm.tabulacao.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertionsUtil {

	protected static final String BRAZIL_DATE_FORMAT = "dd/MM/yyyy HH:mm:ss.sss";

	public DateConvertionsUtil() {

	}

	public String stringToDate(String param) {
		try {
			String dateFormat = null;
			if (param != null) {
				SimpleDateFormat sdf = new SimpleDateFormat(BRAZIL_DATE_FORMAT);
				Date date = new Date(Long.parseLong(param));
				dateFormat = sdf.format(date);
			}
			return dateFormat;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Date stringToTimestamp(String param) {
		try {
			Date timestamp = null;
			if (param != null) {
				timestamp = new Timestamp(Long.parseLong(param));
			}
			return timestamp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
