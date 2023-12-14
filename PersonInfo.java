import javax.swing.*;
class PersonInfo {
private String name;
private String address;
private String phoneNum;
public PersonInfo(String n, String a, String p) {
name = n; address = a; phoneNum = p;
}
public void setName(String name){
    this.name=name;
}
public void setAddress(String address){
    this.address=address;
}
public void setPhoneNum(String phoneNum){
    this.phoneNum=phoneNum;
}
public String getName(){
    return name;
}
public String getAddress(){
    return address;
}
public String getPhoneNum(){
    return phoneNum;
}

public void print( ) {
JOptionPane.showMessageDialog(null, "name: " + name +" \naddress:" +address + " \nphone no:" +phoneNum);
}
}