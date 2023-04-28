package Db;

public abstract class DbObject {
    private String TextValue;
    private Integer Id;
    private static Integer Cid=0;

    public DbObject(String textValue, Integer id) {
        TextValue = textValue;
        Id = id;
    }

    public DbObject(String textValue) {
        TextValue = textValue;
        Id=Cid;
        Cid=Cid+1;
    }

    public String getTextValue() {
        return TextValue;
    }

    public void setTextValue(String textValue) {
        TextValue = textValue;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
