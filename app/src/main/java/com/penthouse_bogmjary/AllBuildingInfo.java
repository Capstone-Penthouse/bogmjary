package com.penthouse_bogmjary;

public class AllBuildingInfo {
    int elec_y = 0;
    int gas_y = 0;
    int water_y = 0;
    int finalScore = 0;
    String buildingAddress;
    String moneyMethod;
    int bo;
    int monthMoney;
    String parking;
    String animal;
    String ev;
    String manageMoney;
    int big;
    String something;
    int monthlyFee;
    int otherScore;
    int pyonScore = 0;
    int sunScore = 0;

    public AllBuildingInfo(){
    }
    public AllBuildingInfo(int elec_y, int gas_y, int water_y, int finalScore,
                           String buildingAddress, String moneyMethod, int bo,
                           int monthMoney, String parking, String animal, String ev,
                           String manageMoney, int big, String something,
                           int monthlyFee, int otherScore,int pyonScore, int sunScore) {
        this.elec_y =elec_y;
        this.gas_y =gas_y;
        this.water_y = water_y;
        this.finalScore = finalScore;
        this.buildingAddress = buildingAddress;
        this.moneyMethod = moneyMethod;
        this.bo = bo;
        this.monthMoney = monthMoney;
        this.parking = parking;
        this.animal = animal;
        this.ev = ev;
        this.manageMoney = manageMoney;
        this.big = big;
        this.something = something;
        this.monthlyFee = monthlyFee;
        this.otherScore = otherScore;
        this.pyonScore = pyonScore;
        this.sunScore = sunScore;
    }

    public int getElec_y() {
        return elec_y;
    }

    public void setElec_y(int elec_y) {
        this.elec_y = elec_y;
    }

    public int getGas_y() {
        return gas_y;
    }

    public void setGas_y(int gas_y) {
        this.gas_y = gas_y;
    }

    public int getWater_y() {
        return water_y;
    }

    public void setWater_y(int water_y) {
        this.water_y = water_y;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }

    public String getMoneyMethod() {
        return moneyMethod;
    }

    public void setMoneyMethod(String moneyMethod) {
        this.moneyMethod = moneyMethod;
    }

    public int getBo() {
        return bo;
    }

    public void setBo(int bo) {
        this.bo = bo;
    }

    public int getMonthMoney() {
        return monthMoney;
    }

    public void setMonthMoney(int monthMoney) {
        this.monthMoney = monthMoney;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getEv() {
        return ev;
    }

    public void setEv(String ev) {
        this.ev = ev;
    }

    public String getManageMoney() {
        return manageMoney;
    }

    public void setManageMoney(String manageMoney) {
        this.manageMoney = manageMoney;
    }

    public int getBig() {
        return big;
    }

    public void setBig(int big) {
        this.big = big;
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(int monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public int getOtherScore() {
        return otherScore;
    }

    public void setOtherScore(int otherScore) {
        this.otherScore = otherScore;
    }

    public int getPyonScore() {
        return pyonScore;
    }

    public void setPyonScore(int pyonScore) {
        this.pyonScore = pyonScore;
    }

    public int getSunScore() {
        return sunScore;
    }

    public void setSunScore(int sunScore) {
        this.sunScore = sunScore;
    }
}
