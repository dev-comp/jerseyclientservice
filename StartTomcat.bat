@echo off
cd tomcat
SET JAVA_OPTS=-XX:MaxPermSize=150m -Xmx512m -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8787
call startup.bat 
