package cz.muni.fi.pv243.seminar.clustering.dispatcher;

import org.wildfly.clustering.dispatcher.Command;
import org.wildfly.clustering.group.Node;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.logging.Logger;

/**
 * @author Radoslav Husar
 */
public class MonitoringCommand implements Command<MonitoringData, Node> {

    /**
     * Command which retrieves some monitoring data from a node.
     *
     * @see ManagementFactory#getMemoryMXBean()
     */
    @Override
    public MonitoringData execute(Node node) throws Exception {
        Logger.getLogger(MonitoringCommand.class.getCanonicalName()).info("Collecting data on node " + node.getName());

        final MemoryUsage heapMemoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        return new MonitoringData(heapMemoryUsage.getUsed(), heapMemoryUsage.getMax());
    }
}
