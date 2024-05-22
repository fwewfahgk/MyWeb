package niit.entity;
public class Cat {
	private String  name;//名字
	private  String breed;//品种
	private  String  sex;//性别
	private  Integer  age;//年龄
	private  String  address;//出没地点
	private  String character;//性格
	private Integer  catnum;
	public String getName() {
		return name;
	}
	
	public Cat(String name, String breed, String sex, Integer age, String address, String character, Integer catnum) {
		super();
		this.name = name;
		this.breed = breed;
		this.sex = sex;
		this.age = age;
		this.address = address;
		this.character = character;
		this.catnum = catnum;
	}

	public Cat() {
		
	};
	
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public Integer getCatnum() {
		return catnum;
	}
	public void setCatnum(Integer catnum) {
		this.catnum = catnum;
	}
	
	
}
