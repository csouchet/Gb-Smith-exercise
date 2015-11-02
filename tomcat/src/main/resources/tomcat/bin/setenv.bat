@echo on

rem Set some JVM system properties required

rem Pass the JVM system properties to Tomcat JVM using CATALINA_OPTS variable
set CATALINA_OPTS=%CATALINA_OPTS% -Dfile.encoding=UTF-8 -Xshare:auto -Xms1024m -Xmx1024m -XX:MaxPermSize=256m -XX:+HeapDumpOnOutOfMemoryError

set CATALINA_PID=%CATALINA_BASE%\catalina.pid