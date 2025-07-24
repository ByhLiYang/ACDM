/**
 * @Title:UserM.java
 * @Package:com.iasp.pageModel
 * @Description:TODO
 * @author:LM
 * @date 2013-12-4下午1:56:36
 * @version V1.0
 */
package com.hq.acdm.model.sys;

import java.io.Serializable;

/**
 * @author :LM
 * @ClassName:UserM
 * @Description:TODO
 * @date :2013-12-4下午1:56:36
 *
 *
 */
public class UserM implements Serializable {
	
	
	private String id = "";
	private String name = "";
	private String password = "";
	
	
	public UserM(){
		
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
