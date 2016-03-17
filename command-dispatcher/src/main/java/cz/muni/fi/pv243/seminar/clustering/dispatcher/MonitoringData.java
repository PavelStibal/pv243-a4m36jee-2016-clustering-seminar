package cz.muni.fi.pv243.seminar.clustering.dispatcher;

import org.wildfly.clustering.web.annotation.Immutable;

import java.io.Serializable;

/**
 * @author Radoslav Husar
 */
@Immutable
public class MonitoringData implements Serializable {

    private long usedMemory;
    private long maxMemory;

    public MonitoringData(long usedMemory, long maxMemory) {
        this.usedMemory = usedMemory;
        this.maxMemory = maxMemory;
    }

    public long getUsedMemory() {
        return usedMemory;
    }

    public long getMaxMemory() {
        return maxMemory;
    }
}