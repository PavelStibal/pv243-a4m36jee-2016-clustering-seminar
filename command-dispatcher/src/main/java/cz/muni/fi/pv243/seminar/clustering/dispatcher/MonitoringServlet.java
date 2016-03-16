package cz.muni.fi.pv243.seminar.clustering.dispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            resp.getWriter().println("Retrieved monitoring data from cluster:");
            resp.getWriter().println();

            // TODO: implement fetching monitoring data from the cluster.

        } catch (Exception e) {
            resp.getWriter().println("Error retrieving monitoring data: " + e.getMessage());
        }
    }
}
