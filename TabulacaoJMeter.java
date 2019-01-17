``java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class TabulacaoJMeter {

	protected static List<FileEntity> rows;
	protected static List<FileEntity> rowsOriginal;
	protected static List<String> rowsDistinct;
	protected static HashMap<String, List<FileEntity>> groupByLabelList;
	protected static HashMap<String, List<FileEntity>> groupByLabelListUserGroup;

	protected static HashMap<String, FileEntity> labelsDistinctMap;
	protected static final String CSV_SPLIT_BY = ",";

	protected static String PATH = ".";
	/**
	 * Constant in millis
	 */
	protected static final int AGGREGATION_DEFAULT = 30000;

	public static void main(String[] args) {

		String[] argsTemp = { "C:\\Users\\p0638868\\Desktop\\POC\\CALCULO_RE_BT_3.csv" };

		PATH = argsTemp[0].toString();

		readerFile(argsTemp[0]);
		testDetails();
		sort();
		distinctAllLabels();
		groupRequestByLabel();
		calcPercentileByLabel();
		tabulacaoPorGrupoUsuario();

	}

	@Deprecated
	public static void readerFile(String filePath) {
		try {

			rows = new ArrayList<FileEntity>();
			rowsOriginal = new ArrayList<FileEntity>();

			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

			String line = "";

			DateConvertionsUtil dateConvertionsUtil = new DateConvertionsUtil();

			while ((line = bufferedReader.readLine()) != null) {

				String[] content = line.split(CSV_SPLIT_BY);

				FileEntity rowLine = new FileEntity();

				// rowLine.setTimeStamp(new
				// Timestamp(dateConvertionsUtil.stringToTimestamp(content[0].toString()).getTime()));
				rowLine.setTimeStamp(dateConvertionsUtil.stringToLocalDateTime(content[0].toString()));
				rowLine.setElapsed(Integer.parseInt(content[1].toString()));
				rowLine.setLabel(content[2].toString());

				if ((content[3].toString() != null) && (!content[3].isEmpty())) {
					if (content[3].toString().contains("Non HTTP response code")) {
						rowLine.setResponseCode(500);
						rowLine.setSuccess(false);
					} else {
						rowLine.setResponseCode(Integer.parseInt(content[3].toString()));
					}
				}

				rowLine.setResponseMessage(content[4].toString());
				rowLine.setThreadName(content[5].toString());
				rowLine.setDataType(content[6].toString());

				if (!rowLine.getLabel().contains("Number of samples in transaction")) {
					if (content[3].toString().contains("Non HTTP response code")) {

					} else {
						rowLine.setSuccess(Boolean.parseBoolean(content[7].toString()));
					}
				}

				rowLine.setFailureMessage(content[8].toString());

				// if(!content[4].toString().contains("Number of samples in
				// transaction")) {
				// rowLine.setBytes(Long.parseLong( ((content[9].toString() ==
				// null) ? "" : (content[9].toString()) ) ));
				// }

				// rowLine.setSentBytes(Long.parseLong(content[10].toString()));
				// rowLine.setGrpThreads(Integer.parseInt(content[11].toString()));
				// rowLine.setAllThreads(Integer.parseInt(content[12].toString()));
				// rowLine.setLatency(Long.parseLong(content[13].toString()));
				// rowLine.setIdleTime(Long.parseLong(content[14].toString()));
				// rowLine.setConnect(Integer.parseInt(content[15].toString()));

				rows.add(rowLine);
				rowLine = null;
			}

			bufferedReader.close();
			dateConvertionsUtil = null;

			rowsOriginal = rows;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<FileEntity> readerFileUpload(InputStream uploadFile) {
		try {

			rows = new ArrayList<FileEntity>();
			rowsOriginal = new ArrayList<FileEntity>();

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uploadFile, "UTF-8"));

			String line = "";

			DateConvertionsUtil dateConvertionsUtil = new DateConvertionsUtil();

			while ((line = bufferedReader.readLine()) != null) {

				String[] content = line.split(CSV_SPLIT_BY);

				FileEntity rowLine = new FileEntity();

				// rowLine.setTimeStamp(new
				// Timestamp(dateConvertionsUtil.stringToTimestamp(content[0].toString()).getTime()));
				rowLine.setTimeStamp(dateConvertionsUtil.stringToLocalDateTime(content[0].toString()));
				rowLine.setElapsed(Integer.parseInt(content[1].toString()));
				rowLine.setLabel(content[2].toString());

				if ((content[3].toString() != null) && (!content[3].isEmpty())) {
					if (content[3].toString().contains("Non HTTP response code")) {
						rowLine.setResponseCode(500);
						rowLine.setSuccess(false);
					} else {
						rowLine.setResponseCode(Integer.parseInt(content[3].toString()));
					}
				}

				rowLine.setResponseMessage(content[4].toString());
				rowLine.setThreadName(content[5].toString());
				rowLine.setDataType(content[6].toString());

				if (!rowLine.getLabel().contains("Number of samples in transaction")) {
					if (content[3].toString().contains("Non HTTP response code")) {

					} else {
						rowLine.setSuccess(Boolean.parseBoolean(content[7].toString()));
					}
				}

				rowLine.setFailureMessage(content[8].toString());

				// if(!content[4].toString().contains("Number of samples in
				// transaction")) {
				// rowLine.setBytes(Long.parseLong( ((content[9].toString() ==
				// null) ? "" : (content[9].toString()) ) ));
				// }

				// rowLine.setSentBytes(Long.parseLong(content[10].toString()));
				// rowLine.setGrpThreads(Integer.parseInt(content[11].toString()));
				// rowLine.setAllThreads(Integer.parseInt(content[12].toString()));
				// rowLine.setLatency(Long.parseLong(content[13].toString()));
				// rowLine.setIdleTime(Long.parseLong(content[14].toString()));
				// rowLine.setConnect(Integer.parseInt(content[15].toString()));

				rows.add(rowLine);
				rowLine = null;
			}

			bufferedReader.close();
			dateConvertionsUtil = null;

			rowsOriginal = rows;
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ResumeTestEntity testDetails() {
		try {
			ResumeTestEntity resumeTestEntity = new ResumeTestEntity();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss.sss");
			// System.out.println("Inicio do teste " +
			// sdf.format(rows.get(0).getTimeStamp().toString()));
			// System.out.println("Fim do teste " + sdf.format(rows.get((int)
			// (rows.size()-1)).getTimeStamp()));

			List<FileEntity> totalRequests = new ArrayList<FileEntity>();
			List<FileEntity> totalTransactions = new ArrayList<FileEntity>();
			List<FileEntity> totalErrosList = new ArrayList<FileEntity>();
			List<FileEntity> totalSuccessList = new ArrayList<FileEntity>();

			for (FileEntity row : rows) {
				if (row.getSuccess() != null) {
					if (row.getSuccess().booleanValue()) {
						totalSuccessList.add(row);
					} else {
						totalErrosList.add(row);
					}
				}

				if (!row.getResponseMessage().contains("Number of samples in transaction")) {
					totalRequests.add(row);
				} else {
					totalTransactions.add(row);
				}
			}

			resumeTestEntity.setTotalRequisicao(totalRequests.size());
			resumeTestEntity.setTotalRequisicaoSucesso(totalSuccessList.size());
			resumeTestEntity.setTotalRequisicaoFalha(totalErrosList.size());
			resumeTestEntity.setTotalTransacao(totalTransactions.size());
			resumeTestEntity.setTotalTransacaoSucesso(9999999);
			resumeTestEntity.setTotalTransacaoFalha(99999999);
			resumeTestEntity
					.setPercentualSucesso((((float) (totalSuccessList.size()) / ((float) totalRequests.size())) * 100));
			resumeTestEntity
					.setPercentualFalha((((float) (totalErrosList.size()) / ((float) totalRequests.size())) * 100));

			totalRequests = null;
			totalTransactions = null;
			totalSuccessList = null;
			totalErrosList = null;

			return resumeTestEntity;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void sort() {
		try {

			Collections.sort(rows, new Comparator<FileEntity>() {
				public int compare(FileEntity o1, FileEntity o2) {
					return o1.getElapsed().compareTo(o2.getElapsed());
				}
			});

			Collections.sort(rowsOriginal, new Comparator<FileEntity>() {
				public int compare(FileEntity a1, FileEntity a2) {
					return a1.getTimeStamp().compareTo(a2.getTimeStamp());
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<String> distinctAllLabels() {
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

			return rowsDistinct;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void groupRequestByLabel() {
		try {

			if (groupByLabelList == null) {
				groupByLabelList = new HashMap<String, List<FileEntity>>();
			}

			for (String label : rowsDistinct) {
				List<FileEntity> listTemporary = new ArrayList<FileEntity>();
				for (FileEntity row : rows) {
					if (row.getLabel().equals(label)) {
						listTemporary.add(row);
					}
				}
				groupByLabelList.put(label, listTemporary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public static List<TabulacaoEntity> calcPercentileByLabel() {
		try {

			List<TabulacaoEntity> tabulacoes = new ArrayList<TabulacaoEntity>();

			for (Map.Entry<String, List<FileEntity>> row : groupByLabelList.entrySet()) {

				double[] arrayByLabel = new double[row.getValue().size()];

				Float sumDouble = 0f;
				Float mediaPct100 = null;
				Float mediaPct99 = null;
				Float mediaPct95 = null;
				Float mediaPct90 = null;
				Float mediaPct75 = null;
				Float mean = null;
				Float media = null;
				Float minimo = null;
				Float maximo = null;
				Integer count = 0;

				DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();

				for (int i = 0; i < row.getValue().size(); i++) {
					descriptiveStatistics.addValue(row.getValue().get(i).getElapsed());
				}

				// for (int i = 0; i < row.getValue().size(); i++) {
				// Integer convertion = row.getValue().get(i).getElapsed();
				// sumDouble += convertion;
				// arrayByLabel[i] = convertion;
				// count++;
				// }

				// media = (Float) (sumDouble / count);

				// Arrays.sort(arrayByLabel);

				mediaPct100 = (float) descriptiveStatistics.getPercentile(100);
				mediaPct99 = (float) descriptiveStatistics.getPercentile(99);
				mediaPct95 = (float) descriptiveStatistics.getPercentile(95);
				mediaPct90 = (float) descriptiveStatistics.getPercentile(90);
				mediaPct75 = (float) descriptiveStatistics.getPercentile(75);
				minimo = (float) descriptiveStatistics.getMin();
				maximo = (float) descriptiveStatistics.getMax();
				mean = (float) descriptiveStatistics.getMean();
				media = (float) descriptiveStatistics.getPercentile(50);

				// mediaPct100 = (float) StatUtils.percentile(arrayByLabel,
				// 100);
				// mediaPct99 = (float) StatUtils.percentile(arrayByLabel,
				// 99.9);
				// mediaPct95 = (float) StatUtils.percentile(arrayByLabel,
				// 94.9);
				// mediaPct90 = (float) StatUtils.percentile(arrayByLabel,
				// 89.9);
				// mediaPct75 = (float) StatUtils.percentile(arrayByLabel,
				// 74.5);
				// minimo = (float) StatUtils.min(arrayByLabel);
				// maximo = (float) StatUtils.max(arrayByLabel);
				// mean = (float) StatUtils.mean(arrayByLabel);

				TabulacaoEntity tabulacaoEntity = new TabulacaoEntity();

				tabulacaoEntity.setLabel(row.getKey());
				tabulacaoEntity.setQtdamostras(arrayByLabel.length);
				tabulacaoEntity.setMedia(media);
				tabulacaoEntity.setMediana(mean);
				tabulacaoEntity.setPct90(mediaPct90);
				tabulacaoEntity.setPct95(mediaPct95);
				tabulacaoEntity.setPct99(mediaPct99);
				tabulacaoEntity.setMinima(minimo);
				tabulacaoEntity.setMaxima(maximo);

				tabulacoes.add(tabulacaoEntity);

				tabulacaoEntity = null;
			}

			return tabulacoes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void agregacaoPorTimestamp() {
		try {

			//
			// int agregation = 30;
			// Date startDate = rows.get(1).getTimeStamp();
			// Date endDate = rows.get(rows.size()-1).getTimeStamp();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<FileGroupEntity> tabulacaoPorGrupoUsuario() {
		try {

			List<FileGroupEntity> listFileGroupEntity = new ArrayList<FileGroupEntity>();

			for (Entry<String, List<FileEntity>> labelGroup : groupByLabelList.entrySet()) {

				ZoneId saoPauloTimeZone = ZoneId.of("America/Sao_Paulo");

				List<FileEntity> grupo1 = new ArrayList<FileEntity>();
				List<FileEntity> grupo2 = new ArrayList<FileEntity>();
				List<FileEntity> grupo3 = new ArrayList<FileEntity>();
				List<FileEntity> grupo4 = new ArrayList<FileEntity>();
				List<FileEntity> limbo = new ArrayList<FileEntity>();

				LocalDateTime startFirstGroupTime = rowsOriginal.get(0).getTimeStamp();
				LocalDateTime endFirstGroupTime = null;
				LocalDateTime endFirstGroupTime2 = null;

				LocalDateTime startSecondGroupTime = null;
				LocalDateTime startSecondGroupTime2 = null;

				LocalDateTime endSecondGroupTime = null;
				LocalDateTime endSecondGroupTime2 = null;

				LocalDateTime startThirdGroupTime = null;
				LocalDateTime startThirdGroupTime2 = null;

				LocalDateTime endThirdGroupTime = null;
				LocalDateTime endThirdGroupTime2 = null;

				LocalDateTime startFourthGroupTime = null;
				LocalDateTime startFourthGroupTime2 = null;

				LocalDateTime endFourthGroupTime = null;
				LocalDateTime endFourthGroupTime2 = null;

				// Instant
				endFirstGroupTime = startFirstGroupTime;
				endFirstGroupTime2 = endFirstGroupTime.plus(15, ChronoUnit.MINUTES);

				startSecondGroupTime = endFirstGroupTime2;
				startSecondGroupTime2 = startSecondGroupTime.plus(1, ChronoUnit.MILLIS);
				endSecondGroupTime = endFirstGroupTime2;
				endSecondGroupTime2 = endSecondGroupTime.plus(15, ChronoUnit.MINUTES);

				startThirdGroupTime = endSecondGroupTime2;
				startThirdGroupTime2 = startThirdGroupTime.plus(1, ChronoUnit.MILLIS);
				endThirdGroupTime = endSecondGroupTime2;
				endThirdGroupTime2 = endThirdGroupTime.plus(15, ChronoUnit.MINUTES);

				startFourthGroupTime = endThirdGroupTime2;
				startFourthGroupTime2 = startFourthGroupTime.plus(1, ChronoUnit.MILLIS);
				endFourthGroupTime = endThirdGroupTime2;
				endFourthGroupTime2 = endFourthGroupTime.plus(15, ChronoUnit.MINUTES);

				// Configuração do Timezone
				startFirstGroupTime.atZone(saoPauloTimeZone);
				endFirstGroupTime.atZone(saoPauloTimeZone);
				startSecondGroupTime.atZone(saoPauloTimeZone);
				endSecondGroupTime.atZone(saoPauloTimeZone);
				startThirdGroupTime.atZone(saoPauloTimeZone);
				endThirdGroupTime.atZone(saoPauloTimeZone);
				startFourthGroupTime.atZone(saoPauloTimeZone);
				endFourthGroupTime.atZone(saoPauloTimeZone);

				System.out.println("Hora de inicio do teste : " + rowsOriginal.get(0).getTimeStamp());

				// Instant
				System.out.println("Time check : " + startFirstGroupTime + " / " + endFirstGroupTime2);
				System.out.println("Time check : " + startSecondGroupTime2 + " / " + endSecondGroupTime2);
				System.out.println("Time check : " + startThirdGroupTime2 + " / " + endThirdGroupTime2);
				System.out.println("Time check : " + startFourthGroupTime2 + " / " + endFourthGroupTime2);

				for (FileEntity row : rows) {
					if (row.getTimeStamp().isBefore(endFirstGroupTime2)) {
						grupo1.add(row);
					} else if (row.getTimeStamp().isAfter(endFirstGroupTime2) && row.getTimeStamp().isBefore(endSecondGroupTime2)) {
						grupo2.add(row);
					} else if (row.getTimeStamp().isAfter(endSecondGroupTime2) && row.getTimeStamp().isBefore(endThirdGroupTime2)) {
						grupo3.add(row);
					} else if (row.getTimeStamp().isAfter(endThirdGroupTime2)) {
						grupo4.add(row);
					} else {
						limbo.add(row);
					}
				}

				System.out.println("grupo1 - size : " + grupo1.size());
				System.out.println("grupo2 - size : " + grupo2.size());
				System.out.println("grupo3 - size : " + grupo3.size());
				System.out.println("grupo4 - size : " + grupo4.size());
				System.out.println("limbo - size : " + limbo.size());

				// Grupo 1
				// ============================================================================================
				FileGroupEntity fileGroupEntity = new FileGroupEntity();

				Float media = null;
				Float maxima = null;
				Integer taxaSucesso = 0;
				Integer taxaErro = 0;
				DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();

				for (FileEntity grupo1Row : grupo1) {
					descriptiveStatistics.addValue(grupo1Row.getElapsed());

					if (grupo1Row.getSuccess()) {
						taxaSucesso++;
					} else {
						taxaErro++;
					}
				}

				media = (float) descriptiveStatistics.getPercentile(50);
				maxima = (float) descriptiveStatistics.getMax();

				fileGroupEntity.setGp1Label(labelGroup.getKey());
				fileGroupEntity.setGp1Media(media);
				fileGroupEntity.setGp1Maxima(maxima);
				fileGroupEntity.setGp1QtdRequisicao(grupo1.size());
				fileGroupEntity.setGp1Sucesso((float) ((taxaSucesso / grupo1.size()) * 100));

				// Grupo 2
				// ============================================================================================
				media = null;
				maxima = null;
				taxaSucesso = 0;
				taxaErro = 0;
				descriptiveStatistics = new DescriptiveStatistics();

				for (FileEntity grupo2Row : grupo2) {
					descriptiveStatistics.addValue(grupo2Row.getElapsed());

					if (grupo2Row.getSuccess()) {
						taxaSucesso++;
					} else {
						taxaErro++;
					}
				}

				media = (float) descriptiveStatistics.getPercentile(50);
				maxima = (float) descriptiveStatistics.getMax();

				fileGroupEntity.setGp2Label(labelGroup.getKey());
				fileGroupEntity.setGp2Media(media);
				fileGroupEntity.setGp2Maxima(maxima);
				fileGroupEntity.setGp2QtdRequisicao(grupo2.size());
				fileGroupEntity.setGp2Sucesso((float) ((taxaSucesso / grupo2.size()) * 100));

				// Grupo 3
				// ============================================================================================
				media = null;
				maxima = null;
				taxaSucesso = 0;
				taxaErro = 0;
				descriptiveStatistics = new DescriptiveStatistics();

				for (FileEntity grupo3Row : grupo3) {
					descriptiveStatistics.addValue(grupo3Row.getElapsed());

					if (grupo3Row.getSuccess()) {
						taxaSucesso++;
					} else {
						taxaErro++;
					}
				}

				media = (float) descriptiveStatistics.getPercentile(50);
				maxima = (float) descriptiveStatistics.getMax();

				fileGroupEntity.setGp3Label(labelGroup.getKey());
				fileGroupEntity.setGp3Media(media);
				fileGroupEntity.setGp3Maxima(maxima);
				fileGroupEntity.setGp3QtdRequisicao(grupo3.size());
				fileGroupEntity.setGp3Sucesso((float) ((taxaSucesso / grupo3.size()) * 100));

				// Grupo 4
				// ============================================================================================
				media = null;
				maxima = null;
				taxaSucesso = 0;
				taxaErro = 0;
				descriptiveStatistics = new DescriptiveStatistics();

				for (FileEntity grupo4Row : grupo4) {
					descriptiveStatistics.addValue(grupo4Row.getElapsed());

					if (grupo4Row.getSuccess()) {
						taxaSucesso++;
					} else {
						taxaErro++;
					}
				}

				media = (float) descriptiveStatistics.getPercentile(50);
				maxima = (float) descriptiveStatistics.getMax();

				fileGroupEntity.setGp4Label(labelGroup.getKey());
				fileGroupEntity.setGp4Media(media);
				fileGroupEntity.setGp4Maxima(maxima);
				fileGroupEntity.setGp4QtdRequisicao(grupo4.size());
				fileGroupEntity.setGp4Sucesso((float) ((taxaSucesso / grupo4.size()) * 100));

				listFileGroupEntity.add(fileGroupEntity);

				fileGroupEntity = null;
			}

			
			for (FileGroupEntity fileGroupEntity2 : listFileGroupEntity) {
				System.out.println(fileGroupEntity2.toString());
			}
			
			return listFileGroupEntity;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

``
