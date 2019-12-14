# AppiumExampleVector

How to run instructions for MAC.

1. Install JAVA JDK
  You should go to the below link and install JAVA JDK for MAC OS.

  https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

  After installation check below path to find JAVA HOME, for my version it is as shown below.

  /Library/Java/JavaVirtualMachines/jdk1.8.0_192.jdk/Contents/Home
  
  Then set JAVA HOME on your Mac as shown below:

  export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_192.jdk/Contents/Home
  Then, run below command to check your JAVA HOME.
   echo $JAVA_HOME

  Note that this sets JAVA_HOME only for a session. If you want it to persist always for all sessions, you need to add the command to your ~/.profile file.

  Open a new terminal window.
  Open a .profile file by typing: emacs .profile
  Type below commands:
  JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_192.jdk/Contents/Home
  export JAVA_HOME;
  Then, do the (ctrl-x, ctrl-s; ctrl-x, ctrl-c) to save and exit emacs.
  Open a new terminal and run below command:
  $JAVA_HOME/bin/java -version
  
  If you have MAC OS 10.5 or newer you can just use below command:

  export JAVA_HOME=$(/usr/libexec/java_home)
  export PATH=$JAVA_HOME/bin:$PATH
  then source the profile file:
  source ~/.profile
  Then check the result:
  echo $JAVA_HOME
