O teste do Seguro Garantia demonstrou que a aplicação possui estabilidade em todas as baterias executadas;

O tempo de processamento do Seguro Garantia com todos os cenários foi de até 296 ms (Percentil 95%) com 40 Threads;
O tempo de processamento do Seguro Garantia com todos os cenários foi de até 695 ms (Percentil 95%) com 100 Threads;
O processamento do Seguro Garantia com somente o cenário "1.1 - POST - APOLICE" foi de até de 64 ms (Percentil 95%) com 40 Threads e 100 Threads demonstrando estabilidade em diferentes cargas;

Avaliando a volumetria do log das aplicações testadas (maior que 5GB), identificamos que a verbosidade das aplicações está alta. Recomendamos diminuir a verbosidade dos logs para aumentar a escala atual da vazão das aplicações e reduzir o consumo dos armazenamentos secundários.

O teste do Resseguro falhou, uma vez que o cenário da aplicação possui restrições na massa automatizada utilizada;





O gráfico em azul demonstra a vazão agregada a cada 10 segundos, para evidenciar a escala da vazão duranta a injeção de carga realizada;

O gráfico em verde demonstra a vazão agregada a cada 10 segundos, para evidenciar o tempo médio duranta a injeção de carga realizada;

O gráfico em vermelho demonstra o percentual de erros agregado a cada 10 segundos, para evidenciar a taxa de erros durante a injeção de carga realizada;

O gráfico em amarelo demonstra o tempo de resposta utilizando Estatística Descritiva com a agregação a cada 10 segundos, para evidenciar o tempo de processamento da aplicação;
