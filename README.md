# KNX Device Spring Boot Starter

## Introduction

I had a KNX setup installed in my house for lighting, blinds, and heating but I found it complicated to create virtual devices myself that represent devices controlled over APIs in the KNX network.
That's when I came across the [Calimero project](https://github.com/calimero-project) which implements the KNXnet/IP interface protocol to communicate with the KNX bus through an IP gateway.

I wanted to be able to mostly declaratively create a virtual KNX device, generate the corresponding .knxprod file to be imported into ETS, configure it through ETS and use it like any other KNX device in the network.

This Spring Boot Starter tries to achieve exactly that.

## Getting started

The easiest way to get started is to look at the Sample Device example and extend it to create your own device:

Build the project from the root folder:

```sh
$ mvn clean install 
```

List available KNX device commandline options:

```sh
$ java -jar knx-spring-boot-sample\target\knx-sample-device.jar help
$ java -jar knx-spring-boot-sample\target\knx-sample-device.jar help createKnxProd
$ java -jar knx-spring-boot-sample\target\knx-sample-device.jar help start
```

Create the .knxprod file for your device. This requires ETS4 or ETS5 to be installed on our machine

```sh
$ java -jar knx-spring-boot-sample\target\knx-sample-device.jar createKnxProd 
[main] INFO lu.berscheid.knx.generator.KnxProductGenerator - KNX Product file written to C:\Users\GeorgesBerscheid\.knx\SampleDevice\M-00FA_H-S111-1.knxprod
```

Import the generated .knxprod file into ETS (Catalogs -> Import...). 

You should then be able to add the device to your topology and start programming it from ETS once you have started the device. In the example below I'm using a tunneling link 

```sh
$ java -jar knx-spring-boot-sample\target\knx-sample-device.jar start -i 192.168.178.200 -p 3671
```

