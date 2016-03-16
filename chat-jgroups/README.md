JGroups Chat
============

Basic JGroups demo.

Building
--------

    mvn clean package

Running via Maven
-----------------

    mvn exec:java -Djava.net.preferIPv4Stack=true -Duser.name=`whoami`


Troubleshooting
---------------

* Bind to specific address `-Djgroups.bind.address=127.0.0.1`
* Reconfigure or temporarily disable firewall `sudo service firewalld stop`
* Add multicast route for a local interface `sudo route add -net 224.0.0.0/4 -interface lo0`
* Read on http://www.jgroups.org/tutorial/#_trouble_shooting