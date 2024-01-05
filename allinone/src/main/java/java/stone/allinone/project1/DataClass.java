package java.stone.allinone.project1;

public class DataClass {
//
//    private String dataTitle;
//    private int dataDesc;
//    private String dataLang;
//    private int dataImage;
//
//    public String getDataTitle() {
//        return dataTitle;
//    }
//
//    public int getDataDesc() {
//        return dataDesc;
//    }
//
//    public String getDataLang() {
//        return dataLang;
//    }
//
//    public int getDataImage() {
//        return dataImage;
//    }
//
//    public DataClass(String dataTitle, int dataDesc, String dataLang, int dataImage) {
//        this.dataTitle = dataTitle;
//        this.dataDesc = dataDesc;
//        this.dataLang = dataLang;
//        this.dataImage = dataImage;
//    }

    int dataImage,dataDesc;
    String dataTitle,dataLang;

    public DataClass(int dataImage, int dataDesc, String dataTitle, String dataLang) {
        this.dataImage = dataImage;
        this.dataDesc = dataDesc;
        this.dataTitle = dataTitle;
        this.dataLang = dataLang;
    }

    public int getDataImage() {
        return dataImage;
    }

    public int getDataDesc() {
        return dataDesc;
    }

    public String getDataTitle() {
        return dataTitle;
    }

    public String getDataLang() {
        return dataLang;
    }
}
