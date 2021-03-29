# Introdução a Performance de Software


Autor                               | Revisão              | Data                      |
----------------------------------- | ---------------------|---------------------------|
Jean Carlos Bezerra Macena da Silva | 1.0                  | 23/03/2021                |
Jean Carlos Bezerra Macena da Silva | 1.1                  | 26/03/2021                |

## Introducao

Nos últimos anos as empresas que possuem produtos, soluções e demais serviços digitais estão passando por uma demanda que não é somente de novos clientes, mas de qualidade e confiabilidade em seus softwares online. Todos os especialistas de T.I confirmam que a melhor estratégia é testar bem novas soluções, soluções que já estão em operação no ambiente produtivo e que precisam de novas funcionalidades, adequações e demais melhorias que o negocio precisar para se manter competitivo no mercado.

Com essa necessidade clara, notamos que uma das melhores estratégias é garantir que os softwares tenham maior desempenho em momentos de grande utilização, além de se manter estável durante toda a janela produtiva. Não podemos esquecer dos softwares que estão atrás de outros softwares, que loucura não, sim, existem softwares conversando com outros softwares, mas não se preocupe, existe um nome para isso e se chama interoperabilidade. Este nome exótico é um atalho para explicar que um Software A envia ou solicita dados para o Software B.

Essas interoperabilidades são de longe o maior problema que uma empresa que busca melhorar seus serviços digitais possui. Imagine um software desenvolvido em 2000 que precisa conversar com outro software de 2021, imaginou, espero que sim. Este cenário ocorre milhares de vezes em vários nichos de negocio e é classificado como integração legada. O interessante da integração legada é que vários softwares precisam se comunicar com sistemas que foram desenvolvidos a vários anos atrás mas ninguém verifica se a integração é rápida ou até mesmo confiável e esta informação não esta normalmente documentada. Sendo assim, é por este motivo que você precisa aprender alguns conceitos de performance, justamente para entender que é necessário documentar os objetivos e avaliar por meios de novos testes.

<hr />

O termo Performance é avaliado em termos de eficiência, de rendimento e de comprovação, ou seja, para garantir que um software A tenha essas características, precisamos realizar uma serie de testes que ajudem a comprovar estas necessidades. Além disso, é necessário realizar uma analise complexa de como nosso software foi desenvolvido e como ele é mantido em ambiente operacional mais conhecido como ambiente produtivo.

Para levantar qual nível de performance o seu software precisa atingir, você deve ter em mente qual o nível de SLA (Acordo de nível de serviço) que pretende entregar ao seu cliente final, pois é o melhor indicador inicial que você pode documentar. Quando queremos entregar muita performance, devemos explicar os motivos e em quais áreas do software e seu ciclo de desenvolvimento vamos atuar mais para extrair desempenho. Para ajudar a focar no que devemos priorizar por uma escala de prioridades conhecidas, você deve avaliar esta lista:

<hr />

Antes de ir diretamente para a tão desejada Performance, você deve entender que para obter Performance, temos que pensar em toda a jornada que um software teve que passar para ser desenvolvido, a cultura, os frameworks, as necessidades exigidas, o tamanho do projeto e os milhares de requisitos funcionais que a equipe que desenvolveu teve como trilha para entregar um software gerando e agregando valor ao negocio. Nem sempre notamos os detalhes de algo que não foi construído, criado ou revisado por nós, mas precisamos aprofundar esse contexto para descobrir quais problemas encontraremos quando almejamos ter mais performance e demais benefícios com essa nossa nova jornada, separei estes tópicos com listas para que você consiga avaliar se o software que você deseja avaliar a performance realmente será possível extrair tudo que pode ser extraído, e claro, você não se frustre com testes que só vão mostrar o que você já imaginava.

#### Experiência do usuário
- Funcionalidades de negócios que são complexas demais (Processos longos e cheio de formulários complexos);
- Otimização do processo de remoção, inclusão;
- Garantir que processos em malha não estejam no mesmo contexto de um software online e publico;
- Evitar validações excessivas visuais ao cliente final, seu software deve ser inteligente (Possuir domínios de dados, pré-cadastros, máquinas de estado que armazenam de onde ele parou, etc);
- Evitar preenchimentos de dados excessivos, o processo deve ser inteligente e já conhecer o cliente, apenas realizar o que ele precisa e com confirmações rápidas;
- Simule seu software em redes moveis, esta pratica vai te trazer uma visão sintética de problemas comuns que ocorrem em cenários com baixa largura de banda;

