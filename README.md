# jmetertools

### ASCII Table

`http://www.vandermeer.de/projects/skb/java/asciitable/`

### JMeter - Saída de arquivos padrões

`BT_1_${__time(yyyyMMdd-HHmmss)}.csv`

`BT_2_${__time(yyyyMMdd-HHmmss)}.csv`

`BT_3_${__time(yyyyMMdd-HHmmss)}.csv`

### JMeter - Proxy via jmeter.bat

`jmeter.bat -H <HOSTNAME> -P <PORTA> -u <USUARIO> -a <SENHA>`

### JMeter - Ultimate Thread Group - Load Test

|Start Thread Count   	| Initial Delay, sec   	| Startup Time, sec  	| Hold Load For, sec  	| Shutdown Time  	|
|---	                  |---	                  |---	                |---	                  |---	            |
| 10   	                | 0  	                  | 300  	              | 3600                  | 0  	            |
| 10   	                | 900  	                | 300  	              | 2700                  | 0  	            |
| 10  	                | 1800  	              | 300  	              | 1800                  | 0  	            |
| 10  	                | 2700  	              | 300  	              | 900                   | 0  	            |

### JMeter - Ultimate Thread Group - Stress Test

|Start Thread Count   	| Initial Delay, sec   	| Startup Time, sec  	| Hold Load For, sec  	| Shutdown Time  	|
|---	                  |---	                  |---	                |---	                  |---	            |
| 100  	                | 0  	                  | 1800 	              | 1800                  | 0  	            |


### Conversão de Date e Calendar

```java
	Date date = new Date();
	date.setDate(22);
	date.setHours(22);
	date.setMinutes(00);
	date.setSeconds(00);			
	date.setMonth(10);
	date.setYear(2018);
		
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.sss");
	Calendar now = Calendar.getInstance();
	now.setTime(date);
	Calendar nowBackup = now;			
	now.add(Calendar.SECOND, 30);			
	System.out.println("Now : " + now.getTime());
	System.out.println("Now Backup: " + nowBackup.getTime());
```

### Calculo do Percentil em Java (Commons Math - JMeter Compatible))

Use `ELAPSED` field from your Agregation Report of JMeter

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class MainDescritivo {
	public static void main(String[] args) {
		try {
			
			List<Integer> listFromCSV = new ArrayList<Integer>();			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				String content = line;				
				int value = Integer.parseInt(content);				
				listFromCSV.add(value);
			}		
			bufferedReader.close();			
			
			DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();			
			for (Integer valueFor : listFromCSV) {
				descriptiveStatistics.addValue(valueFor);
			}
			
			float value = (float) descriptiveStatistics.getPercentile(90);			
			System.out.println(value);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
```
