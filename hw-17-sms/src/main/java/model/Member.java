package model;

public class Member {
    private String first;
    private int handle_id;
    private String image_path;
    private String last;
    private String middle;
    private String phone_number;
    private String service;
    private String thumb_path;

    public String getLast() {
        return last;
    }

    public String getFirst() {
        return first;
    }

    public int getHandle_id() {
        return handle_id;
    }

    public String getImage_path() {
        return image_path;
    }

    public String getMiddle() {
        return middle;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getService() {
        return service;
    }

    public String getThumb_path() {
        return thumb_path;
    }

    public Member(String first, int handle_id, String image_path, String last, String middle, String phone_number, String service, String thumb_path) {
        this.first = first;
        this.handle_id = handle_id;
        this.image_path = image_path;
        this.last = last;
        this.middle = middle;
        this.phone_number = phone_number;
        this.service = service;
        this.thumb_path = thumb_path;
    }

    public Member() {
    }
}
