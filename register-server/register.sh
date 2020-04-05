#!/bin/bash

#This can be replaced with your own executive program, other code does not need to be changed
APP_NAME=eureka-server.jar

#
usage() {
    echo "Usage:sh $0 [start|stop|restart|status]"
    exit 1
}

#Check if the program is running
is_exist() {
    pid=`ps -ef | grep $APP_NAME | grep -v grep | awk '{print $2}' `
    #If there is no return 1, return 0
    if [ -z "${pid}" ]; then
      return 1
    else
      return 0
    fi
}

extract_jar() {
  if [ ! -d "target/" ];then
    exit 1
  else
    mv target/*.jar ./${APP_NAME}
    rm -rf target/
  fi

}

maven_build_package(){
  mvn clean package
  if (( $? ))
  then
      echo "mvn package failed"
      exit 1
  else
      echo "mvn package success"
  fi
}

store_current_version() {
  if [ -d "code/" ];then
    rm -rf code
  fi
  mkdir -p code
  mv pom.xml code/
  mv src/ code/
  d1=`date +%H:%M:%S`
  echo "The Script begin at $d1."
  # echo "suffix:  ${suffix}"
}


#Start method 方式
start() {
  if [ -f "pom.xml" ];
  then
     echo ">>>> maven_build_package"
     maven_build_package
     echo ">>>> extract_jar"
     extract_jar
     echo ">>>> store_current_version"
     store_current_version
   fi
   echo ">>>> is_exist"
   is_exist
   if [ $? -eq "0" ]; then
     echo ">>>> start server"
     echo "${APP_NAME} is already running. pid=${pid} ."
   else
     nohup java -jar $APP_NAME >> Log.log 2>&1 &
   fi
   is_exist
   if [ $? -eq "0" ]; then
     echo "${APP_NAME} is already running. pid=${pid} ."
   else
     echo "${APP_NAME} start fail! "
   fi
}


stop() {
   is_exist
   if [ $? -eq "0" ]; then
     kill -9 $pid
     echo "${APP_NAME} already stop !"
   else
     echo "${APP_NAME} is not running"
   fi
   rm -rf Log.log
}


status() {
   is_exist
   if [ $? -eq "0" ]; then
     echo "${APP_NAME} is running. Pid is ${pid}"
   else
     echo "${APP_NAME} is not running."
   fi
}


restart() {
   stop
   start
}

# According to the input parameters,
# choose to execute the corresponding method,
# if not enter the instructions
case "$1" in
   "start")
     start
     ;;
   "stop")
     stop
     ;;
   "status")
     status
     ;;
   "restart")
     restart
     ;;
   *)
     usage
     ;;
esac
