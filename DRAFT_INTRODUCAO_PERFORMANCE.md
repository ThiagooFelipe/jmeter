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

O termo Performance é avaliado em termos de eficiência, de rendimento, de comprovacao, ou seja, para garantir que um software A tenha essas caracteristicas, precisamos realizar uma serie de testes que ajudem a comprovar estas necessidades.

Para levantar qual nivel de performance o seu software precisa atingir, voce deve ter em mente qual o nivel de SLA (Acordo de nível de serviço), que prendente entregar a seu cliente final, este é o melhor indicador inicial que voce pode documentar. Quando queremos entregar muita performance, devemos explicar os motivos e em quais areas vamos atuar mais para extrair desempenho, para ajudar a focar no que devemos priorizar por uma escala de prioridades conhecidas, voce deve avaliar esta lista:

#### Experiencia do usuario
- Funcionalidades de negocios que sao complexas demais (Processos longos e cheio de formularios complexos);
- Otimizacao do processo de remocao, inclusao;
- Garantir que processos em malha não estejam no mesmo contexto de um software online e publico;
- Evitar validacoes exessivas visuais ao cliente final, seu software deve ser inteligente (Possuir dominios de dados, pre-cadastros, maquinas de estado que armazenam de onde ele parou, etc);
- Evitar preenchimentos de dados excessivos, o processo deve ser inteligente e já conhecer o cliente, apenas realizar o que ele precisa e com confirmacoes rapidas;
- Simule seu software em redes moveis, esta pratica vai te trazer uma visao sintetica de problemas comuns que ocorrem em cenarios com baixa largura de banda;

#### Otimizacao de Código Fonte/Produto
- Garantir que o código fonte do software esteja em sua melhor versao (Sem bugs);
- Validar se os testes unitarios possuem coberturas completas do codigo fonte (Validacoes automaticas de cobertura em cada nova versao);
- Validar constantemente os testes funcionais, de integracao com outros softwares e de regressao para bugs já identificados;
- Garantir que as versoes estejam armazenadas de forma cronologica com um historico descritivo do que foi melhorado ou adicionado na versao corrente do software;


Existem varias formas de validar se um software possui performance, neste artigo voce verá alguns exemplos de como cada tipo de teste pode ajudar a validar o quao é performático o seu software.

### Tipos de Testes de Performance

### Metricas de Performance

### Qualidade VS Performance

### Monitoramento de Software

### Porque devo testar sempre?

### Performance VS Custos de Infraestrutura
