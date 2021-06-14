# **Trial Task project**

This is a modular project. The main purpose of using modules is to decouple application logic and make it highly scalable

## **Modules Description**

#### **Common**
Contains domain/dto object as well as api interfaces. It can (maybe must) be separated to multiple implementation module related packages.

#### **Command Line Binder**
Spring cloud stream command line binder implementation. I'm not sure it's production ready implementation because I did it first time, but at least it does its job for this application :)

#### **Currency**
This module works with Currencies. Here builds dto from exchange output

#### **Exchange CoinDesk**
CoinDesk client. The main purpose is to transform coindesk data to application domain


## **To run application**
`
gradle application:bootJar
`
to create bootable jar file

and 

`java -jar application/build/libs/application.jar
`
to run application

_* note that gradle bootRun is not supported due to command line binder_

## **To build Docker image**
`
gradle application:bootBuildImage
`

_* Docker image with latest changes is available at https://hub.docker.com with tag rikkydn/trial-app_

