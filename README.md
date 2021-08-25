# Bem-vindo(a) Ao meu repositório sobre JMeter

## Objetivo Geral

Centralizar conhecimento sobre a ferramenta JMeter

## Importante

Seus recursos de hardware, bem como o design do plano de teste, afetarão o número de threads que você pode executar com eficácia com o JMeter. 

O número também dependerá da velocidade do seu servidor (um servidor mais rápido faz com que o JMeter trabalhe mais, pois retorna uma resposta mais rápida). 

Como acontece com qualquer ferramenta de teste de carga, se você não dimensionar corretamente o número de threads, enfrentará o problema de "Omissão coordenada", que pode fornecer resultados errados ou imprecisos. 

Se você precisar de teste de carga em grande escala, considere executar várias instâncias CLI JMeter em várias máquinas usando o modo distribuído (ou não). 

Ao usar o modo distribuído, o arquivo de resultado é combinado no nó do controlador; se estiver usando várias instâncias autônomas, os arquivos de resultado de amostra podem ser combinados para análise subsequente. 

Para testar o desempenho do JMeter em uma determinada plataforma, o amostrador JavaTest pode ser usado. Não requer nenhum acesso à rede, portanto, pode dar uma ideia quanto ao rendimento máximo possível.

## Gerar resultados em HTML Reports (APDEX)

```sh
jmeter.sh -g <log file> -o <Path to output folder>
```
  
## Executar em linha de comando

- Debug Mode

```sh
jmeter.sh --nongui --testfile <BOT_SCRIPT>
  --jmeterproperty threads=<BOT_NUMBER_THREADS_SM>
  --jmeterproperty rampup=<COE_BOT_SMOKE_RAMPUP>
  --jmeterproperty duration=<BOT_SMOKE_DURATION>
  --jmeterproperty startup=<BOT_STARTUPDELAY>
  --jmeterproperty protocol=<ENVIRONMENT>
  --jmeterproperty url=<ENVIRONMENT>  
  --jmeterproperty port=<ENVIRONMENT>
  --jmeterproperty aggregate=load-test.csv
  --loglevel jmeter.util=DEBUG
```

- Performance Mode

```sh
jmeter.sh --nongui --testfile <BOT_SCRIPT>
  --jmeterproperty threads=<BOT_NUMBER_THREADS_SM>
  --jmeterproperty rampup=<COE_BOT_SMOKE_RAMPUP>
  --jmeterproperty duration=<BOT_SMOKE_DURATION>
  --jmeterproperty startup=<BOT_STARTUPDELAY>
  --jmeterproperty aggregate=load-test.csv
  --loglevel
 ```

## Limpeza dos Scripts

- `analytics`
- `facebook`
- `youtube`
- `onetrust`
- `hotjar`
- `tap`
- `pingdom`
- 
## Práticas

<ol>
  <li>Não use espacos nos nomes dos arquivos</li>
  <li>Crie pastas sem espacos e de preferencia perto da raiz do disco</li>
  <li>Utilize servidores que possuem discos SSD sempre que possivel</li>
  <li>Interfaces de rede acima de 1 Gigabit é obrigatório</li>
  <li>Interfaces de rede acima de 10 Gigabit é recomendado</li>
  <li>Processadores com o clock acima de 2.5 Ghz é obrigatório</li>
  <li>Use no minimo 2 GB de memoria para a JVM do JMeter</li>
</ol>

## Melhore o desempenho dos scripts utilizando estas técnicas (Regras)

<ol>
  <li>Use o modo CLI (jmeter -n -t test.jmx -l test.jtl).</li>
  <li>Use o mínimo de Listeners possível, se estiver usando o sinalizador -l na linha de comando, todos os Listeners podem ser excluídos ou desabilitados.</li>
  <li>Não use os ouvintes "View Results Tree" ou "View Results in Table" durante o teste de carga, use-os apenas durante a fase de script para depurar seus scripts.</li>
  <li>Em vez de usar muitos amostradores semelhantes, use o mesmo amostrador em um loop e use variáveis (Conjunto de dados CSV) para variar a amostra. [O controlador de inclusão não ajuda aqui, pois adiciona todos os elementos de teste do arquivo ao plano de teste.]</li>
  <li>Não use o modo funcional (Functional Mode).</li>
  <li>Use a saída CSV em vez de XML.</li>
  <li>Salve apenas os dados de que você precisa.</li>
  <li>Use o mínimo possível de Assertivas (Assertions).</li>
  <li>Use a linguagem de script de melhor desempenho (consulte a seção JSR223 - Groovy as language, compilation caching enabled).</li>
