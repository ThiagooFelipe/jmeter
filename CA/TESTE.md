O teste do Seguro Garantia demonstrou que a aplicacao possui estabilidade em todas as baterias executadas;

O tempo de processamento do Seguro Garantia com todos os cenarios foi de até 296 ms (Percentil 95%) com 40 Threads;

O tempo de processamento do Seguro Garantia com todos os cenarios foi de até 695 ms (Percentil 95%) com 100 Threads;

Avaliando a volumetria do log das aplicacoes testadas (maior que 5GB), identificamos que a verbosidade das aplicacoes estao altas. Recomendamos diminuir
a verbosidade dos logs para aumentar a escala da vazao da aplicacao e reduzir o consumo dos armazenamentos secundarios.

O teste do resseguro falhou, uma vez que o cenario da aplicacao possui restricoes na massa automatizada utilizada;







O gráfico em azul demonstra a vazão agregada a cada 10 segundos, para evidenciar a escala da vazão duranta a injeção de carga realizada;

O gráfico em verde demonstra a vazão agregada a cada 10 segundos, para evidenciar o tempo médio duranta a injeção de carga realizada;

O gráfico em vermelho demonstra o percentual de erros agregado a cada 10 segundos, para evidenciar a taxa de erros durante a injeção de carga realizada;

O gráfico em amarelo demonstra o tempo de resposta utilizando Estatística Descritiva com a agregação a cada 10 segundos, para evidenciar o tempo de processamento da aplicação;
