package Model;

public class Date {
    private int day;
    private int month;
    private int year;
    public Date(int day, int month, int year){
        if(day < 0){
            this.day = 1;
        }
        if(day> 31){
            this.day = 31;
        }
        else this.day = day;

        if(month < 0){
            this.month = 1;
        }
        if(month> 12){
            this.month = 12;
        }
        else this.month = month;
        this.year = year;
    }
    public int getDay(){
        return this.day;
    }
    public int getMonth(){
        return this.month;
    }
    public int getYear(){
        return this.year;
    }
    public String toString(){
        return day + "/" + month + "/" + year;
    }
}
