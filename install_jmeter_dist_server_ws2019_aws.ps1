# Author: Jean Carlos Bezerra Macena da Silva
# Version: 1.0.0-RELEASE
# Objective: Prepare env to dist test with JMeter 5.4.1 and Java 11 LTS (AdoptOpenJDK)
# Date: 14/09/2021
# How to use:
# Open PowerShell
# Exec: wget https://raw.githubusercontent.com/jeancbezerra/jmeter/master/install_jmeter_dist_server_ws2019_aws.ps1 -OutFile install_jmeter_dist_server_ws2019_aws.ps1
# Exec: ./install_jmeter_dist_server_ws2019_aws.ps1

cd C:\YAMAN\

Get-ChildItem -Path C:\YAMAN\apache-jmeter-5.4.1.zip -File -Recurse | Remove-Item -Verbose
Remove-Item -Path C:\YAMAN\apache-jmeter-5.4.1\ -Force

wget https://yaman-apm-static-files.s3.sa-east-1.amazonaws.com/apache-jmeter-5.4.1-server.zip -OutFile apache-jmeter-5.4.1-server.zip
#wget https://yaman-apm-static-files.s3.sa-east-1.amazonaws.com/apache-jmeter-5.4.1-server.zip -OutFile apache-jmeter-5.4.1-server-master.zip

Expand-Archive -Path C:\YAMAN\apache-jmeter-5.4.1-server.zip -DestinationPath C:\YAMAN\
