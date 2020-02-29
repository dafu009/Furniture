package FurnitureC.bean;

import java.util.List; //ListÁĞ±í
import java.util.Map;

public class GetList {
	
	private Integer id;	
	private List<Map<String,Object>> idlist;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Map<String, Object>> getIdlist() {
		return idlist;
	}
	public void setIdlist(List<Map<String, Object>> idlist) {
		this.idlist = idlist;
	}

}
