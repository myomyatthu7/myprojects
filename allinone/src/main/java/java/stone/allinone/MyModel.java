package java.stone.allinone;

public class MyModel {
    int profile;
    String name,mail;

    public MyModel(int profile, String name, String mail) {
        this.profile = profile;
        this.name = name;
        this.mail = mail;
    }

    public int getProfile() {
        return profile;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }
}
