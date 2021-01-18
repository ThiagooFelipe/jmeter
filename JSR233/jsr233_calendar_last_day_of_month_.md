# JSR233 - Calendar

## Coletar a última data de cada mês com o componente JSR233 do JMeter utilizando Java (Beanshell):

```java
import java.lang.*;
import java.util.Calendar;
setStrictJava (true);

Calendar rightNow = Calendar.getInstance();
String[] monthArray = {"01","02","03","04","05","06","07","08","09","10","11","12"};

log.info("============================================== YEAR : " + rightNow.get(Calendar.YEAR) );
log.info("============================================== MONTH : " + rightNow.get(Calendar.MONTH) );
log.info("============================================== DATE : " + rightNow.get(Calendar.DATE) );
log.info("==============================================");

int lastDayOfActualMonth = rightNow.getActualMaximum(Calendar.DATE);
String actualMonth = monthArray[rightNow.get(Calendar.MONTH)];
int actualYear = rightNow.get(Calendar.YEAR);			
			
log.info("============================================== LastDayOfActualMonth : " + lastDayOfActualMonth);
log.info("============================================== ActualMonth : " + actualMonth);
log.info("============================================== ActualYear : " + actualYear);
log.info("==============================================");

vars.put("LAST_DAY_OF_MONTH", lastDayOfActualMonth.toString());
vars.put("ACTUAL_MONTH", actualMonth.toString());
vars.put("ACTUAL_YEAR", actualYear.toString());
```
