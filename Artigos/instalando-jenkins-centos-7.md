# Instalando o Jenkins no CentOS 7

## Dicas

- O Jenkins utiliza a porta 8080;
- O Jenkins utiliza Java para rodar;
- O Jenkins tem uma tela de configuracoes quando e acessado pela primeira vez que deve ser utilizada para configurar o acesso de administrador;

## Atualize o Sistema Operacional e instale alguns pacotes necessarios

```sh
sudo yum -y update
sudo yum -y install wget
sudo yum -y install vim
sudo yum -y install git
```

## Instale o Java e configure o JDK no `alternatives`, selecione a versao correspondente ao que o jenkins precisa, no caso a versao 11 do Java

```sh
sudo yum -y install java-11-openjdk java-11-openjdk-devel
sudo alternatives --config java
```

```sh
cd /usr/lib/jvm/ && ls -lha jre-*
```

## Instale o Jenkins pelo sistema de pacotes do Linux

Adicione o repositorio do Jenkins no arquivo de repositorios do YUM, para que o mesmo procure a ultima versão compativel com seu sistema operacional.

```sh
sudo wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat-stable/jenkins.repo
sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io.key
```

```sh
sudo tee /etc/yum.repos.d/epelfordaemonize.repo <<EOF
[daemonize]
baseurl=https://download-ib01.fedoraproject.org/pub/epel/7/x86_64/
gpgcheck=no
enabled=yes
EOF
```

```sh
yum install -y daemonize
```

Realize a instalacao e a confirmacao.

```sh
sudo yum -y install jenkins
```

## Habilite o Jenkins para subir automaticamente quando a maquina for reiniciada, com essa configuracao, nao vamos precisar iniciar manualmente o Jenkins quando o Linux for iniciado

```sh
sudo systemctl enable jenkins
sudo systemctl is-enabled jenkins
```

### Outros comandos do systemctl podem ajudar caso voce precise reiniciar o Jenkins ou algo do tipo

```sh
sudo systemctl stop jenkins
sudo systemctl start jenkins
sudo systemctl restart jenkins
sudo systemctl status jenkins
```

## Configure as portas no firewall do linux para que voce possa acessar no seu navegador

```sh
sudo firewall-cmd --permanent --zone=public --add-port=80/tcp
sudo firewall-cmd --permanent --zone=public --add-port=80/udp
sudo firewall-cmd --permanent --zone=public --add-port=8080/tcp
sudo firewall-cmd --permanent --zone=public --add-port=8080/udp
sudo firewall-cmd --permanent --zone=public --add-port=7777/tcp
sudo firewall-cmd --permanent --zone=public --add-port=7777/udp
```

### Ative as regras do firewall, reiniciando ele

```sh
sudo firewall-cmd --reload
```

## Acesse seu Jenkins pela URL abaixo

### Use o comando para verificar qual seu IP e entao acessar utilizando a porta 8080

```sh
ip a
```

### Agora use o IP que seu servidor utiliza para completar esse link

```sh
http://<IP_SERVIDOR_JENKINS>:8080/
```

## Para completar o assistente de configuracoes, utilize este comando para colocar a senha que ele pede

```sh
cat /var/lib/jenkins/secrets/initialAdminPassword
```

## Siga o passo a passo, seu jenkins sera configurado e estara pronto para uso
