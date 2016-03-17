package cz.muni.fi.pv243.seminar.clustering.dispatcher;

import org.wildfly.clustering.dispatcher.CommandResponse;
import org.wildfly.clustering.group.Node;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Monitoring servlet that outputs information about cluster nodes:
 * <p/>
 * <pre>
 * Retrieved monitoring data from cluster:
 *
 * Node node1 memory usage 111 / 455 MB.
 * Node node2 memory usage 79 / 455 MB.
 * </pre>
 *
 * @author Radoslav Husar
 */
@SuppressWarnings("unchecked")
@WebServlet(urlPatterns = "monitor")
public class MonitoringServlet extends HttpServlet {

    @EJB
    private CommandDispatcherBean dispatcherBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            final Map<Node, CommandResponse<MonitoringData>> responses = dispatcherBean.getCommandDispatcher().executeOnCluster(new MonitoringCommand(), (Node[]) null);

            resp.getWriter().println("Retrieved monitoring data from cluster:");
            resp.getWriter().println();

            for (Map.Entry<Node, CommandResponse<MonitoringData>> response : responses.entrySet()) {
                final Node node = response.getKey();
                final MonitoringData data = response.getValue().get();
                resp.getWriter().println("Node " + node.getName() + " memory usage " + data.getUsedMemory() / 1024 / 1024 + " / " + data.getMaxMemory() / 1024 / 1024 + " MB.");
            }
        } catch (Exception e) {
            resp.getWriter().println("Error retrieving monitoring data: " + e.getMessage());
        }
    }
}
