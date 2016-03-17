package cz.muni.fi.pv243.seminar.clustering.dispatcher;

import org.wildfly.clustering.dispatcher.CommandDispatcher;
import org.wildfly.clustering.dispatcher.CommandDispatcherFactory;
import org.wildfly.clustering.group.Node;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author Radoslav Husar
 */
@Local
@Startup
@Singleton
public class CommandDispatcherBean {

    @Resource(lookup = "java:jboss/clustering/dispatcher/server")
    private CommandDispatcherFactory factory;

    private CommandDispatcher<Node> commandDispatcher;

    @PostConstruct
    private void init() {
        commandDispatcher = this.factory.createCommandDispatcher(CommandDispatcherBean.class.getCanonicalName(), this.factory.getGroup().getLocalNode());
    }

    public CommandDispatcher<Node> getCommandDispatcher() {
        return this.commandDispatcher;
    }

    @PreDestroy
    private void destroy() {
        commandDispatcher.close();
    }
}
