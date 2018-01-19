package cloud.thecode.mazenelzoor;

/**
 * Created by Mazen on 1/19/2018.
 */

public class Book {
    int ID, publishID;
    String name, authors_name, topic, publisherName, publisherRegion, longitude, latitude;
    double price;

    public Book() {
    }

    public Book(int publishID, String name, String authors_name, String topic, double price) {
        this.publishID = publishID;
        this.name = name;
        this.authors_name = authors_name;
        this.topic = topic;
        this.price = price;
    }

    public Book(int ID, int publishID, String name, String authors_name, String topic, double price) {
        this.ID = ID;
        this.publishID = publishID;
        this.name = name;
        this.authors_name = authors_name;
        this.topic = topic;
        this.price = price;
    }

    public Book(int ID, int publishID, String name, String authors_name, String topic, String publisherName, String publisherRegion, String longitude, String latitude, double price) {
        this.ID = ID;
        this.publishID = publishID;
        this.name = name;
        this.authors_name = authors_name;
        this.topic = topic;
        this.publisherName = publisherName;
        this.publisherRegion = publisherRegion;
        this.longitude = longitude;
        this.latitude = latitude;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPublishID() {
        return publishID;
    }

    public void setPublishID(int publishID) {
        this.publishID = publishID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthors_name() {
        return authors_name;
    }

    public void setAuthors_name(String authors_name) {
        this.authors_name = authors_name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherRegion() {
        return publisherRegion;
    }

    public void setPublisherRegion(String publisherRegion) {
        this.publisherRegion = publisherRegion;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String toString() {
        return "Name: " + name + "\nAuthor's name: " + authors_name + "\nPrice: $" + price + "\nTopic: " + topic + "\nPublisher: " + publisherName + "\nRegion: " + publisherRegion;
    }
}
