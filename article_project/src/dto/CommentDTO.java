package dto;

import java.time.LocalDateTime;

import common.CommonField;
import entity.Comment;

public class CommentDTO extends CommonField {
	private Long c_id;
	private Long article_id;
	private String c_name;
	private String c_content;

	@Override
	public String toString() {
		return "\t ㄴ" + c_id + "\t" + c_name + "\t" + c_content;
	}

	public CommentDTO() {

	}

	//comment를 commentDTO로 바꿔줌
	public static CommentDTO fromComment(Comment comment) {
		return new CommentDTO(
				comment.getC_id(),
				comment.getArticle_id(),
				comment.getC_name(),
				comment.getC_content(),
				comment.getInsertedDate(),
				comment.getUpdatedDate()
				);
	}
	
	public static Comment fromDTO(CommentDTO dto) {
		Comment comment = new Comment();
		comment.setC_id(dto.c_id);
		comment.setArticle_id(dto.article_id);
		comment.setC_name(dto.c_name);
		comment.setC_content(dto.c_content);
		comment.setInsertedDate(dto.getInsertedDate());
		if(dto.getUpdatedDate() != null) {
			comment.setUpdatedDate(dto.getUpdatedDate());
		}
		return comment;
	}

	public CommentDTO(Long c_id, Long article_id, String c_name, String c_content, LocalDateTime insertedDate,
			LocalDateTime updatedDate) {
		this.c_id = c_id;
		this.article_id = article_id;
		this.c_name = c_name;
		this.c_content = c_content;
		setInsertedDate(insertedDate);
		setUpdatedDate(updatedDate);
	}

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}

	public Long getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Long article_id) {
		this.article_id = article_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
}