#### Otimizacao de código fonte
- Garantir que o código fonte do software esteja em sua melhor versão (Sem bugs);
- Garantir que as versões estejam armazenadas de forma cronológica com um histórico descritivo do que foi melhorado ou adicionado na versão corrente do software;
- Validar se os testes unitários possuem coberturas completas do codigo fonte (Validações automáticas de cobertura em cada nova versão);
- Validar constantemente os testes funcionais, de integração com outros softwares e de regressão para bugs de incidentes já identificados e mapeados;

Existem formas de validar se um software possui performance, neste artigo você verá alguns exemplos de como cada tipo de teste pode ajudar a validar o quão é performático o seu software.

## Tipos de testes de performance

Existem diferentes tipos de teste para cada necessidade de comprovacao, e nao devemos misturar os objetivos de cada um, mesmo que se pareçam. Separei os 6 mais utilizados e um que é garantia de execucao, mas que é pouco lembrado, por este motivo, vamos falar de 7.

### 1 - Load Test

#### Descricao:

O teste de carga determinará se o sistema precisa ser ajustado ou a modificação de hardware e software é necessária para melhorar o desempenho.

#### Objetivos: 

- Tempo de resposta para cada transação;
- Desempenho dos componentes do sistema sob várias cargas planejadas;
- Desempenho dos componentes do banco de dados sob diferentes cargas;
- Atraso de rede entre o cliente e o servidor (Latência);
- Problemas de design de software;
- Problemas de configuração do servidor, como servidor Web, servidor de aplicativos, servidor de banco de dados, etc;
- Problemas de limitação de hardware, como maximização da CPU, limitações de memória, gargalo de rede, etc.

### 2 - Endurence Test

#### Descricao:

#### Objetivos: 

- O objetivo principal do teste de resistência é verificar se há vazamentos de memória;
- Para descobrir como o sistema funciona sob uso contínuo;
- Para garantir que após um longo período, o tempo de resposta do sistema permanecerá o mesmo ou melhor do que o início do teste;
- Para determinar o número de usuários e / ou transações, um determinado sistema oferecerá suporte e atenderá às metas de desempenho;
- Para gerenciar as cargas futuras, precisamos entender quantos recursos adicionais (como capacidade do processador, capacidade do disco, uso da memória ou largura de banda da rede) são necessários para dar suporte ao uso no futuro;
- O teste de resistência geralmente é feito sobrecarregando o sistema ou reduzindo certos recursos do sistema e avaliando as consequências;
- É executado para garantir que não ocorram defeitos ou vazamentos de memória após o que é considerado um período de uso relativamente "normal";

### 3 - Volume Test

### 4 - Spike Test

### 5 - Scalability Test

### 6 - Stress Test

### 7 - Smoke Test

## Metricas de performance

## Monitoramento de software

## Porque devo testar sempre?

## Qualidade VS Performance

## Performance VS Custos de Infraestrutura

## Mais clientes, mais Servidores?

Ao longo de minha experiência em desenvolvimento de software e de engenharia de software noto que essas duas perguntas não são feitas antes de uma campanha estratégica, de um projeto focado em substituir o atual sistema para um novo sistema/plataforma ou até mesmo durante o ciclo de vida de qualquer software. Você nota que na realidade essas duas questões são pouco lembradas e que no final de tudo são a solução para resolver qualquer problema durante a operação, o que eu quero debater é justamente o porque os analistas, desenvolvedores, engenheiros esquecem de lembrar que o processo de escalada do negocio faz parte do processo de evolução e de melhoria continua de qualquer software, não importa o tamanho do problema que o sistema resolva, sempre que falamos em atender mais clientes a primeira coisa que se passa na cabeça de qualquer um é, irei implantar mais quantos servidores para atender esses novos clientes?

