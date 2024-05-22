package niit.entity;
//ʵ���ࣺ��Ӧ���ݿ���ֶ�
import java.util.Date;

public class User {
	//һ�� ����   ˽�л�
	private Integer  id;//user���id
	private  String userCode;//�˺�
	private  String  userName;//�û���
	private  String  userPassword;//����
	private  int  gender;//�Ա�
	private  Date birthday;//���գ�ע�����������ͣ����� java.util
	private  String  phone;//��ϵ��ʽ
	private  String  address;//��ַ
	private  Integer  userRole;//�û���ɫid��
	private   Integer  createdBy;//������
	private   Date    creationDate;//����ʱ��
	private  Integer  modifyBy;//�޸���
	private  Date   modifyDate;//�޸�����
	
	//��Ϊ�����������Ҫ��������������Ӳ�ѯ��������Ҫ�����ṩ��������
	private Integer age;//����
	private String userRoleName;//�û���ɫ����
	
	public User () {
		
	}
	
	public User(int id, String useName,String userPassword) {
	    this.id = id;
	    this.userName = useName;
	    this.userPassword = userPassword;
	}
	
	//�ṩget��set������������ɣ��Ҽ�-��source-��generate getters  and setters ->select all->generate ����
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	//����Ӧ�ø��������Զ���
	public Integer getAge() {
		Date date=new Date();//���ɵ�ǰ����
		age =date.getYear()-getBirthday().getYear();//��ȡ��ǰ���ڵ����-���յ���ݣ����ܵõ�����
		return age;
	}

	/*
	 * public void setAge(Integer age) { this.age = age; }
	 */
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	
	
	
	
	
	
	

}
