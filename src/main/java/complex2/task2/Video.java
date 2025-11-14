package complex2.task2;

public class Video {
    private String id;
    private String path;
    private Format format;


    public Video(String id, String path, Format format) {
        this.id = id;
        this.path = path;
        this.format = format;
    }

    public String getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public Format getFormat() {
        return format;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", format=" + format +
                '}';
    }
}
