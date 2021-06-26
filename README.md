# emandate
Code for API/Esign mandate application. Refers to http://hobbs.evolvus.com/source-repository/esign/trunk/
# EMANDATE
Latest EMANDATE Code line Applicable to EQTS / Federal / UJJIVAN  Customers



## Building the application from Source Code

#### In order to build the application from the source code, perform the following tasks

1. Checkout the source code into a folder
   ```
   git clone https://github.com/Evolvus/asba.git ASBA-BUILD
    ```
2. Build the application using the following Maven command
    ```
   cd ASBA-BUILD
   mvn clean install -f shared-parent/
     ```
3. If the build is successful,
     ```
   You should see the asba and asba-sources jar file in `CHECKED OUT FOLDER`
   For example:`CHECK OUT FOLDER`/asbaCore/target/asba.jar and `CHECK OUT FOLDER`/asbaCore/target/asba-sources.jar
     ```
## Making Changes
   In order to make code changes, check out the code as mentioned in the section 'Building the application from source code'.
   Use an IDE like Eclipse to make the necessary changes and commit the changes. Test the application and if the changes are satisfactory, raise a Pull Request in Github mentioning the changes made. If the review of the changes is satisfactory then the same will be merged into the next releases, else review the comments and make appropriate changes.

## Commiting changes to the local repository


1.After working on the  files and once it is tested and made sure if it is working fine, commit the  changes to the remote repository.

2.Once the changes have been made run the following command to stay updated on the latest version of the remote repository:
   ```
 git pull 
  ```
3.Run the follwing command to add changes in the working directory to the staging area.   :
 ```
 git add filename
 ```
4.Then commit the file into the local repository:
 ```
 git commit -a -m "Log Message"
 ```
5.Once the changes have been commited to the local repository, push the changes to the central/remote repository
  ```
 git push
  ```
## Making Release

1. Check out the code as mentioned in the section `Building the application from source code`.

```
git clone  https://github.com/Evolvus/emandate.git EMANDATE-RELEASE
```

2. Check out the **release** branch.

```
cd EMANDATE-RELEASE
git checkout release
```

3. Build the application using the following Maven command

```
cd EMANDATE-RELEASE
mvn clean install -f shared-parent/
```

4. Start the release using the following Maven command

```
cd shared-parent
mvn external.atlassian.jgitflow:jgitflow-maven-plugin:release-start -DautoVersionSubmodules=true -Dmaven.javadoc.skip=true
```
   Answer the questions to choose the next versions and release version names

6. Finish the release using the following Maven command

```
mvn external.atlassian.jgitflow:jgitflow-maven-plugin:release-finish -DautoVersionSubmodules=true -Dmaven.javadoc.skip=true
```
 
7. Push the changed versions/tags to the central repository

```
cd ..
git push origin release
git push origin master
git push --tags
```

   
8.deploy the release snapshots checkout into nexus

```

cd EMANDATE-RELEASE
git checkout release

cd parentdir/pom.xml

mvn deploy
````
9.clone the release from  git and deploy the release  checkout into nexus
`````
cd  EMANDATE-RELEASE
git checkout release
cd parentdir/pom.xml
mvn deploy


 
 
 
 
 
 
 
 
 
 
 
 

