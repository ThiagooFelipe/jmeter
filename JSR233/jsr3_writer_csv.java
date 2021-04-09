import java.lang.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
setStrictJava (true);

log.info("==============================================" + vars.entrySet().size());

log.info(vars.get("bacenjudProceedingNumber"));
log.info(vars.get("bacenjudCourtNumber"));
log.info(vars.get("bacenjudProtocolDateTime"));
log.info(vars.get("investorDocumentNumber"));
log.info(vars.get("bacenjudProtocolNumber"));

ArrayList jMeterVariables = new ArrayList();

String bacenjudProceedingNumberParam;
String bacenjudCourtNumberParam;
String bacenjudProtocolDateTimeParam;
String investorDocumentNumberParam;
String bacenjudProtocolNumberParam;


/*
 * bacenjudProceedingNumber
 * bacenjudCourtNumber
 * bacenjudProtocolDateTime
 * investorDocumentNumber
 * bacenjudProtocolNumber
 */
for(Map.Entry entry : vars.entrySet()){
	
	if(entry.getKey().contains("bacenjudProceedingNumber")){
		bacenjudProceedingNumberParam = entry.getValue().toString();
	}

	if(entry.getKey().contains("bacenjudCourtNumber")){
		bacenjudCourtNumberParam = entry.getValue().toString();
	}

	if(entry.getKey().contains("bacenjudProtocolDateTime")){
		bacenjudProtocolDateTimeParam = entry.getValue().toString();
	}

	if(entry.getKey().contains("investorDocumentNumber")){
		investorDocumentNumberParam = entry.getValue().toString();
	}

	if(entry.getKey().contains("bacenjudProtocolNumber")){
		bacenjudProtocolNumberParam = entry.getValue().toString();
	}
	

//	jMeterVariables.add(entry.getKey() + "," + entry.getValue().toString());
	}
}


log.info("============================================ OUT " + bacenjudProceedingNumberParam);
log.info("============================================ OUT " + bacenjudCourtNumberParam);
log.info("============================================ OUT " + bacenjudProtocolDateTimeParam);
log.info("============================================ OUT " + investorDocumentNumberParam);
log.info("============================================ OUT " + bacenjudProtocolNumberParam);


 	
 /*
   String lineMass = vars.get("bacenjudProceedingNumber")
    .concat(";")
    .concat(vars.get("bacenjudCourtNumber"))
    .concat(";")
    .concat(vars.get("bacenjudProtocolDateTime"))
    .concat(";")
    .concat(vars.get("investorDocumentNumber"))
    .concat(";")
    .concat(vars.get("bacenjudProtocolNumber"));
    
    FileWriter fstream = new FileWriter("C:\\JEAN_DEV\\Bots\\BacenJud\\output\\MASSA_DESBLOQUEIO.txt", true);
    BufferedWriter out = new BufferedWriter(fstream);
    
    out.write(lineMass);
    out.write(System.getProperty("line.separator"));
    out.close();
    fstream.close();
   */
