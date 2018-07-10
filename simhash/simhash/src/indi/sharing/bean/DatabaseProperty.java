package indi.sharing.bean;

import java.util.List;

/**
 * @author Tan
 * @see this class define some regular roperties and methods for database
 *  
 */

public class DatabaseProperty {
	private String url;
	private String name;
	private String port;
	private String user;
	private String passwd;

	private String table;
	private String attribute;
	private List<String> content;
	//to store the information for the c

	public DatabaseProperty(String url, String name, String port, String user, String passwd, String table,
			String attribute, List<String> content) {
		super();
		this.url = url;
		this.name = name;
		this.port = port;
		this.user = user;
		this.passwd = passwd;
		this.table = table;
		this.attribute = attribute;
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDbname() {
		return name;
	}
	public void setDbname(String dbname) {
		this.name = dbname;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setCommon(String attribute) {
		this.attribute = attribute;
	}
	public List<String> getContent() {
		return content;
	}
	public void setContent(List<String> content) {
		this.content = content;
	}

}
