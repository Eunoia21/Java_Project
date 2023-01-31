package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * ID    NOT NULL VARCHAR2(20) 
PASS           VARCHAR2(20) 
NAME           VARCHAR2(10) 
PHONE          CHAR(15)     
EMAIL          VARCHAR2(20) 
LEV            CHAR(1)    
 * 
 */
@Getter
@Setter
@ToString
public class MemberVO {

	private String id;
	private String pass;
	private String name;
	private String phone;
	private String email;
	private String lev;
	
}
