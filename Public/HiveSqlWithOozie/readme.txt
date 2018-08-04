This readme file consists of following three steps

1. Running all required daemons.
2. Setting up the environment
3. Executing application


**********************************************************1. Running all required daemons**********************************************************************


1. Check whether all the hadoop daemons are up and running by following command
   sudo jps

2. if any of the daemon is not running then use restart all daemons by following command:

  sudo service hadoop-master restart
  sudo hadoop dfsadmin -safemode leave

  and check whether the daemons started or not by "sudo jps" command. Even if the daemons not started then follow below steps:

  a. hit hostname command and check the hostname of your machine.
  b. check the system ip by ifconfig command and note this ip.
  c. open file /etc/hosts and in the first line add ip and hostname with tab delimiter.
  d. update hostname in /etc/sysconfig/network file also.
  e. restart hadoop-master service and this time daemons will be running.
  f. even if the daemons are not up and running then reload edureka machine.

3.  Run below commands to run oozie daemon i.e. bootstrap

  a.  cd $OOZIE_HOME/bin
  b.  oozie-start.sh
  c.  browse http://localhost:11000/oozie/


Now all the daemons are up and running and we can proceed with our next step.



***************************************************************************2. Setting up environment*****************************************************************


1. creating required folders on hdfs using below commands:

   hadoop fs -mkdir /practice
   hadoop fs -mkdir /practice/dataset
   hadoop fs -mkdir /hive-oozie
   hadoop fs -mkdir /user/oozie/share/
   hadoop fs -mkdir /user/oozie/share/lib

2. copy input.txt file present in dataset folder on hdfs using below command:

   hadoop fs -put input.txt /practice/dataset/

3. copy following files in this folder in /hive-oozie hdfs

   hive-site.xml, job.properties, script.hql, workflow.xml

   using hadoop fs -put <above files> /hive-oozie

4. copy all the jars present in hive-jars folder into /user/oozie/share/lib path on hdfs using below command:
   hadoopf fs -put /usr/lib/hive-0.13.1-bin/lib /user/oozie/share/lib/


Now all the required environmental setup is completed.


*****************************************************************Executing Application*************************************************************************

oozie job -oozie http://localhost:11000/oozie -config <locate application job.properties file in local>job.properties -run

and check the statistics of the application in browser using below url:

http://localhost:11000/oozie/


sftp port: 22