package cn.qingyandark.pojo;

public class Area {
    private int id;
    private int code;
    private String name;
    private int pcode;

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", pcode=" + pcode +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPcode() {
        return pcode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }
}
