#! /usr/bin/bash

/usr/bin/systemctl status sshd | head -6

SSHD=`/usr/bin/systemctl status sshd | grep "active (running)" | wc -l`

if (( $SSHD > 0 )) ; then
   echo "GOOD - sshd is running needed by hadoop";
else
   echo "ERROR - restart sshd, systemctl start sshd";
fi

find /dev/infiniband/ -mindepth 1 -printf "%m:%p\n"

for i in `jps | awk -F' ' '$0 !~ /Jps/{print $1}'` ;  do strings /proc/$i/environ | egrep '(JAVA_HOME|LD_PRELOAD)'; done

IBDIAGS=`rpm -qa | grep infiniband-diags | grep infiniband-diags | wc -l`
if (( $IBDIAGS > 0 )) ; then
   ibstat | egrep '(mlx|State)';
else
   echo "ERROR - Missing software, yum install infiniband-diags";
fi








