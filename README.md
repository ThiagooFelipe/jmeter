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
  <li>Use a linguagem de script de melhor desempenho (consulte a seção JSR223).</li>
</ol>

## Refs

- https://jmeter.apache.org/usermanual/best-practices.html
- https://jmeter.apache.org/usermanual/jmeter_distributed_testing_step_by_step.html
