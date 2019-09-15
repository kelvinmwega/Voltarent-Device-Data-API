package com.vunyx.devicedataapiserver.DataProcessors;

import com.google.gson.JsonObject;
import com.vunyx.devicedataapiserver.database.DbConfig;
import org.springframework.beans.factory.annotation.Autowired;

public class SaveDevData {

    @Autowired
    DbConfig dbConfig = new DbConfig();

    public boolean SavaDeviceData(JsonObject devData, String db){
        try {
            dbConfig.database(db).save(devData);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
