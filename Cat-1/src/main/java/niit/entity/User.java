package niit.entity;
//实体类：对应数据库表字段
import java.util.Date;

public class User {
	//一般 属性   私有化
	private Integer  id;//user表的id
	private  String userCode;//账号
	private  String  userName;//用户名
	private  String  userPassword;//密码
	private  int  gender;//性别
	private  Date birthday;//生日：注意是日期类型：导包 java.util
	private  String  phone;//联系方式
	private  String  address;//地址
	private  Integer  userRole;//用户角色id号
	private   Integer  createdBy;//创建者
	private   Date    creationDate;//创建时间
	private  Integer  modifyBy;//修改者
	private  Date   modifyDate;//修改日期
	
	//因为后面这个表需要与其他表进行连接查询：所以需要额外提供以下属性
	private Integer age;//年龄
	private String userRoleName;//用户角色名称
	
	public User () {
		
	}
	
	public User(int id, String useName,String userPassword) {
	    this.id = id;
	    this.userName = useName;
	    this.userPassword = userPassword;
	}
	
	//提供get、set方法：快捷生成：右键-》source-》generate getters  and setters ->select all->generate 即可
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
	//年龄应该根据生日自动算
	public Integer getAge() {
		Date date=new Date();//生成当前日期
		age =date.getYear()-getBirthday().getYear();//获取当前日期的年份-生日的年份：就能得到年龄
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