</ol>

## Refs

- https://jmeter.apache.org/usermanual/best-practices.html
- https://jmeter.apache.org/usermanual/jmeter_distributed_testing_step_by_step.html


## JMeter - jmeter.properties Results Config

```properties
#---------------------------------------------------------------------------
# Results file configuration
#---------------------------------------------------------------------------

# This section helps determine how result data will be saved.
# The commented out values are the defaults.

# legitimate values: xml, csv, db.  Only xml and csv are currently supported.
jmeter.save.saveservice.output_format=csv

# The below properties are true when field should be saved; false otherwise
#
# assertion_results_failure_message only affects CSV output
#jmeter.save.saveservice.assertion_results_failure_message=true
#
# legitimate values: none, first, all
#jmeter.save.saveservice.assertion_results=none
#
jmeter.save.saveservice.data_type=true
jmeter.save.saveservice.label=true
jmeter.save.saveservice.response_code=true
# response_data is not currently supported for CSV output
#jmeter.save.saveservice.response_data=false
# Save ResponseData for failed samples
#jmeter.save.saveservice.response_data.on_error=false
jmeter.save.saveservice.response_message=true
jmeter.save.saveservice.successful=true
jmeter.save.saveservice.thread_name=true
jmeter.save.saveservice.time=true
jmeter.save.saveservice.subresults=true
jmeter.save.saveservice.assertions=true
jmeter.save.saveservice.latency=true
# Only available with HttpClient4
jmeter.save.saveservice.connect_time=true
#jmeter.save.saveservice.samplerData=false
#jmeter.save.saveservice.responseHeaders=false
#jmeter.save.saveservice.requestHeaders=false
jmeter.save.saveservice.encoding=true
jmeter.save.saveservice.bytes=true
# Only available with HttpClient4
jmeter.save.saveservice.sent_bytes=true
jmeter.save.saveservice.url=true
#jmeter.save.saveservice.filename=false
jmeter.save.saveservice.hostname=true
jmeter.save.saveservice.thread_counts=true
jmeter.save.saveservice.sample_count=true
jmeter.save.saveservice.idle_time=true

# Timestamp format - this only affects CSV output files
# legitimate values: none, ms, or a format suitable for SimpleDateFormat
#jmeter.save.saveservice.timestamp_format=ms
#jmeter.save.saveservice.timestamp_format=yyyy/MM/dd HH:mm:ss.SSS

# For use with Comma-separated value (CSV) files or other formats
# where the fields' values are separated by specified delimiters.
# Default:
#jmeter.save.saveservice.default_delimiter=,
# For TAB, one can use:
#jmeter.save.saveservice.default_delimiter=\t

# Only applies to CSV format files:
# Print field names as first line in CSV
#jmeter.save.saveservice.print_field_names=true

# Optional list of JMeter variable names whose values are to be saved in the result data files.
# Use commas to separate the names. For example:
#sample_variables=SESSION_ID,REFERENCE
# N.B. The current implementation saves the values in XML as attributes,
# so the names must be valid XML names.
# By default JMeter sends the variable to all servers
# to ensure that the correct data is available at the client.

# Optional XML processing instruction for line 2 of the file:
# Example:
#jmeter.save.saveservice.xml_pi=<?xml-stylesheet type="text/xsl" href="../extras/jmeter-results-detail-report.xsl"?>
# Default value:
#jmeter.save.saveservice.xml_pi=

# Prefix used to identify filenames that are relative to the current base
#jmeter.save.saveservice.base_prefix=~/

# AutoFlush on each line written in XML or CSV output
# Setting this to true will result in less test results data loss in case of Crash
# but with impact on performances, particularly for intensive tests (low or no pauses)
# Since JMeter 2.10, this is false by default
#jmeter.save.saveservice.autoflush=false
```


# Configuracao de Memória RAM

- jmeter.bat (line 148)
 
```sh
set HEAP=-Xms16g -Xmx24g -XX:MaxMetaspaceSize=2048m

if not defined HEAP (
    rem See the unix startup file for the rationale of the following parameters,
    rem including some tuning recommendations
    set HEAP=-Xms16g -Xmx24g -XX:MaxMetaspaceSize=2048m
)
```

- jmeter.sh (line 32)

```sh
JVM_ARGS="-server -d64 -Xms16g -Xmx24g -XX:NewSize=512m -XX:MaxNewSize=512m -XX:+UseConcMarkSweepGC -XX:+DisableExplicitGC"
```
