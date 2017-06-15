package sample.restproject.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sample.restproject.messenger.model.Comment;
import sample.restproject.messenger.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentsResource {
	
	private CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messegesId") long messegesId){
		return commentService.getAllComments(messegesId);
	}
	
	@POST
	public Comment addComment(@PathParam("messegesId") long messegesId, Comment comment){
		return commentService.addComment(messegesId, comment);
	}
	
	@GET
	@Path("/{messegesId}")
	public Comment getComments(@PathParam("messegesId") long messegeId,
								@PathParam("commentId") long commentId){
		return commentService.getComments(messegeId, commentId);
	}
	
	
	@PUT
	@Path("/{messegesId}")
	public Comment updateComment(@PathParam("messegesId") long messegeId,
								@PathParam("commentId") long commentId, Comment comment){
		comment.setId(commentId);
		return commentService.updateComment(messegeId, comment);
	}
	
	@DELETE
	@Path("/{messegesId}")
	public void removeComment(@PathParam("messegesId") long messegeId,
							  @PathParam("commentId") long commentId){
		commentService.removeComment(messegeId, commentId);
	}
}
