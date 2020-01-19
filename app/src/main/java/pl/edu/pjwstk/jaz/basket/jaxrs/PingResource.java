package pl.edu.pjwstk.jaz.basket.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/health")
public class PingResource {
    @GET
    @Path("/ping")
    public Response ping() {
//        ((ResteasyWebTarget) ResteasyClientBuilder.newBuilder().build().target("")).proxy(...)
        return Response.ok().entity(new PingStatus("OK")).build();
    }

    private static class PingStatus {
        private final String status;

        public PingStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }
}