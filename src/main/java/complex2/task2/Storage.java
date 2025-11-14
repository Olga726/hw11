package complex2.task2;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Video> videoList = new ArrayList<>();

    public Storage(List<Video> videoList) {
        this.videoList = videoList;
    }

    public List<Video> getVideoList(){
        return videoList;
    }

    public void addVideo(Video video){
        videoList.add(video);
    }

    public Video getVideo(String path){
        return videoList.stream()
                .filter(v -> v.getPath().equals(path))
                .findFirst()
                .orElseThrow(()-> new VideoNotFoundException("Video not found: " + path));
    }
}
