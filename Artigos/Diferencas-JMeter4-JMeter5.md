# Diferenças entre JMeter 4.0 e JMeter 5.4.1

## 1. Duplicação de Parâmetros Enviados

### JMeter 5.4.1

- Ao realizar uma requisição utilizando o método HTTP DELETE e com parâmetros no JMeter 5.4.1 teremos o comportamento de duplicação de parâmetros, conforme ilustrado nas figuras a seguir:

![Simple Arch](https://github.com/jeancbezerra/jmeter/blob/18b368e6faec7525fd3249101620cbb5468e5d71/Artigos/img/delete-http-and-1parameter-jmeter5.png?raw=true)

![Simple Arch](https://github.com/jeancbezerra/jmeter/blob/18b368e6faec7525fd3249101620cbb5468e5d71/Artigos/img/delete-http-and-1parameter-request-jmeter5.png?raw=true)

### JMeter 4.0

- No JMeter 4.0 este problema não foi apresentado durante os testes realizados e funcionou normalmente conforme ilustrado nas figuras a seguir:

![Simple Arch](https://github.com/jeancbezerra/jmeter/blob/18b368e6faec7525fd3249101620cbb5468e5d71/Artigos/img/delete-http-and-1parameter-jmeter4.png?raw=true)

![Simple Arch](https://github.com/jeancbezerra/jmeter/blob/18b368e6faec7525fd3249101620cbb5468e5d71/Artigos/img/delete-http-and-1parameter-request-jmeter4.png?raw=true)

### Solução para JMeter 5.4.1

- Para evitar que o problema do método HTTP DELETE ocorra no JMeter 5.4.1, basta incluir o parâmetro no path ao invés de configurá-lo em parameters conforme apresentado nas figuras:

![Simple Arch](https://github.com/jeancbezerra/jmeter/blob/18b368e6faec7525fd3249101620cbb5468e5d71/Artigos/img/delete-http-solucao-jmeter5.png?raw=true)

![Simple Arch](https://github.com/jeancbezerra/jmeter/blob/18b368e6faec7525fd3249101620cbb5468e5d71/Artigos/img/delete-http-response-solucao-jmeter5.png?raw=true)

## 2. Registro de Requisições de Redirecionamento no CSV

- Ao utilizar a configuração Save Sub Results do Aggregate Report Listener no JMeter 5.4.1, serão registradas as requisições de redirecionamento.
Essas requisições são geradas se a opção Follow Redirects em uma HTTP Request estiver selecionada.

![Simple Arch](https://github.com/jeancbezerra/jmeter/blob/18b368e6faec7525fd3249101620cbb5468e5d71/Artigos/img/follow-redirects-jmeter5.png?raw=true)

![Simple Arch](https://github.com/jeancbezerra/jmeter/blob/18b368e6faec7525fd3249101620cbb5468e5d71/Artigos/img/follow-redirects-jmeter4-jmeter5.png?raw=true)

- O JMeter 4.0 não apresenta o mesmo comportamento mesmo que ambas configurações Save Sub Results e Follow Redirects estejam selecionadas, conforme apresentado nas figuras a seguir:

![Simple Arch](https://github.com/jeancbezerra/jmeter/blob/18b368e6faec7525fd3249101620cbb5468e5d71/Artigos/img/follow-redirects-response-jmeter4-jmeter5.png?raw=true)

- A figuras 10 apresenta as diferenças entre os arquivos gerados por cada versão.

![Simple Arch](https://github.com/jeancbezerra/jmeter/blob/18b368e6faec7525fd3249101620cbb5468e5d71/Artigos/img/follow-redirects-response-arquivo-csv-jmeter4-jmeter5.png?raw=true)

### Solução para JMeter 5.4.1

1. Desativar o Save Sub Results no Aggregate Report Listener.
2. Desativar o Follow Redirects na HTTP Request.
3. Definir a configuração jmeter.save.saveservice.subresults=false no arquivo jmeter.properties que pode ser encontrado no diretório jmeter-version/bin.

</br>
OBS:
</br>
- Antes de aplicar as soluções apresentadas anteriormente deve-se avaliar como a remoção do registro das requisições redirecionadas impactam no resultado final, pois podem ser importantes para o cenário de teste.

- Faça essa avaliação a cada demanda.