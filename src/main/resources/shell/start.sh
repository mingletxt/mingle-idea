#!/bin/sh

APP_NAME=recomm-front
BASE_PATH=/data/projects/recap
APP_PATH=$BASE_PATH/$APP_NAME
BACK_PATH=$BASE_PATH/backups/$APP_NAME

rm -rf $BACK_PATH

if [ -d $APP_PATH ]; then
    CURRENT=`date "+%Y%m%d%H%M%S"`
    ZIP_PATH=$BACK_PATH/$APP_NAME-$CURRENT.zip
    echo "backup $APP_PATH to $ZIP_PATH"

    mkdir $BACK_PATH
    cd $APP_PATH
    zip -q -r $ZIP_PATH *
    rm -rf $APP_PATH/*
else
    mkdir $APP_PATH
fi



cp -rf /data/temp/recomm-front/* $APP_PATH

echo "call service.sh stop"
#sh /data/projects/common/supervisord/service.sh  stop recomm-front
cd /data/projects/common/monit
sh service.sh start recomm-front

echo "call service.sh start"
sh /data/projects/common/supervisord/service.sh  start   recomm-front
sh service.sh start recomm-front






