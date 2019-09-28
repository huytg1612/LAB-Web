/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytg.dtos;

/**
 *
 * @author SE130226
 */
public class ScheduleDTO {
    public int id;
    public String weekDay,openAt,closeAt;
    public int infoId;

    public ScheduleDTO(int id, String weekDay, String openAt, String closeAt, int infoId) {
        this.id = id;
        this.weekDay = weekDay;
        this.openAt = openAt;
        this.closeAt = closeAt;
        this.infoId = infoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getOpenAt() {
        return openAt;
    }

    public void setOpenAt(String openAt) {
        this.openAt = openAt;
    }

    public String getCloseAt() {
        return closeAt;
    }

    public void setCloseAt(String closeAt) {
        this.closeAt = closeAt;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }
    
    
}
