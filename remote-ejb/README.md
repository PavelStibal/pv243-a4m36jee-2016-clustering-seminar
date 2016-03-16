Clustered Remote EJB
====================

This example demonstrates Stateful and Stateless EJBs in clustered environment.

Running
-------

1. Build client and server

        mvn clean install

2. Copy server-side.jar to both servers

        cp server-side/target/server-side.jar ../../wildfly-10.0.0.Final-1/standalone/deployments
        cp server-side/target/server-side.jar ../../wildfly-10.0.0.Final-2/standalone/deployments

3. Start both servers

        ./wildfly-10.0.0.Final-2/bin/standalone.sh -c standalone-ha.xml -Djboss.node.name=`whoami`-node1
        ./wildfly-10.0.0.Final-2/bin/standalone.sh -c standalone-ha.xml -Djboss.node.name=`whoami`-node2 -Djboss.socket.binding.port-offset=100

4. Run the client

        cd client-side
        mvn exec:java -Dexec.mainClass="cz.muni.fi.pv243.seminar.clustering.ejb.remote.client.StatelessRemoteClient"
        mvn exec:java -Dexec.mainClass="cz.muni.fi.pv243.seminar.clustering.ejb.remote.client.StatefulRemoteClient"

Don't forget to rerun 'mvn clean install' when you make changes to the code.
