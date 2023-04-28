package Db;


import Exeptions.InValidPasswordException;
import Users.User;

import java.util.ArrayList;

public class MemoryDataBase {
    public static ArrayList<DbObject> DataBase = new ArrayList<>();
    public static boolean LogIn(String clogin, String cPasswd) throws InValidPasswordException {
        for(DbObject Do : DataBase ){
            if(Do instanceof User){
                User u =(User) Do;
                if(u.getLoginName().equals(clogin)){
                    if(u.getPassword().equals(cPasswd)){
                        CurrentUser=clogin;
                        return true;

                    }else{
                        throw new InValidPasswordException();
                    }
                }
            }

        }
        return false;
    }

    public static String CurrentUser;
}
