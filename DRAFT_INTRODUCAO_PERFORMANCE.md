# DRAFT Introducao a Performance

## Introducao

Nos ultimos anos as empresas que possuem produtos, solucoes e demais servicos digitais estao passando por um demanda, esta demanda nao é somente de novos clientes, 
mas de qualidade e confiabilidade em seus softwares online, todos os especialistas de T.I confirmam que a melhor estratégia é testar bem as novas solucoes e as solucoes que já 
estao em operacao no ambiente produtivo e que precisam de novas funcionalidades, adequacoes e demais melhorias que o negocio precisar para se manter competitivo no mercado.

Com essa necessidade clara, notamos que uma das melhores estratégias é garantir que os softwares tenham maior desempenho em momentos de grande utilizacao, além de se manter estavel
durante toda a janela produtiva. Nao podemos esquecer dos softwares que estao atras de outros softwares, que loucura não, sim, existem softwares conversando com outros softwares, 
mas nao se preocupe, existe um nome para isso e se chama interoperabilidade, este nome exotico é um atalho para explicar que um Software A envia ou solicita dados para o Software B.

Essas interoperabilidades são de longe o maior problema que uma empresa que busca melhorar seus servicos digitais possui, imagine um software desenvolvido em 2000 que precisa 
conversar com outro software de 2021, imaginou, espero que sim. Este cenario ocorre milhares de vezes em varios nichos de negocio e é classificado como integracao legada, o 
interessante da integracao legada é que varios softwares precisam se comunicar com sistemas que foram desenvolvidos a varios anos atras, mas ninguem verifica se a integracao 
é rápida ou até mesmo confiavel, esta informacao nao esta normalmente documentada e é por este motivo que voce precisa aprender alguns conceitos de performance, justamente para entender que é necessario documentar os objetivos e avaliar por meios de novos testes.

<hr />

O termo Performance é avaliado em termos de eficiência, de rendimento, de comprovacao, ou seja, para garantir que um software A tenha essas caracteristicas, precisamos realizar uma serie de testes que ajudem a comprovar estas necessidades. Além de realizar uma analise complexa de como nosso software foi desenvolvido e como ele é mantido em ambiente operacional mais conhecido como ambiente produtivo.

Para levantar qual nivel de performance o seu software precisa atingir, voce deve ter em mente qual o nivel de SLA (Acordo de nível de serviço), que prendente entregar a seu cliente final, este é o melhor indicador inicial que voce pode documentar. Quando queremos entregar muita performance, devemos explicar os motivos e em quais areas do software e seu ciclo de desenvolvimento vamos atuar mais para extrair desempenho, para ajudar a focar no que devemos priorizar por uma escala de prioridades conhecidas, voce deve avaliar esta lista:

<hr />

Antes de ir diretamente para a tão desejada Performance, voce deve entender que para obter Performance, temos que pensar em toda a jornada que um software teve que passar para ser desenvolvido, a cultura, os frameworks, as necessidades exigidas, o tamanho do projeto e os milhares de requisitos funcionais que a equipe que desenvolveu teve como trilha para entregar um software gerando e agregando valor ao negoio. Nem sempre notamos os detalhes de algo que nao foi construido, criado ou revisado por nós, mas precisamos aprofundar esse contexto para descobrir quais problemas encontraremos quando almejamos ter mais performance e demais beneficios com essa nossa nova jornada, separei estes tópicos com listas para que voce consiga avaliar se o software que voce deseja avaliar a performance realmente será possivel extrair tudo que pode ser extraido, e claro, voce nao se fruste com testes que só vao mostrar o que voce já imaginava.

#### Experiencia do usuario
- Funcionalidades de negocios que sao complexas demais (Processos longos e cheio de formularios complexos);
- Otimizacao do processo de remocao, inclusao;
- Garantir que processos em malha não estejam no mesmo contexto de um software online e publico;
- Evitar validacoes exessivas visuais ao cliente final, seu software deve ser inteligente (Possuir dominios de dados, pre-cadastros, maquinas de estado que armazenam de onde ele parou, etc);
- Evitar preenchimentos de dados excessivos, o processo deve ser inteligente e já conhecer o cliente, apenas realizar o que ele precisa e com confirmacoes rapidas;
- Simule seu software em redes moveis, esta pratica vai te trazer uma visao sintetica de problemas comuns que ocorrem em cenarios com baixa largura de banda;

#### Otimizacao de código fonte
- Garantir que o código fonte do software esteja em sua melhor versao (Sem bugs);
- Validar se os testes unitarios possuem coberturas completas do codigo fonte (Validacoes automaticas de cobertura em cada nova versao);
- Validar constantemente os testes funcionais, de integracao com outros softwares e de regressao para bugs já identificados;
- Garantir que as versoes estejam armazenadas de forma cronologica com um historico descritivo do que foi melhorado ou adicionado na versao corrente do software;


Existem varias formas de validar se um software possui performance, neste artigo voce verá alguns exemplos de como cada tipo de teste pode ajudar a validar o quao é performático o seu software.

## Tipos de testes de performance

## Metricas de performance

## Monitoramento de software

## Porque devo testar sempre?

## Qualidade VS Performance

## Performance VS Custos de Infraestrutura

## Mais clientes, mais Servidores?
