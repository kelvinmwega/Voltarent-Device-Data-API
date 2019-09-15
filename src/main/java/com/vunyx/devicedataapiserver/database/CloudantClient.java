package com.vunyx.devicedataapiserver.database;

import com.cloudant.client.api.query.QueryBuilder;
import com.cloudant.client.api.query.QueryResult;
import com.cloudant.client.api.query.Selector;
import com.cloudant.client.api.query.Sort;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;

import static com.cloudant.client.api.query.Expression.*;
import static com.cloudant.client.api.query.Operation.and;

public class CloudantClient {

    @Autowired
    DbConfig dbConfig = new DbConfig();

    public QueryResult getRegDevices(){
        Selector selector =  eq("selector","device");
        QueryResult<JsonObject> devices = dbConfig.database("devices").
                query(new QueryBuilder(selector).
                        build(), JsonObject.class);
        return devices;
    }

}