Disponibilizar mais servidores não traz a certeza de atender mais clientes, traz um custo maior da infraestrutura, maior consumo de banda de rede, maior consumo de conexões com o banco de dados e por ai vamos adicionando mais e mais pontos de integração.

A certeza que devemos ter é que o custo será mais alto para manter a aplicação online, e esse custo será pago por quem?
Lembre-se que o negocio é o principal objetivo da tecnologia e que os softwares são recursos estratégicos e pilares de uma empresa mais inteligente, use com o objetivo principal em mente, evite aglomerar mais servidores que não estão sendo utilizados de forma ativa a todo tempo. Se você tiver servidores em seu parque que não são utilizados de fato, eles devem ser realocados para outros objetivos coorporativos e não alocados para expansão de algo que não está contabilizado, documentado, evidenciado da real necessidade deles no ambiente onde se encontram.

Nas metas de projeção estratégica de uma companhia que possui software em Cloud, é comum você notar que a quantidade de servidores crescem conforme a demanda do negocio, esse escalonamento estratégico é projetado com números reais de consumo retiradas do dia-a-dia e não com a projeção esperada com base em disponibilizar uma folga para o sistema não cair, pois a quantidade de servidores deve ser proporcional ao que o negocio (business) deve suportar e não com algo que ele deve superar sem a real necessidade de atender, desta forma controlamos o consumo demasiados de recurso capital para algo que não possui nenhuma projeção de crescimento.

De forma resumida o que estou comentando até o momento, é que não se deve ter mais do que você precisa para operar.

Claro que existem estratégias de suporte e estratégias de expansão comercial aliadas com o bom e velho marketing, seja qual for a campanha de marketing, a melhor forma de verificar qual capacidade da sua plataforma atual é medir, medir e medir. O principal indicador métrico de desempenho de uma plataforma online é o indicador de vazão, note que a vazão pode ser uma característica mais generalizada devido aos padrões de vazão que existem no sistema de medição, quero dizer, TPS (Transaction Per Second), RPS (Requests Per Second), QPS (Querys Per Second), EPS (Errors Per Second), HPS (Hits Per Second), esses modelos de exibição da vazão podem ser adquiridos por varias ferramentas, são tantas que citar uma em especifico abre um leque gigantesco de debate para afirmar qual é a melhor, por este motivo, não irei comentar qual é a melhor ou qual deve ser utilizada para extrair tais KPIs.

O mais interessante desses indicadores de resiliência é que todos devem ser utilizados ao mesmo tempo, mas o mais impactante é o indicador EPS (Errors Per Second), este indicador é incrivelmente fácil de entender, pois é de conhecimento global que algo que gera muito erro não é bom, mas será que você sabe quantos erros por segundo, minuto, hora e dia sua aplicação produtiva gera? essa questão é extremamente importante antes de ir para os outros indicadores, sem a resposta dela você pode se deparar com indicadores confusos e imprecisos, pois os erros aumentam a vazão da aplicação e geram um resultado considerado falso positivo nos demais indicadores. E bota falso nisso, pois quando temos muitos erros, temos os indicadores TPS (Transactions Per Second), RPS (Requests Per Second), HPS (Hits Per Second) e os demais prejudicados, por este mero detalhe técnico é importante avaliar constantemente a saúde do código da aplicação e as boas praticas de desenvolvimento de cada componente que o software utiliza.

Uma boa ferramenta para acompanhar a qualidade, confiabilidade e demais indicadores de código é o SonarQube - Code Quality and Security | SonarQube.

O objetivo é evidenciar um problema comum na comunidade de desenvolvimento de software e que se arrasta para a operação de softwares, não devemos criar uma solução estratégica de negocio que precisa de milhares de servidores para funcionar, podemos criar algo leve e corretamente dimensionado, com testes funcionais para evitar erros, testes integrados que de fato testam as integrações de recursos próximos da aplicação e por fim o melhor teste que podemos executar nas aplicações, o teste não funcional, para os íntimos pode chamar de teste de performance.

Resumindo as etapas para ter um sistema escalável é estudar e manter atualizado o conhecimento sobre técnicas de auto-scalling, resiliência e confiabilidade no processo de entrega do software que você desenvolve, mantem e coordena. Desta forma, você terá a visão ampliada que quero prover neste artigo.
