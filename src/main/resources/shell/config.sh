#!/bin/sh

echo 'config'

APP_NAME=ai-user
APP_BASE=`pwd`

#calculate memory
TOTAL_MEM=`free -m | grep Mem | awk '{print $2}'`
if [ ! -n "$TOTAL_MEM" ]; then
  echo "command free is not supported, set default TOTAL_MEM=2048"
  TOTAL_MEM=2048
fi

if [ $TOTAL_MEM -ge 15000 ]; then
    MAX_HEAP_MEM=8192
elif [ $TOTAL_MEM -ge 7500 ]; then
    MAX_HEAP_MEM=4096
elif [ $TOTAL_MEM -ge 3500 ]; then
    MAX_HEAP_MEM=2048
elif [ $TOTAL_MEM -ge 2000 ]; then
    MAX_HEAP_MEM=1024
else
    MAX_HEAP_MEM=$TOTAL_MEM/5*3
fi

MIN_HEAP_MEM=$MAX_HEAP_MEM
DIRECT_MEMORY=$(expr $MAX_HEAP_MEM / 3)
NEW_HEAP_MEM=$(expr $MAX_HEAP_MEM / 2)
MAX_META_MEM=$(expr $MAX_HEAP_MEM / 2)
MIN_META_MEM=$(expr $MAX_META_MEM / 2)

MEM_OPTS="-Xms"$MIN_HEAP_MEM"M -Xmx"$MAX_HEAP_MEM"M -Xmn"$NEW_HEAP_MEM"M -XX:MetaspaceSize="$MIN_META_MEM"M -XX:MaxMetaspaceSize="$MAX_META_MEM"M -XX:MaxDirectMemorySize="$DIRECT_MEMORY"M"

CATALINA_OPTS="-Dspring.profiles.active=prod \
-Dcom.sun.management.jmxremote=true \
-Dcom.sun.management.jmxremote.port=7777 \
-Dcom.sun.management.jmxremote.local.only=false \
-Dcom.sun.management.jmxremote.authenticate=false \
-Dcom.sun.management.jmxremote.ssl=false \
-Dfile.encoding=UTF-8
-server $MEM_OPTS \
-XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+TieredCompilation \
-XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCApplicationStoppedTime \
-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/data/logs/$APP_NAME/oom.hprof
-XX:ErrorFile=/data/logs/$APP_NAME/hs_err_pid_%p.log"

BUILD_VERSION=`java -version 2>&1 | head -n 1 | awk -F '"' '{print $2}' | awk -F _ '{print $2}'`

if [ $BUILD_VERSION -ge 60 ];then
    CATALINA_OPTS+=" -XX:+PreserveFramePointer"
fi

export CATALINA_OPTS="$CATALINA_OPTS"
echo "$CATALINA_OPTS"
