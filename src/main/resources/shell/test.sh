#!/bin/sh

. "config.sh"
echo "hello:$CATALINA_OPTS"

JAVA_OPTS="-Dspring.profiles.active=prod \
-Dcom.sun.management.jmxremote=true \
-Dcom.sun.management.jmxremote.port=7777 \
-Dcom.sun.management.jmxremote.local.only=false \
-Dcom.sun.management.jmxremote.authenticate=false \
-Dcom.sun.management.jmxremote.ssl=false \
-Dfile.encoding=UTF-8 \
-server -Xms1024M -Xmx1024M -Xmn512M \
-XX:MetaspaceSize=256M -XX:MaxMetaspaceSize=512M -XX:MaxDirectMemorySize=341M \
-XX:+UseParNewGC \
-XX:+UseConcMarkSweepGC \
-XX:+TieredCompilation \
-XX:+PrintGCDetails \
-XX:+PrintGCDateStamps \
-XX:+PrintGCApplicationStoppedTime \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=/data/logs/recomm-front/oom.hprof \
-XX:ErrorFile=/data/logs/recomm-front/hs_err_pid_%p.log" \
-jar recomm-front-RELEASE.jar \
--spring.profiles.active=guangzhou \
--webank.logging.path=/data/logs/recomm-front &> /data/logs/recomm-front/front-all.log


