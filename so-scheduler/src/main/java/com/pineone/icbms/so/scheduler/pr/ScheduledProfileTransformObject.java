package com.pineone.icbms.so.scheduler.pr;

/**
 * Created by melvin on 2016. 9. 6..
 */
//NOTE :  외부와 통신하기 위한 ScheduledProfile 형태
public class ScheduledProfileTransformObject {

    String profileId;
    int Period;

    public ScheduledProfileTransformObject() {
    }

    public ScheduledProfileTransformObject(String profileId, int period) {
        this.profileId = profileId;
        Period = period;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public int getPeriod() {
        return Period;
    }

    public void setPeriod(int period) {
        Period = period;
    }
}
