package sample.restproject.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import sample.restproject.messenger.model.Messeges;
import sample.restproject.messenger.resources.beans.MessegeFilterBean;
import sample.restproject.messenger.service.MessegeService;

@Path("/messeges")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessegeResource {
	
	MessegeService messegeService = new MessegeService();
	

//	@GET
//	public List<Messeges> getMesseges(@QueryParam("year") int year,
//									  @QueryParam("start") int start,
//									  @QueryParam("size") int size){
//		if(year>0){
//			return messegeService.getAllMessegesForYear(year);
//		}
//		if(start>=0 && size>=0){
//			return messegeService.getAllMessegesPaginated(start, size);
//		}
//		return messegeService.getAllMesseges();
//	}
	
	@GET
	public List<Messeges> getMesseges(@BeanParam MessegeFilterBean filterBean){
		if(filterBean.getYear()>0){
			return messegeService.getAllMessegesForYear(filterBean.getYear());
		}
		if(filterBean.getStart()>=0 && filterBean.getSize()>=0){
			return messegeService.getAllMessegesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messegeService.getAllMesseges();
	}
	
	
//	@POST
//	public Messeges addMesseges(Messeges messege){
//		return messegeService.addMesseges(messege);
//	}
	
	//way to return entity with status
	@POST
	public Response addMesseges(Messeges messege, @Context UriInfo uriInfo ) throws URISyntaxException{
		Messeges newMessege = messegeService.addMesseges(messege);
		String newId = String.valueOf(newMessege.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		
//		return Response.status(Status.CREATED)
//						.entity(newMessege)
//						.build();
		//way to return entity eith status and uri by hard-coding
//		return Response.created(new URI("/messenger/webapi/messeges/"+newMessege.getId()))
//				.entity(newMessege)
//				.build();
		return Response.created(uri)
				.entity(newMessege)
				.build();
	}
	
	@GET
	@Path("/{messegesId}")
	public Messeges getMesseges(@PathParam("messegesId") long id){
		return messegeService.getMesseges(id);
	}
	
	
	@PUT
	@Path("/{messegesId}")
	public Messeges updateMessege(@PathParam("messegesId") long id, Messeges messege){
		messege.setId(id);
		return messegeService.updateMessege(messege);
	}
	
	@DELETE
	@Path("/{messegesId}")
	public void removeMesege(@PathParam("messegesId") long id){
		messegeService.removeMessege(id);
	}
	
	@Path("/{messegesId}/comments")
	public CommentsResource getCommentsResource(){
		return new CommentsResource();
	}
	
	
//	@GET
//	@Path("/{messegesId}")
//	@Produces(MediaType.APPLICATION_XML)
//	public Messeges getMesseges(@PathParam("messegesId") long messegeId){
//		return messegeService.getMesseges(messegeId);
//	}
	
}

