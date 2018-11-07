package br.com.yaman.jmeter.csv.run;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.math3.stat.StatUtils;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.a7.A7_Grids;

public class Main {

	protected static List<FileEntity> rows;
	protected static List<String> rowsDistinct;
	protected static HashMap<String, FileEntity> labelsDistinctMap;
	protected static final String CSV_SPLIT_BY = ",";

	/**
	 * Constant in millis
	 */
	protected static final int AGGREGATION_DEFAULT = 30000;

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		String[] argsTemp1 = { "C:\\Users\\p0638868\\Desktop\\CalculoRE\\output\\BT_1_20181105-193521.csv" };
		@SuppressWarnings("unused")
		String[] argsTemp2 = { "C:\\Users\\p0638868\\Desktop\\CalculoRE\\output\\BT_2_20181105-193527.csv" };
		String[] argsTemp3 = { "C:\\Users\\Jean Carlos Bezerra\\Desktop\\SMOKE_TEST_20181107-005557.csv" };
		
		
		
		convertFileToList(argsTemp3[0]);
		
		testDetails();
		
		sortList();
		distinctLabels();
		calcPercentil();
		totalErrors();
		errorsDetails();
		
		
		
		

	}

	protected static void convertFileToList(String filePath) {
		try {

			rows = new ArrayList<FileEntity>();

			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

			String line = "";

			DateConvertionsUtil dateConvertionsUtil = new DateConvertionsUtil();

			while ((line = bufferedReader.readLine()) != null) {

				String[] content = line.split(CSV_SPLIT_BY);

				FileEntity rowLine = new FileEntity();

				rowLine.setTimeStamp(new Timestamp(dateConvertionsUtil.stringToTimestamp(content[0].toString()).getTime()));
				rowLine.setElapsed(Float.parseFloat(content[1].toString()));
				rowLine.setLabel(content[2].toString());
				rowLine.setResponseCode(Integer.parseInt(content[3].toString()));
				rowLine.setResponseMessage(content[4].toString());
				rowLine.setThreadName(content[5].toString());
				rowLine.setDataType(content[6].toString());
				if(!content[4].toString().contains("Number of samples in transaction")) {
					System.out.println("Sucesso ? " + content[7].toString());
					rowLine.setSuccess(Boolean.parseBoolean(content[7].toString()));
				}
				rowLine.setFailureMessage(content[8].toString());
				if(!content[4].toString().contains("Number of samples in transaction")) {
					rowLine.setBytes(Long.parseLong(content[9].toString()));
				}
				rowLine.setSentBytes(Long.parseLong(content[10].toString()));
				rowLine.setGrpThreads(Integer.parseInt(content[11].toString()));
				rowLine.setAllThreads(Integer.parseInt(content[12].toString()));
				rowLine.setLatency(Long.parseLong(content[13].toString()));
				rowLine.setIdleTime(Long.parseLong(content[14].toString()));
				rowLine.setConnect(Integer.parseInt(content[15].toString()));

				rows.add(rowLine);
			}

			bufferedReader.close();
			dateConvertionsUtil = null;

			// for (FileEntity rowFile : rows) {
			// System.out.println(rowFile.toString());
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Ordenação pelo campo timestamp
	 */
	protected static void sortList() {
		try {

			Collections.sort(rows, new Comparator<FileEntity>() {
				public int compare(FileEntity o1, FileEntity o2) {
					return o2.getTimeStamp().compareTo(o1.getTimeStamp());
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static void distinctLabels() {
		try {

			labelsDistinctMap = new HashMap<String, FileEntity>();

			List<String> temporaryList = new ArrayList<String>();
			List<String> labels = new ArrayList<String>();

			for (FileEntity row : rows) {
				temporaryList.add(row.getLabel());
			}

			labels = temporaryList.stream().distinct().collect(Collectors.toList());
			rowsDistinct = labels;

			for (String label : labels) {
				if (!label.equals(null)) {
					for (FileEntity row : rows) {
						if (row != null) {
							if (row.getLabel().equals(label)) {
								labelsDistinctMap.put(label, row);
							}
						}
					}
				}
			}
			
			
			System.out.println("\n");
			System.out.println("Cenários / Requisições");	
			// Console
			AsciiTable at = new AsciiTable();
			at.addRule();
			for (String label : rowsDistinct) {				
				at.addRow(label);
				at.addRule();
			}		
			at.getContext().setGrid(A7_Grids.minusBarPlusEquals());			
			at.getContext().setWidth(120);		
			String rend = at.render();
			System.out.println(rend);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static void calcPercentil() {
		try {

			System.out.println("\n");
			System.out.println("Resumo simplificado do teste (Todas as requisições) ");
			
			@SuppressWarnings("unused")
			List<FileEntity> list = new ArrayList<FileEntity>();
			double[] arrayDouble = new double[rows.size()];

			@SuppressWarnings("unused")
			Float mediaPct100 = null;
			Float mediaPct99 = null;
			Float mediaPct95 = null;
			Float mediaPct90 = null;
			@SuppressWarnings("unused")
			Float mediaPct75 = null;
			Float mean = null;
			@SuppressWarnings("unused")
			String mediaString = null;
			Float media = null;
			Float minimo = null;
			Float maximo = null;
			Integer count = 0;
			
			Float sumDouble = 0f;
			count = 0;

			for (int i = 0; i < rows.size(); i++) {
				Float convertion = rows.get(i).getElapsed();
				sumDouble += convertion;
				arrayDouble[i] = convertion;
				count++;
			}
			
			media = (Float) (sumDouble / count);

			DecimalFormat df = new DecimalFormat("#");
			df.setRoundingMode(RoundingMode.CEILING);

			mediaString = df.format(media);		

			Arrays.sort(arrayDouble);

			mediaPct100 = (float) StatUtils.percentile(arrayDouble, 100);
			mediaPct99 = (float) StatUtils.percentile(arrayDouble, 99);
			mediaPct95 = (float) StatUtils.percentile(arrayDouble, 95);
			mediaPct90 = (float) StatUtils.percentile(arrayDouble, 90);
			mediaPct75 = (float) StatUtils.percentile(arrayDouble, 75);
			minimo = (float) StatUtils.min(arrayDouble);
			maximo = (float) StatUtils.max(arrayDouble);
			mean = (float) StatUtils.mean(arrayDouble);		
			
			//Profissional
			AsciiTable at = new AsciiTable();		
			at.addRule();
			at.addRow("Requisições", "Amostras", "Média","Mediana","Pct 90%","Pct 95%","Pct 99%","Mínima","Máxima");
			at.addRule();
			at.addRow("Total das amostras ",rows.size(),media,mean,mediaPct90,mediaPct95,mediaPct99,minimo,maximo);
			at.addRule();
			
			at.getContext().setGrid(A7_Grids.minusBarPlusEquals());			
			at.getContext().setWidth(120);		
			String rend = at.render();
			System.out.println(rend);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static void totalErrors(){
		try {
			
			List<FileEntity> totalErrosList = new ArrayList<FileEntity>();
			List<FileEntity> totalSuccessList = new ArrayList<FileEntity>();
			
			for (FileEntity row : rows) {			
				if(row.getSuccess().equals(true) ){
					totalSuccessList.add(row);
				}else{
					totalErrosList.add(row);
				}				
			}
			
			
			
			
			
			System.out.println("\n");
			System.out.println("Erros encontrados no teste (Tratados e não tratados)");
			AsciiTable at = new AsciiTable();
			at.addRule();
			at.addRow("Total de requisições ", rows.size(), "Percentual de viabilidade");
			at.addRule();
			at.addRow("Total de requisições (sucesso) ", totalSuccessList.size() , ((( (float) (totalSuccessList.size()) / ( (float) rows.size() ) ) * 100) + "%") + " more and better ");
			at.addRule();
			at.addRow("Total de requisições (erro) ", totalErrosList.size() , ((( (float) (totalErrosList.size()) / ( (float) rows.size() ) ) * 100) + "%") + " less is better ");
			at.addRule();
			
			at.getContext().setGrid(A7_Grids.minusBarPlusEquals());			
			at.getContext().setWidth(120);		
			String rend = at.render();
			System.out.println(rend);		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected static void testDetails(){
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss.sss");
			
			System.out.println("\n");
			System.out.println("Horário");
			AsciiTable at = new AsciiTable();			
			at.addRule();
			at.addRow("Inicio do teste ", sdf.format(rows.get(1).getTimeStamp()));
			at.addRule();
			at.addRow("Fim do teste ", sdf.format(rows.get((int) (rows.size()-1)).getTimeStamp()));
			at.addRule();
			
			at.getContext().setGrid(A7_Grids.minusBarPlusEquals());			
			at.getContext().setWidth(60);		
			String rend = at.render();
			System.out.println(rend);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected static void errorsDetails(){
		try {
			
			List<String> tempList = new ArrayList<String>();
			List<String> listErrorsDistinct = new ArrayList<String>();
			
			for (FileEntity row : rows) {
				if(row.getSuccess().equals(false)){
					tempList.add(row.getFailureMessage());
				}
			}
			
			if(!tempList.isEmpty()) {
			
				listErrorsDistinct = tempList.stream().distinct().collect(Collectors.toList());			
			
				System.out.println("\n");
				System.out.println("Erros encontrados neste teste");
				AsciiTable at = new AsciiTable();			
				at.addRule();
				for (String errorMessage : listErrorsDistinct) {				
					at.addRow(errorMessage);
					at.addRule();
				}
				
				at.getContext().setGrid(A7_Grids.minusBarPlusEquals());			
				at.getContext().setWidth(120);		
				String rend = at.render();
				System.out.println(rend);
			
			}else {
				
				System.out.println("\n");
				System.out.println("Erros encontrados neste teste");
				AsciiTable at = new AsciiTable();			
				at.addRule();								
				at.addRow("Nenhum erro identificado");
				at.addRule();				
				at.getContext().setGrid(A7_Grids.minusBarPlusEquals());			
				at.getContext().setWidth(120);		
				String rend = at.render();
				System.out.println(rend);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
