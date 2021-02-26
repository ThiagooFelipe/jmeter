# JMeter Tips

## Refs


## Gerar resultados em HTML Reports (APDEX)

jmeter -g <log file> -o <Path to output folder>
  
## Executar em linha de comando

## Melhore o desempenho dos scripts utilizando estas técnicas (Regras)

<ol>
  <li>Use CLI mode: jmeter -n -t test.jmx -l test.jtl</li>
  <li>Use as few Listeners as possible; if using the -l flag as above they can all be deleted or disabled.</li>
  <li>Don't use "View Results Tree" or "View Results in Table" listeners during the load test, use them only during scripting phase to debug your scripts.</li>
  <li>Rather than using lots of similar samplers, use the same sampler in a loop, and use variables (CSV Data Set) to vary the sample. [The Include Controller does not help here, as it adds all the test elements in the file to the test plan.]</li>
  <li>Don't use functional mode</li>
  <li>Use CSV output rather than XML</li>
  <li>Only save the data that you need</li>
  <li>Use as few Assertions as possible</li>
  <li>Use the most performing scripting language (see JSR223 section)</li>
</ol>
