package complex2.task2;

public class VideoService {
    private AVIAdapter aviAdapter;
    private MOVAdapter movAdapter;
    private WMVAdapter wmvAdapter;
    private Stream stream;
    private Storage storage;

    public VideoService(AVIAdapter aviAdapter, MOVAdapter movAdapter, WMVAdapter wmvAdapter, Stream stream, Storage storage) {
        this.aviAdapter = aviAdapter;
        this.movAdapter = movAdapter;
        this.wmvAdapter = wmvAdapter;
        this.stream = stream;
        this.storage = storage;
    }

    public Video uploadVideo(String videoPath){
        return storage.getVideo(videoPath);
    }

    public void streamMP4video(Video video){
        stream.streamVideo(video.getId());
    }

    public void streamAVIvideo(Video video){
        Video converted = aviAdapter.convertVideo(video);
        storage.addVideo(converted);
        stream.streamVideo(converted.getId());
    }

    public void streamMOVvideo(Video video){
        Video converted = movAdapter.convertVideo(video);
        storage.addVideo(converted);
        stream.streamVideo(converted.getId());
    }

    public void streamWMVvideo(Video video){
        Video converted = wmvAdapter.convertVideo(video);
        storage.addVideo(converted);
        stream.streamVideo(converted.getId());
    }

    public void streamVideo(Video video){
        if(video.getFormat().equals(Format.MP4)){
            streamMP4video(video);
        } else if (video.getFormat().equals(Format.AVI)){
            streamAVIvideo(video);
        } else if (video.getFormat().equals(Format.MOV)){
            streamMOVvideo(video);
        } else if (video.getFormat().equals(Format.WMV)){
            streamWMVvideo(video);
        }

    }


}
