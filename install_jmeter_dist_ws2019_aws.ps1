# Author: Jean Carlos Bezerra Macena da Silva
# Version: 1.0.0-RELEASE
# Objective: Prepare env to dist test with JMeter 5.4.1 and Java 11 LTS (AdoptOpenJDK)
# Date: 14/09/2021
# How to use:
# Open PowerShell
# Exec: wget https://raw.githubusercontent.com/jeancbezerra/jmeter/master/install_jmeter_dist_ws2019_aws.ps1 -OutFile install_jmeter_dist_ws2019_aws.ps1
# Exec: ./install_jmeter_dist_ws2019_aws.ps1

New-Item -Path C:\BOTS\OUTPUTS\ -ItemType directory -Force
New-Item -Path C:\YAMAN\ -ItemType directory -Force

cd C:\YAMAN\

wget https://yaman-apm-static-files.s3.sa-east-1.amazonaws.com/apache-jmeter-5.4.1.zip -OutFile apache-jmeter-5.4.1.zip
wget https://yaman-apm-static-files.s3.sa-east-1.amazonaws.com/OpenJDK11U-jdk_x64_windows_hotspot_11.0.12_7.msi -OutFile OpenJDK11U-jdk_x64_windows_hotspot_11.0.12_7.msi
wget https://yaman-apm-static-files.s3.sa-east-1.amazonaws.com/MicrosoftEdgeEnterpriseX64.msi -OutFile MicrosoftEdgeEnterpriseX64.msi
wget https://yaman-apm-static-files.s3.sa-east-1.amazonaws.com/npp.8.1.4.Installer.x64.exe -OutFile npp.8.1.4.Installer.x64.exe
wget https://yaman-apm-static-files.s3.sa-east-1.amazonaws.com/Git-2.33.0.2-64-bit.exe -OutFile Git-2.33.0.2-64-bit.exe
wget https://yaman-apm-static-files.s3.sa-east-1.amazonaws.com/Postman+Agent-win64-0.3.9-Setup.exe -OutFile Postman+Agent-win64-0.3.9-Setup.exe

Expand-Archive -Path C:\YAMAN\apache-jmeter-5.4.1.zip -DestinationPath C:\YAMAN\
Start-Process C:\YAMAN\OpenJDK11U-jdk_x64_windows_hotspot_11.0.12_7.msi -ArgumentList "/quiet /passive"
Start-Process C:\YAMAN\MicrosoftEdgeEnterpriseX64.msi -ArgumentList "/quiet /passive"
Start-Process C:\YAMAN\npp.8.1.4.Installer.x64.exe -ArgumentList "/quiet /passive"
Start-Process C:\YAMAN\Git-2.33.0.2-64-bit.exe -ArgumentList "/quiet /passive"
Start-Process C:\YAMAN\Postman+Agent-win64-0.3.9-Setup.exe -ArgumentList "/quiet /passive"

$Env:JAVA_HOME='C:\Program Files\Eclipse Foundation\jdk-11.0.12.7-hotspot'
$Env:JMETER_HOME='C:\YAMAN\apache-jmeter-5.4.1'

[Environment]::SetEnvironmentVariable("JAVA_HOME","C:\Program Files\Eclipse Foundation\jdk-11.0.12.7-hotspot","Machine")
[Environment]::SetEnvironmentVariable("JMETER_HOME","C:\YAMAN\apache-jmeter-5.4.1","Machine")

$path = [Environment]::GetEnvironmentVariable('Path', 'Machine')
$newpath = $path + ";" + $Env:JAVA_HOME + "\bin" + ";" + $Env:JMETER_HOME + "\bin"
[Environment]::SetEnvironmentVariable("Path", $newpath, 'Machine')


Set-NetFirewallProfile -All -Enabled True
New-NetFirewallRule -DisplayName 'JMETER-PORT-INBOUND' -Profile @('Domain','Private','Public') -Direction Inbound -Action Allow -Protocol TCP -LocalPort @('4000')
