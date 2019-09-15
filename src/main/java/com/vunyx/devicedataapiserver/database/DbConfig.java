package com.vunyx.devicedataapiserver.database;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import org.springframework.stereotype.Service;

@Service
public class DbConfig {

    public Database database(String dbName){

        String user = "15489ce4-1884-46c2-ab6f-47798cad2a5b-bluemix";
        String password = "78f015059b952321ac22eaea9183f1d35f284074036220c07b59c9fe265e186d";

        CloudantClient client = ClientBuilder.account(user)
                .username(user)
                .password(password)
                .build();

        return client.database(dbName, false);
    }

}
