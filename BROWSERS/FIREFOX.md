# Firefox Tips

## Proxy

- Digite o comando `about:preferences#advanced` para abrir as configurações  do navegador e configurar o proxy

## Desabilitar Capite Portal do Firefox (success.txt) nas gravacões Record Script

- Digite este comando na URL BOX do Firefox `about:config` e confirme o ponto de atencão que o navegador vai exibir
- Informe a configuracão `network.captive-portal-service.enabled` para pesquisar a propriedade e então mude de `true` para `false`

## Problema de Certificado Digital longo na gravação via Proxy do JMeter

- Digite este comando na URL BOX do Firefox `about:config` e confirme o ponto de atencão que o navegador vai exibir
- Informe a configuracão `security.tls.version.max` para pesquisar a propriedade e então mude de `4` para `0`

## Desabilitar o HSTS

- Digite este comando na URL BOX do Firefox `about:config` e confirme o ponto de atencão que o navegador vai exibir
- Informe a configuracão `security.mixed_content.block_display_content` para pesquisar a propriedade e então mude de `false` para `true`

## Problema com `**ensure browser is set to accept the JMeter proxy certificate**` nas respostas do FireFox

- Digite este comando na URL BOX do Firefox `about:config` e confirme o ponto de atencão que o navegador vai exibir
- Informe a configuracão `security.tls.version.fallback-limit` para pesquisar a propriedade e então mude de `4` para `3`


- Digite este comando na URL BOX do Firefox `about:config` e confirme o ponto de atencão que o navegador vai exibir
- Informe a configuracão `security.tls.version.max` para pesquisar a propriedade e então mude de `4` para `3`


- Digite este comando na URL BOX do Firefox `about:config` e confirme o ponto de atencão que o navegador vai exibir
- Informe a configuracão `hsts` para pesquisar a propriedade e então mude de `true` para `false`

- CRTL+H selecione o site com o clique direito do mouse e então selecione `Forget About This Site` para remover todos os caches e asssociados de segurança no padrão HSTS com este site
