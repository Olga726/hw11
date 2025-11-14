package complex2.task2;

import java.util.UUID;

public class WMVAdapter implements VideoAdapter{
    @Override
    public Video convertVideo(Video video) {
        System.out.println("Converting video id: " + video.getId() + " format: " + video.getFormat() + " to MP4 format");
        String newPath = video.getPath().replaceAll("\\.wmv$", ".mp4");
        return new Video(UUID.randomUUID().toString(), newPath, Format.MP4);
    }
}
