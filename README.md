# Introduction 
The modpims-testing repo contains the modPIMS Test Team Code that includes:
* Katalon 
* Selenium
* Java
* Any other code that the modPIMS Test Team authors

# Getting Started
The following steps will guide contributors through the process to contribute to IAC of the modPIMS environment deployment and sustainment.:
1.	Repository Access
    Use the instructions for SSH based authentication to the Azure Repo and to clone the repository to your local GIT IDE: https://docs.microsoft.com/en-us/azure/devops/repos/git/use-ssh-keys-to-authenticate?view=azure-devops
2.	GIT Branching:
    The master branch of the repository is locked down so that users cannot perform a git push directly to the branch.
    Use the following GIT commands to create a feature branch and push the code
      - git checkout -b feature/<username>/<description> (i.e., feature/sanderson/network-resourcegroups)
        - Example: batchjobs/arath/training
      - git pull origin master
        - Ensures your git repo has the most current files from master
      - Make your code updates and save files
      - git add *
      - git commit -m "Added <functionality>" (i.e., git commit -m "Added resource groups for spoke environments")
      - git push origin feature/<username>/<description> (i.e., git push origin feature/sanderson/network-resourcegroups)
    The git push to the feature branch will initiate the Azure Build pipeline that will perform the Terraform init and Terraform plan tasks. If successful then the code can be merged into master.
3.	GIT Merging:
    When you are ready to merge your feature branch into master contact the project administrators to perform the merge.
4.	After the code is merged to master then run the following on your local GIT IDE
      - git checkout master
      - git pull origin master
      - git branch delete feature/<username>/<description> (i.e., git branch delete feature/sanderson/network-resourcegroups)

# Build and Test
TODO: Describe and show how to build your code and run the tests. 

# Contribute
TODO: Explain how other users and developers can contribute to make your code better. 

If you want to learn more about creating good readme files then refer the following [guidelines](https://docs.microsoft.com/en-us/azure/devops/repos/git/create-a-readme?view=azure-devops). You can also seek inspiration from the below readme files:
- [ASP.NET Core](https://github.com/aspnet/Home)
- [Visual Studio Code](https://github.com/Microsoft/vscode)
- [Chakra Core](https://github.com/Microsoft/ChakraCore)