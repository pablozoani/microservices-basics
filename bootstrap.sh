#!/bin/bash


ROOT_DIR=$(pwd)
GROUP_ID=com.pzoani


### department-service
PROJECT_NAME=department-service
spring init \
    --boot-version=2.4.1 \
    --language=java \
    --java-version=11 \
    --build=maven \
    --packaging=jar \
    --name $PROJECT_NAME \
    --groupId $GROUP_ID \
    --artifactId $PROJECT_NAME \
    --dependencies=web,data-jpa,h2,lombok,actuator,devtools \
    $PROJECT_NAME
cd $PROJECT_NAME
echo "FROM openjdk:11">> Dockerfile
echo src >> .dockerignore
mkdir scripts
cd scripts
mkdir database
mkdir rest-calls
cd ..
cd src/main/resources
echo spring.application.name=$PROJECT_NAME >> application.properties
echo >> application.yml
cd ..
cd java/*/*/*
mkdir config
mkdir controller
mkdir model
mkdir repository
mkdir service
cd "$ROOT_DIR"


### DIR STRUCT
mkdir .recycle_bin
echo 'version: "3.9"' >> docker-compose.yml
echo >> .env


### GIT
git init
echo **/target >> .gitignore
echo **/.env >> .gitignore
echo **/.vscode >> .gitignore
echo **/.recycle_bin >> .gitignore
echo **/.idea >> .gitignore
echo **/*.iws >> .gitignore
echo **/*.iml >> .gitignore
echo **/*.ipr >> .gitignore
echo **/.classpath >> .gitignore
echo **/.factorypath >> .gitignore
echo **/.project >> .gitignore
echo **/.settings >> .gitignore
echo "# App" >> README.md
git add .
git commit -m "initial commit"
git branch develop
git checkout develop


ls -al
