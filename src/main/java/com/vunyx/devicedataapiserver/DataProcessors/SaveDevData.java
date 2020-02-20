package com.vunyx.devicedataapiserver.DataProcessors;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.query.QueryBuilder;
import com.cloudant.client.api.query.QueryResult;
import com.cloudant.client.api.query.Selector;
import com.google.gson.JsonObject;
import com.vunyx.devicedataapiserver.database.DbConfig;
import org.springframework.beans.factory.annotation.Autowired;

import static com.cloudant.client.api.query.Expression.eq;

public class SaveDevData {

    @Autowired
    DbConfig dbConfig = new DbConfig();

    public boolean SavaDeviceData(JsonObject devData, String db){
        try {
            dbConfig.database(db).save(devData);
            updateDeviceData(devData, "devicesdb");
            return true;
        } catch (Exception e){
            return false;
        }
    }

    private boolean updateDeviceData(JsonObject devData, String db){
        try {
            Database devdb = dbConfig.database(db);
            Selector selector =  eq("id",devData.get("deviceid").getAsString());
            QueryResult<JsonObject> devices = devdb.query(new QueryBuilder(selector).build(), JsonObject.class);
            JsonObject device = devices.getDocs().get(0);
            device.addProperty("latestupdate", devData.get("timestamp").getAsString());
            devdb.update(device);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
