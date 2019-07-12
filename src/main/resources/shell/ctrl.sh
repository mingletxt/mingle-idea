#!/bin/sh
calculate_jvm_mem(){
echo 'start'
    TOTAL_MEM=`free -m | grep Mem | awk '{print $2}'`
    if [ ! -n "TOTAL_MEM" ]; then
      echo "command free is not supported, set default TOTAL_MEM=2048"
      TOTAL_MEM=2048
    fi

    TOTAL_MEM=2048

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
    echo "-Xms"$MIN_HEAP_MEM"M -Xmx"$MAX_HEAP_MEM"M -Xmn"$NEW_HEAP_MEM"M -XX:MetaspaceSize="$MIN_META_MEM"M -XX:MaxMetaspaceSize="$MAX_META_MEM"M -XX:MaxDirectMemorySize="$DIRECT_MEMORY"M"
}