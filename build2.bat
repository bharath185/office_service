@echo off
set JAVA_HOME=C:\Program Files\Java\jdk-17
echo Using JAVA_HOME=%JAVA_HOME%
if not exist "%JAVA_HOME%\bin\java.exe" (
    echo ERROR: java.exe not found at %JAVA_HOME%\bin\java.exe
    pause
    exit /b 1
)
cd /d C:\Users\rim0972\Documents\office_web\java
call mvnw.cmd clean install -DskipTests
pause
