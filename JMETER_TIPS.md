# JMeter Tips

### ASCII Table

`http://www.vandermeer.de/projects/skb/java/asciitable/`

### Omissão coordenada

Omissão coordenada (Coordinated Omission), que pode lhe dar resultados errados ou imprecisos devido a falta de planejamento de um bom plano de teste junto com o correto recurso computacional para este plano de teste.

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

|Start Thread Count   	| Initial Delay, sec   	  | Startup Time, sec  	| Hold Load For, sec  	| Shutdown Time     |
|---	                |---	                  |---	                |---	                |---	            |
| 10   	                | 0  	                  | 300  	        | 3300                  | 0  	            |
| 10   	                | 900  	                  | 300  	        | 2400                  | 0  	            |
| 10  	                | 1800  	          | 300  	        | 1500                  | 0  	            |
| 10  	                | 2700  	          | 300  	        | 600                   | 0  	            |

|Start Thread Count   	| Initial Delay, sec   	  | Startup Time, sec  	| Hold Load For, sec  	| Shutdown Time     |
|---	                |---	                  |---	                |---	                |---	            |
| 250   	        | 0  	                  | 300  	        | 5100                  | 0  	            |
| 250   	        | 900  	                  | 300  	        | 4200                  | 0  	            |
| 250  	                | 1800  	          | 300  	        | 3300                  | 0  	            |
| 250  	                | 2700  	          | 300  	        | 2400                  | 0  	            |
| 250  	                | 3600  	          | 300  	        | 1500                  | 0  	            |
| 250  	                | 4500  	          | 300  	        | 600                   | 0  	            |

### JMeter - Ultimate Thread Group - Stress Test

|Start Thread Count   	| Initial Delay, sec   	| Startup Time, sec  	| Hold Load For, sec  	| Shutdown Time  	|
|---	                  |---	                  |---	                |---	                  |---	            |
| 100  	                | 0  	                  | 1800 	              | 1800                  | 0  	            |

|Start Thread Count   	| Initial Delay, sec   	| Startup Time, sec  	| Hold Load For, sec  	| Shutdown Time  	|
|---	                  |---	                  |---	                |---	                  |---	            |
| 100  	                | 0  	                  | 900 	              | 2700                  | 0  	            |

### JMeter - HTTP Head Manager (REST XML Requests)

`Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8` <br/>
`Accept-Encoding: gzip, deflate` <br/>
`Accept-Language: pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7` <br/>
`Cache-Control: no-cache` <br/>
`Connection: keep-alive` <br/>
`User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36` <br/>

### JMeter - HTTP Head Manager (REST JSON Requests)

`Accept: application/json` <br/>
`Accept-Encoding: gzip, deflate` <br/>
`Accept-Language: pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7` <br/>
`Cache-Control: no-cache` <br/>
`Connection: keep-alive` <br/>
`User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36`

### JMeter - HTTP Head Manager (SOAP Requests)

`Content-Type: text/xml;charset=UTF-8` <br/>
`Accept-Encoding:	gzip,deflate` <br/>
`Connection: Keep-Alive` <br/>
`User-Agent:	Apache-HttpClient/4.1.1 (java 1.5)` <br/>
`SOAPAction:	""` <br/>

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



### Erro no JMeter SSL em chamadas de WebService SOAP

Problema:
javax.net.ssl.SSLProtocolException: handshake alert: unrecognized_name
	at.sun.security.ssl.ClientHandshaker.handshakerAlert(Unknown Source)...
	...
	...
	
Diagnóstico:
O 

#Recomendação 1:

Troque no JMeter.bat:
De: 

`set JMETER_CMD_LINE_ARGS=%*`

Para:

`set JMETER_CMD_LINE_ARGS=-Djsse.enableSNIExtension=false`

Recomendação 2: 

1) Adicione um componente no robô: JSR223 Sampler
2) Adicione o código: `System.setProperty("jsse.enableSNIExtension", "false");`


### Jenkins Configure

Configuracao para integracao via parametros

|Param   	  	| EL / Value  		| Type			| Required				|
|---	                |---	                |---			|---					|
| Number of Threads 	| ${__P(threads,1)}	| Integer		| Yes					|
| Ramp-Up 		| ${__P(rampup,1)}	| Integer		| Yes					|
| Loop-Count 		| ${__P(loopCount,1)}	| Integer		| No (Set true in JMeter is default)	|
| Duration		| ${__P(duration,1)}	| Integer (Seconds)	| Yes					|
| Startup delay		| ${__P(startup,1)}	| Integer (Seconds)	| Yes					|
| Aggregate Report      | ${__P(aggregate)}	| String		| Yes					|
