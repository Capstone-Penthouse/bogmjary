package com.penthouse_bogmjary;

public class FolderData {
    String buildingAddress;

    public FolderData(){}
    public FolderData(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }
    public String getBuildingAddress(){
        return buildingAddress;
    }
    public void setBuildingAddress(String buildingAddress){
        this.buildingAddress = buildingAddress;
    }
}
