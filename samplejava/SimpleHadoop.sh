#! /usr/bin/bash
#
# Required software: Hadoop 2.6 or 2.7
#
#CLASSPATH depends on Hadoop being installed in $HADOOP_PREFIX
export CLASSPATH=${HADOOP_PREFIX}/etc/hadoop/:${HADOOP_PREFIX}/share/hadoop/common/lib/*:${HADOOP_PREFIX}/share/hadoop/common/*:${HADOOP_PREFIX}/share/hadoop/hdfs:${HADOOP_PREFIX}/share/hadoop/hdfs/lib/*:${HADOOP_PREFIX}/share/hadoop/hdfs/*:${HADOOP_PREFIX}/share/hadoop/yarn/lib/*:${HADOOP_PREFIX}/share/hadoop/yarn/*:${HADOOP_PREFIX}/share/hadoop/mapreduce/lib/*:${HADOOP_PREFIX}/share/hadoop/mapreduce/*:${HADOOP_PREFIX}/contrib/capacity-scheduler/*.jar:.

# cleanup from last build
rm -f SimpleHadoop.class
# Build java class
_JAVA_OPTIONS=-Djava.net.preferIPv4Stack=true javac SimpleHadoop.java 

#RUN

_JAVA_OPTIONS=-Djava.net.preferIPv4Stack=true LD_PRELOAD=${HADOOP_PREFIX}/hijack/libhijack.so.3.0.2  java SimpleHadoop
