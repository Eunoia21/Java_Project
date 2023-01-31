package dto;
/*
 * CREATE TABLE Yes24 (
 num number(5) primary key,
 Category NVARCHAR2(1000),
 Title NVARCHAR2(1000), 
 Price NVARCHAR2(20), 
 Summary VARCHAR2(4000),
 Author NVARCHAR2(1000), 
 Pub NVARCHAR2(1000),
 Grade NVARCHAR2(10)
);
 * 
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookVO {

	private int num;
	private String category;
	private String title;
	private int price;
	private String summary;
	private String author;
	private String pub;
	private String grade;
	private String pictureurl;
	

	
}
