Clustering & High Availability Seminar
======================================

Complete Documentation
 * https://docs.jboss.org/author/display/WFLY10/Documentation

HA Guide
* https://docs.jboss.org/author/display/WFLY10/High+Availability+Guide

Seminar preparation:
--------------------

1. Unzip two separate instances of WildFly

        unzip wildfly-10.0.0.Final.zip
        cp -r wildfly-10.0.0.Final wildfly-10.0.0.Final-1
        cp -r wildfly-10.0.0.Final wildfly-10.0.0.Final-2

2. Always use `standalone-ha.xml` configuration

        ./bin/standalone.sh -c standalone-ha.xml
