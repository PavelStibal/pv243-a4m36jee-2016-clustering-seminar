Highly Available WebApplication
===============================

This example demonstrates session distribution in clustered environment.

Running
-------

1. Build WebApp

        mvn clean package

2. Copy `highly-available-webapp.war` to both servers

        cp target/highly-available-webapp.war ../../wildfly-10.0.0.Final-1/standalone/deployments
        cp target/highly-available-webapp.war ../../wildfly-10.0.0.Final-2/standalone/deployments

3. Start both servers

        ./wildfly-10.0.0.Final-1/bin/standalone.sh -c standalone-ha.xml -Djboss.node.name=`whoami`-node1
        ./wildfly-10.0.0.Final-2/bin/standalone.sh -c standalone-ha.xml -Djboss.node.name=`whoami`-node2 -Djboss.socket.binding.port-offset=100

4. Open in browser

    [http://localhost:8080/highly-available-webapp/](http://localhost:8080/highly-available-webapp/)

5. Test failover

    [http://localhost:8180/highly-available-webapp/](http://localhost:8180/highly-available-webapp/)