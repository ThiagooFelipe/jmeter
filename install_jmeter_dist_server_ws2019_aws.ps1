# Author: Jean Carlos Bezerra Macena da Silva
# Version: 1.0.0-RELEASE
# Objective: Prepare env to dist test with JMeter 5.4.1 and Java 11 LTS (AdoptOpenJDK)
# Date: 14/09/2021
# How to use:
# Open PowerShell
# Exec: wget https://raw.githubusercontent.com/jeancbezerra/jmeter/master/install_jmeter_dist_server_ws2019_aws.ps1 -OutFile install_jmeter_dist_server_ws2019_aws.ps1
# Exec: ./install_jmeter_dist_server_ws2019_aws.ps1

New-Item -Path C:\BOTS\OUTPUTS\ -ItemType directory -Force
New-Item -Path C:\yaman-server\ -ItemType directory -Force

cd C:\yaman-server\

wget https://yaman-apm-static-files.s3.sa-east-1.amazonaws.com/apache-jmeter-5.4.1.zip -OutFile C:\yaman-server\apache-jmeter-5.4.1.zip
Expand-Archive -Path C:\yaman-server\apache-jmeter-5.4.1.zip -DestinationPath C:\yaman-server\

$Env:JAVA_HOME='C:\Program Files\Eclipse Foundation\jdk-11.0.12.7-hotspot'
$Env:JMETER_HOME='C:\yaman-server\apache-jmeter-5.4.1'

[Environment]::SetEnvironmentVariable("JAVA_HOME","C:\Program Files\Eclipse Foundation\jdk-11.0.12.7-hotspot","Machine")
[Environment]::SetEnvironmentVariable("JMETER_HOME","C:\YAMAN\apache-jmeter-5.4.1","Machine")

$path = [Environment]::GetEnvironmentVariable('Path', 'Machine')
$newpath = $path + ";" + $Env:JAVA_HOME + "\bin" + ";" + $Env:JMETER_HOME + "\bin"
[Environment]::SetEnvironmentVariable("Path", $newpath, 'Machine')


Set-NetFirewallProfile -All -Enabled True
New-NetFirewallRule -DisplayName 'JMETER-PORT-INBOUND' -Profile @('Domain','Private','Public') -Direction Inbound -Action Allow -Protocol TCP -LocalPort @('4000')
