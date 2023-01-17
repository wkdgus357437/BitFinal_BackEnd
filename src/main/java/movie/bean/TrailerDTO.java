package movie.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="trailertable") 
public class TrailerDTO {
	
	@Id
	@Column(name="movie_title", nullable = false)
	private String movie_title;
	
	@Column(name="trailer_url1")
	private String trailer_url1;
	
	@Column(name="trailer_url2")
	private String trailer_url2;
	
	@Column(name="trailer_url3")
	private String trailer_url3;
	
	@Column(name="trailer_url4")
	private String trailer_url4;
	
	@Column(name="trailer_poster1")
	private String trailer_poster1;
	
	@Column(name="trailer_poster2")
	private String trailer_poster2;
	
	@Column(name="trailer_poster3")
	private String trailer_poster3;
	
	@Column(name="trailer_poster4")
	private String trailer_poster4;
	
	@Column(name="trailer_sub_title")
	private String trailer_sub_title;

}
