package Users;

import Db.DbObject;

public class User extends DbObject {
   private String name;
   private int age;
   private String LoginName;
   private String password;

    public User(String name, int age, String loginName, String password) {
        super(loginName);
        this.name = name;
        this.age = age;
        this.LoginName = loginName;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String loginName) {
        LoginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString(){
        return "Object Id :"+getId()+"\n"+"User :"+"\n FullName :"+name+"\n Age :"+age+"\n LoginName :"+LoginName+"\n Password :"+password;
    }


}
