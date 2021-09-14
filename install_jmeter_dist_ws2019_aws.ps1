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
wget https://dlcdn.apache.org//jmeter/binaries/apache-jmeter-5.4.1.zip -OutFile apache-jmeter-5.4.1.zip
wget https://github.com/adoptium/temurin11-binaries/releases/download/jdk-11.0.12%2B7/OpenJDK11U-jdk_x64_windows_hotspot_11.0.12_7.msi -OutFile OpenJDK11U-jdk_x64_windows_hotspot_11.0.12_7.msi
wget https://msedge.sf.dl.delivery.mp.microsoft.com/filestreamingservice/files/4435014d-a92c-4272-8c83-fdce78f60ced/MicrosoftEdgeEnterpriseX64.msi -OutFile MicrosoftEdgeEnterpriseX64.msi
wget https://github.com/notepad-plus-plus/notepad-plus-plus/releases/download/v8.1.4/npp.8.1.4.Installer.x64.exe -OutFile npp.8.1.4.Installer.x64.exe
wget https://github.com/git-for-windows/git/releases/download/v2.33.0.windows.2/Git-2.33.0.2-64-bit.exe -OutFile Git-2.33.0.2-64-bit.exe

Expand-Archive -Path C:\YAMAN\apache-jmeter-5.4.1.zip -DestinationPath C:\YAMAN\
Start-Process C:\YAMAN\OpenJDK11U-jdk_x64_windows_hotspot_11.0.12_7.msi -ArgumentList "/quiet /passive"
Start-Process C:\YAMAN\MicrosoftEdgeEnterpriseX64.msi -ArgumentList "/quiet /passive"
Start-Process C:\YAMAN\npp.8.1.4.Installer.x64.exe -ArgumentList "/quiet /passive"
Start-Process C:\YAMAN\Git-2.33.0.2-64-bit.exe -ArgumentList "/quiet /passive"

$Env:JAVA_HOME='C:\Program Files\Eclipse Foundation\jdk-11.0.12.7-hotspot'
$Env:JMETER_HOME='C:\YAMAN\apache-jmeter-5.4.1'

[Environment]::SetEnvironmentVariable("JAVA_HOME","C:\Program Files\Eclipse Foundation\jdk-11.0.12.7-hotspot","Machine")
[Environment]::SetEnvironmentVariable("JMETER_HOME","C:\YAMAN\apache-jmeter-5.4.1","Machine")

$path = [Environment]::GetEnvironmentVariable('Path', 'Machine')
$newpath = $path + ";" + $Env:JAVA_HOME + "\bin" + ";" + $Env:JMETER_HOME + "\bin"
[Environment]::SetEnvironmentVariable("Path", $newpath, 'Machine')


Set-NetFirewallProfile -All -Enabled True
New-NetFirewallRule -DisplayName 'JMETER-PORT-INBOUND' -Profile @('Domain','Private','Public') -Direction Inbound -Action Allow -Protocol TCP -LocalPort @('4000')
