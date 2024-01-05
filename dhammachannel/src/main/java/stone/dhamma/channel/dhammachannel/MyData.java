package stone.dhamma.channel.dhammachannel;

public class MyData {
    private final String title;
    private final int dec;
    private final int uri;
    private final int translate;

    public MyData(String title, int dec, int uri, int translate) {
        this.title = title;
        this.dec = dec;
        this.uri = uri;
        this.translate = translate;
    }

    public String getTitle() {
        return title;
    }

    public int getDec() {
        return dec;
    }

    public int getUri() {
        return uri;
    }

    public int getTranslate() {
        return translate;
    }
}
