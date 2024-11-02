package com.springmvc.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "room_types")
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_type_id")
    private int roomTypeId;
    
    @Column(name = "room_type_name", nullable = false, unique = true)
    private String roomTypeName;
    
    @Column(name = "room_type_price", nullable = false)
    private double roomTypePrice;
    
    @Column(name = "room_description")
    private String description;
    
    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Room> rooms = new ArrayList<>();
    
    public RoomType() {
        super();
    }
    
    public RoomType(String roomTypeName, double roomTypePrice, String description) {
        this.roomTypeName = roomTypeName;
        this.roomTypePrice = roomTypePrice;
        this.description = description;
    }
    
    public int getRoomTypeId() {
        return roomTypeId;
    }
    
    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }
    
    public String getRoomTypeName() {
        return roomTypeName;
    }
    
    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }
    
    public double getRoomTypePrice() {
        return roomTypePrice;
    }
    
    public void setRoomTypePrice(double roomTypePrice) {
        this.roomTypePrice = roomTypePrice;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<Room> getRooms() {
        return rooms;
    }
    
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
    
    public void addRoom(Room room) {
        rooms.add(room);
        room.setRoomType(this);
    }
    
    public void removeRoom(Room room) {
        rooms.remove(room);
        room.setRoomType(null);
    }
}