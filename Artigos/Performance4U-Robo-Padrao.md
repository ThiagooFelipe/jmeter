# Performance4U - Requisitos Primordiais que o Robô deve Conter

## Objetivo

- Este documento visa ilustrar como deve ser realizada a configuração do robô (arquivo jmx) automatizado utilizando a ferramenta JMeter para que seja possível aplicar testes de performance usando a solução do Performance4U com maior êxito.

- A configuração apresentada neste documento é imprescindível, pois garante que seus robôs estejam dentro da padronização necessária para execução dos testes e geração dos resultados.

## Requisitos

- Os requisitos obrigatórios no robô são:
    1. Aggregate Report Listener
    2. Thread Group
    3. Parâmetros no Thread Group e Aggregate Report
    4. Configuração do Aggregate Report Listener Sample Result Save Configuration

:warning: O ***Aggregate Report Listener Sample Result Save Configuration*** deve conter uma configuração específica para não interferir na maquina de cálculo do Performance4U.

- Ao incluir os requitos, o robô deve ficar igual ao da figura apresentada a seguir.

![Simple Arch](https://github.com/jeancbezerra/jmeter/blob/0fc9ea2102f49d6aa4ac221a6276b34e223e93cc/Artigos/img/teste-plan-elements.png?raw=true)

- Estes elementos são primordiais para que o robô atenda as configurações necessárias do Performance4U.

### Como Incluir O Aggregate Report Listener e Thread Group?

#### Thread Group

- Realize os passos a seguir para incluir o elemento ***Thread Group*** no seu plano de teste:

    1. Botão direito em *Test Plan*
    2. Escolha a opção *Add*
    3. Escolha a opção  *Thread Group*

![Simple Arch](https://github.com/jeancbezerra/jmeter/blob/0fc9ea2102f49d6aa4ac221a6276b34e223e93cc/Artigos/img/how-to-add-thread-group.png?raw=true)
´
#### Aggregate Report Listener

- Realize os passos a seguir para incluir o ***Aggragate Report Listener*** no seu plano de teste:

    1. Botão diretio em *Test Plan*
    2. Escolha a opção *Add*
    3. Escolha a opção *Listener*
    4. Escolha a opção *Aggregate Report*

![Simple Arch](https://github.com/jeancbezerra/jmeter/blob/0fc9ea2102f49d6aa4ac221a6276b34e223e93cc/Artigos/img/thread-group-parameters.png?raw=true)

### Parâmetros Obrigatórios

- Os parâmetros a serem incluídos no Thread Group e Aggregate Report devem seguir a mesma nomenclatura disponibilizada na tabela a seguir:

    |Thread Properties   	  	| Parameter / Value  		| Type			| Required				|
    |---	                |---	                |---			|---					|
    | Number of Threads 	| ${__P(threads,1)}	| Integer		| Yes					|
    | Ramp-Up 		| ${__P(rampup,1)}	| Integer		| Yes					|
    | Duration		| ${__P(duration,1)}	| Integer (Seconds)	| Yes					|
    | Startup delay		| ${__P(startup,1)}	| Integer (Seconds)	| Yes					|
    | Aggregate Report      | ${__P(aggregate)}	| String		| Yes					|

- Qualquer erro de nomenclatura ou inclusão de parâmetro errado impactará na execução do teste de performance.

:warning: **Garanta que não contenha espaçamento antes ou após o parâmetro ao realizar a incluisão no robô**

#### Thread Group

- No Thread Group, incluir os parâmetros da mesma forma que apresentado na figura a seguir:

![Simple Arch](https://github.com/jeancbezerra/jmeter/blob/0fc9ea2102f49d6aa4ac221a6276b34e223e93cc/Artigos/img/thread-group-parameters.png?raw=true)

#### Aggregate Report Listener

- No Aggregate Reporto será necessário a inclusão do parâmetro: ***${__P(aggregate)}*** e esta configuração deve ser feita da mesma forma que apresentado na figura a seguir:

![Simple Arch](https://github.com/jeancbezerra/jmeter/blob/0fc9ea2102f49d6aa4ac221a6276b34e223e93cc/Artigos/img/aggregate-report-parameters.png?raw=true)

##### Aggregate Report Listener Sample Result Save Configuration

- É de extrema importancia que as configurações do Sample Result Save Configuration siga o template apresentado na figura a seguir para que não impacte na maquina de cálculo (responsável pelo resultado final do teste).

![Simple Arch](https://github.com/jeancbezerra/jmeter/blob/0fc9ea2102f49d6aa4ac221a6276b34e223e93cc/Artigos/img/aggregate-sample-result-config.png?raw=true)