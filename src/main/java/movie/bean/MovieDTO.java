package movie.bean;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "movietable")

public class MovieDTO {
	

	@Column(name="img_url", nullable = false)
	private String img_url;	
	
	@Id 
	@Column(name = "movie_title", length = 100)
	private String movie_title;
	
	@Column(name="movie_grade", nullable = false, length = 100)
	private String movie_grade;
	
	@Column(name="movie_class", nullable = false, length = 100)
	private String movie_class;
	
	@Column(name="movie_release_start", nullable = false, length = 30)
	private String movie_release_start;	
	
	@Column(name="movie_release_end", nullable = false, length = 30)
	private String movie_release_end;
	
	@Column(name="movie_already_released", length = 5)
	private int movie_already_released;
	
	@Column(name="movie_like", length = 100)
	private int movie_like;
	
	@Column(name="movie_reserve_rate", length = 100)
	private String movie_reserve_rate;
	
	
}
