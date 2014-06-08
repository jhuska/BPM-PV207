package cz.muni.fi.bpm.rest;

import cz.muni.fi.bpm.managers.CategoryService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author <a href="mailto:jhuska@redhat.com">Juraj Huska</a>
 */
@Path("/category")
@RequestScoped
public class MarketplaceCategoryEndpoint {

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class CategoryRequest {

        @XmlElement
        private String title;

        @XmlElement
        private String description;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }

    @Inject
    private CategoryService service;

    @PUT
    @Path("/suggest")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response suggestCategory(CategoryRequest request) {
        return Response.ok(service.suggestCategory(request.getTitle(), request.getDescription())).build();
    }

}
