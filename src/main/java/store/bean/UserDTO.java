package store.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usertable")
public class UserDTO {
	@Id
	@Column(name="username")
	private String userName;
	
	@Column(name="password", nullable = false, length = 30)
	private String password;
}
