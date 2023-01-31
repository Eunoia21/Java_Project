package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartVO {
	
	/*
	 * 
CREATE TABLE CARTLIST(
    
    CARTNUM NUMBER(35) not null PRIMARY KEY,
    NUM NUMBER(20) not null,
    ID VARCHAR2(30) not null,
    PRICE NUMBER(20) not null,
    TITLE VARCHAR2(1000) not null,
    PICTUREURL VARCHAR2(4000) not null 
);

	 * 
	 */

	private int cartnum;
	private int num;
	private String id;
	private int price;
	private String title;
	private String pictureurl;
	
}
