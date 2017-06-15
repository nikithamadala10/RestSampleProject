package sample.restproject.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sample.restproject.messenger.database.DatabaseClass;
import sample.restproject.messenger.model.Comment;
import sample.restproject.messenger.model.Messeges;

public class CommentService {

	private Map<Long, Messeges> messeges = DatabaseClass.getMesseges();
	
	public List<Comment> getAllComments(long messegeId){
		Map<Long, Comment> comments = messeges.get(messegeId).getComments();
		return new ArrayList <Comment>(comments .values());
	}
	
	public Comment getComments(long messegeId, long commentId){
		Map<Long, Comment> comments = messeges.get(messegeId).getComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(long messegeId, Comment comment){
		Map<Long, Comment> comments = messeges.get(messegeId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(),comment);
		return comment;
	}
	
	public Comment updateComment(long messegeId, Comment comment){
		Map<Long, Comment> comments = messeges.get(messegeId).getComments();
		if(comment.getId()<=0){
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messegeId, long commentId){
		Map<Long, Comment> comments = messeges.get(messegeId).getComments();
		return comments.remove(commentId);
	}
	
}
