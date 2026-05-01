@echo off
set JAVA_HOME=C:\Program Files\Java\jdk-17
set PATH=%JAVA_HOME%;%PATH%
cd /d C:\Users\rim0972\Documents\office_web\java
call mvnw.cmd clean install -DskipTests
pause
