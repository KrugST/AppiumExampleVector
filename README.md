# AppiumExampleVector

<h1>How to run instructions for MAC.</h1>

<h2>1. Install JAVA JDK</h2>

  You should go to the below link and install JAVA JDK for MAC OS.

  https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

  After installation check below path to find JAVA HOME, for my version it is as shown below.

  <b>/Library/Java/JavaVirtualMachines/jdk1.8.0_192.jdk/Contents/Home</b>
  
  Then set JAVA HOME on your Mac as shown below:

  <b>export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_192.jdk/Contents/Home</b>
  
  Then, run below command to check your JAVA HOME.
  
   <b>echo $JAVA_HOME</b>

  Note that this sets JAVA_HOME only for a session. 
  
  If you want it to persist always for all sessions, you need to add the command to your <b>~/.profile file.</b>

  Open a new terminal window.
  
  Open a .profile file by typing: emacs .profile
  
  Type below commands:
  
  <b>JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_192.jdk/Contents/Home</b>
  
  <b>export JAVA_HOME;</b>
  
  Then, do the (ctrl-x, ctrl-s; ctrl-x, ctrl-c) to save and exit emacs.
  
  Open a new terminal and run below command:
  
 <b> $JAVA_HOME/bin/java -version</b>
  
  If you have MAC OS 10.5 or newer you can just use below command:

  <b>export JAVA_HOME=$(/usr/libexec/java_home)</b>
  
  <b>export PATH=$JAVA_HOME/bin:$PATH</b>
  
  then source the profile file:
  
  <b>source ~/.profile</b>
  
  Then check the result:
  
  <b>echo $JAVA_HOME</b>
  
  
 <h2> 2. Install Android Studio</h2>
  You need to go to the below address, download Android Studio for Mac and do the followings as stated below.

https://developer.android.com/studio/

 To install Android Studio on your Mac, proceed as follows:

1) Launch the Android Studio DMG file.
2) Drag and drop Android Studio into the Applications folder, then launch Android Studio.
3) Select whether you want to import previous Android Studio settings, then click OK.
4) The Android Studio Setup Wizard guides you through the rest of the setup, which includes downloading Android SDK components that are required for development.
5) When u open and select the default settings, Android Studio will start to download the required libraries as shown below.

Do below settings in .profile file. Open a terminal and type
<b>nano ~/.profile</b>

Then, paste below commands: (Change your user name! Not use my username “roman”).

<b>export ANDROID_HOME=/Users/roman/Library/Android/sdk</b>

<b>export PATH=$ANDROID_HOME/platform-tools:$PATH</b>

<b>export PATH=$ANDROID_HOME/tools:$PATH</b>
<b>export PATH=$ANDROID_HOME/tools/bin:$PATH</b>

Then, run below commands to verify the settings:

After that, check your settings and installations. Open a terminal and type <b>“sdkmanager –list”</b>.

And type <b>“adb”</b> to check adb is working properly.

<h2>3. Install Homebrew</h2>
Open a terminal window and run below command to install brew:
<b>
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"</b>
Check brew version: <b>brew -v</b>

<h2>4. Install Node.js and npm</h2>
Use brew to install node: <b> brew install node</b>
optional you can run: <b>brew update</b> and <b>brew upgrade node</b> 

<h2>5. Install Appium</h2>
Install appium via terminal you need to run below commands:

<b>npm install -g appium</b>
More documentation can be found (http://appium.io/docs/en/about-appium/getting-started/)

<h2>6. Install Appium Doctor</h2>

Appium Doctor checks most of the preconditions for appium to run successfully. In order to install it, run below command:

<b>npm install -g appium-doctor</b>

Let’s run appium doctor and see what we should do for Appium.
use this command: <b>appium-doctor</b>

you can see if you missed anything

<h2>6. Install Maven</h2>
It is used for building and managing Java-based projects by using dependencies. Open a terminal and run below command.

<b>brew install maven</b>
Then, check the installation with below command:

<b>mvn -version</b>

Then, add the maven path to your profile file.
<b>
export PATH=/usr/local/Cellar/maven/3.6.0/bin:$PATH</b>


<h1> HOW TO RUN</h1>
