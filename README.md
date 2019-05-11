# ScalaPractice2
TeSt

1)  Creating SBT project
2)  Convert it into git
3)  Push it into your git account
4)  Update any change directly into git

1)  Creating SBT project
  - Create new folder and create build.sbt file with below content
      name := "hello"
      version := "1.0"
      scalaVersion := "2.10.2"
      
  - Create this directory structure in project folder src/main/scala.    
  - Open project location in cmd.
  - Hit sbt command. It will download project stucture from internet.
  - Import that project in intellij.
  
2)  Conver it into git
    - Open the project location into git bash
    - Hit "git init" command. It will convert that directory into git repository.
    
3)  Pushing project on github
    -   Browse to project location and hit "git add .". It will add all modified/new files in git pool
    -   Commit these files with proper message. git commit -m "First Commit"
    -   Now we need to push them. But before pushing it on github, we would have to create target repository to github manually.
    -   Create repository on github and hit below command to link target repository
          git remote add origin <remote repository URL>
    -   Now hit this command "git push origin master". It will push the changes to github repository.
   
4)   Update any change directly into git kapil
    -   Now for any change and update, we need to just hit commands in below sequences.
        * git pull origin master
        * git add "your file"
        * git commit -m "commit message"
        * git push origin master

If you get this error:   fatal: refusing to merge unrelated histories 
  Then use this command:
    git pull origin master --allow-unrelated-histories
    
    
If by any chance you loose your passphrase, then below are easy way to regenerate it(tested):
1)  ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
2)  Paste the content of id_rsa.pub file in your github account. Goto settings -> SSH and GPG Keys -> New SSH key


        
