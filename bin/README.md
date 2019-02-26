# LibraryBE

Front-End setup

Step 1:
Open a browser type https://nodejs.org/en/  download, and install node js based on your window bit(image001)

Step 2:
After installing node js, open command prompt type node –v to check installed version of node js.(image002)

Type npm –v to check npm version. If both the commands show their respective versions it means node is installed successfully.(image003)

Step 3:
Open command prompt, type command “npm install –g @angular/cli” . It will install CLI globally where g represents globally. To check Angular CLI installed type command ng –v

If this works then fine else first proxy has to be setup
C:\WINDOWS\system32>npm config set proxy <your proxy>
C:\WINDOWS\system32>npm config set https-proxy <your proxy>
C:\WINDOWS\system32>npm install –g @angular/cli

Step 4: (IDE – download Visual studio )

Open browser, type https://code.visualstudio.com/ download, and install visual code editor.

Create first project using IDE:
https://www.c-sharpcorner.com/article/how-to-setup-angular-development-environment-in-visual-studio-code/
follow steps from step number 8

Regarding the Library-Front-End Project
Build and serve by following steps 
Step 1: open the folder of  Rogers-Library-FrontEnd folder via Visual studio
Step 2: Go to menu->view->Terminal
Step3: at the terminal opened type command “ng serve” (which will build and host the website at localhost:4200)
Step 4: go to web browser(preferably chrome) and type web address http://localhost:4200 to see the website.


Back-End setup

Step 1:
Download  and install JDK
http://download.oracle.com/otn-pub/java/jdk/10.0.2+13/19aef61b38124481863b1413dce1855f/jdk-10.0.2_windows-x64_bin.exe

set up path variable for JAVA
step1: control-panel->system->edit environment variables for your account
step2: click New-> set variable name as -> JAVA-HOME and path of JDK (ex: C:\Program Files\Java\jdk-10.0.2)

Step 2:
Download Eclipse
http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/neon/3/eclipse-jee-neon-3-win32-x86_64.zip


step 1: Go to windows->preferences-General->Network connections
step 2: Enter the proxy as per attachment “eclipse-proxy”

step:3 
Installing Maven:
Download Maven from https://maven.apache.org/download.cgi for Windows go for “Binary zip archive”

Installing maven
Step 1: unzip it and place the folder in C:/program files
Step 2: set the environment path variable for maven in path variable as “C:\Program Files\apache-maven-3.5.4\bin”
Step 3: for setting proxy: place the file settings.xml(attached) at location “C:\Users\kua\.m2” 
Step 4: check for the maven successful installation on Command prompt by running command “mvn –version”

Regarding the backend-library  project 
Step 1: open Eclipse and “new->open projects from filesystem->directory path of your library-backend folder”.
Step2: click on Run->Run As-> maven install
Step3: after success full building of previous click  Run->RunAs->java application
Step4: it will open port 9090 for interaction.


