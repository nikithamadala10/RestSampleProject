package sample.restproject.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)

public class InjectDemoResource {
	
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotation(@MatrixParam("param") String matrixParam,
											@HeaderParam("customHeaderValue") String header,
											@CookieParam("name") String Cookie){
		
		return "Matrix Param: " + matrixParam + "header param: " + header + "Cookie param: " +Cookie;  
	}

	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo,
										@Context HttpHeaders heardes){
		
		String path=uriInfo.getAbsolutePathBuilder().toString();
		String cookies = heardes.getCookies().toString();
		return "Path: " + path+ " cookies: " + cookies;
		}
}
