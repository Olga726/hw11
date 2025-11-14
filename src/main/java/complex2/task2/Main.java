package complex2.task2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Video v1 = new Video("jhjj", "path/example/1.avi", Format.AVI);
        Video v2 = new Video("jhjj2", "path/example/2.mov", Format.MOV);
        Video v3 = new Video("jhjj3", "path/example/3.wmv", Format.WMV);
        Video v4 = new Video("jhjj34", "path/example/4.mp4", Format.MP4);
        Storage storage = new Storage(new ArrayList<>());
        storage.addVideo(v1);
        storage.addVideo(v2);
        storage.addVideo(v3);
        storage.addVideo(v4);

        VideoService videoService = new VideoService(new AVIAdapter(), new MOVAdapter(), new WMVAdapter(), new Stream(), storage);

        try {
            Video video1 = videoService.uploadVideo("path/notInStorageExample/1.avi");
            videoService.streamVideo(video1);
        } catch (VideoNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Video video1 = videoService.uploadVideo("path/example/1.avi");
            videoService.streamVideo(video1);
        } catch (VideoNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Video video2 = videoService.uploadVideo("path/example/2.mov");
            videoService.streamVideo(video2);
        } catch (VideoNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Video video3 = videoService.uploadVideo("path/example/3.wmv");
            videoService.streamVideo(video3);
        } catch (VideoNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Video video4 = videoService.uploadVideo("path/example/4.mp4");
            videoService.streamVideo(video4);
        } catch (VideoNotFoundException e) {
            System.out.println(e.getMessage());
        }


        System.out.println(storage.getVideoList());
    }
}
