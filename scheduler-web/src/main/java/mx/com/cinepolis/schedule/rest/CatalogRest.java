package mx.com.cinepolis.schedule.rest;

import mx.com.cinepolis.scheduler.commons.to.CatalogsTO;
import mx.com.cinepolis.scheduler.commons.to.GitHubUserTO;
import mx.com.cinepolis.scheduler.commons.to.UserTO;
import mx.com.cinepolis.scheduler.facade.CatalogFacadeEJB;
import mx.com.cinepolis.scheduler.facade.GitHubFacadeEJB;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;



/**
 * @author jrodriguez
 */
@Path("/catalog")
public class CatalogRest {

	@EJB
    private CatalogFacadeEJB catalogFacadeEJB;
    @EJB
    private GitHubFacadeEJB gitHubFacadeEJB;


    @GET
    @Produces("application/json")
    @Path("/user")
    public Response getSimpleCatalog()
    {
        UserTO userTO = catalogFacadeEJB.getSimpleUser();
        return Response.ok().entity(userTO).build();
    }
    
    @GET 
    @Produces("application/json")
    @Path("/country/{pais}")
    public Response getEstados(@PathParam ("pais") String pais) {
    
    List<CatalogsTO> catalogsTOList= catalogFacadeEJB.getEstadoList(pais);
    
    GenericEntity<List<CatalogsTO>> entity = new GenericEntity<List<CatalogsTO>>(catalogsTOList) {};
    
    	return Response.ok().entity(entity).build();
    }
    
    
  @GET 
  @Produces("application/json")
  @Path("/country")
//  Country?pais=mexico
  public Response getEstados(@Context UriInfo ui) {
  
	  MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
	  String pais= queryParams.getFirst("pais");
	  
	  List<CatalogsTO> catalogsTOList= catalogFacadeEJB.getEstadoList(pais);
  
	  GenericEntity<List<CatalogsTO>> entity = new GenericEntity<List<CatalogsTO>>(catalogsTOList) {};
  
  	return Response.ok().entity(entity).build();
  }
  
  
  @GET
  @Produces("application/json")
  @Path("/github")
  public Response getSimpleUserGitHub(@Context UriInfo ui)
  {
	  MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
	  String login= queryParams.getFirst("login");
	  
	  GitHubUserTO gitHubUserTO = gitHubFacadeEJB.getSimpleUserGitHub(login);
      return Response.ok().entity(gitHubUserTO).build();

  
//  	return Response.ok().entity(entity).build();
  }
    
   
  @GET
  @Produces("application/json")
  @Path("/login")
  public Response getValidateUser(@Context UriInfo ui)
  {
	  MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
	  String login= queryParams.getFirst("login");
	  String contra= queryParams.getFirst("contra");
	  
	  GitHubUserTO getValidateUser = gitHubFacadeEJB.getValidateUSer(login, contra);
      return Response.ok().entity(getValidateUser).build();

  }
   
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/alta")
  public void addPersona(GitHubUserTO gitHubUserTO) {
   
	  gitHubFacadeEJB.setGitHubUser(gitHubUserTO);
	  System.out.println(gitHubUserTO.getName());
  }
  
    
}
