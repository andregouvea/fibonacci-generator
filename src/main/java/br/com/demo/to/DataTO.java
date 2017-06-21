package br.com.demo.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataTO {
	private String url;
	private String rdp;
	private String user;
	private String passwd;
	private String accountId;
	private String accountPasswd;
	
	public DataTO(String url, String rdp, String user, String passwd, String accountId, String accountPasswd) {
		super();
		this.url = url;
		this.rdp = rdp;
		this.user = user;
		this.passwd = passwd;
		this.accountId = accountId;
		this.accountPasswd = accountPasswd;
	}

	public DataTO(){}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRdp() {
		return rdp;
	}

	public void setRdp(String rdp) {
		this.rdp = rdp;
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

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountPasswd() {
		return accountPasswd;
	}

	public void setAccountPasswd(String accountPasswd) {
		this.accountPasswd = accountPasswd;
	}

	@Override
	public String toString() {
		return "DataTO [getUrl()=" + getUrl() + ", getRdp()=" + getRdp() + ", getUser()=" + getUser() + ", getPasswd()="
				+ getPasswd() + ", getAccountId()=" + getAccountId() + ", getAccountPasswd()=" + getAccountPasswd()
				+ "]";
	}
}