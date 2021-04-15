# Gravar um arquivo CSV com o componente JSR223 do JMeter utilizando Java (Beanshell):

```java
import java.lang.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.String;
setStrictJava (true);

String paramA = vars.get("paramA");
String paramB = vars.get("paramB");
String paramC = vars.get("paramC");
String paramD = vars.get("paramD");

String row = paramA
.concat(";")
.concat(paramB)
.concat(";")
.concat(bacenjudProtocolDateTimeParam);
    
FileWriter fstream = new FileWriter("C:\\DIRETORIO\\MASSA_INTELIGENTE.csv", true);
BufferedWriter out = new BufferedWriter(fstream);
   
out.write(row);
out.write(System.getProperty("line.separator"));
out.close();
fstream.close();
```

## Para o componente não ser exibido nos Listerners, utilize um JSR223 PostProcessor com o seguinte script

```sh
prev.setIgnore();
```
