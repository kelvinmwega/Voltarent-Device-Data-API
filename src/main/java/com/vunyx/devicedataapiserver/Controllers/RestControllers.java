package com.vunyx.devicedataapiserver.Controllers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vunyx.devicedataapiserver.DataProcessors.SaveDevData;
import com.vunyx.devicedataapiserver.database.CloudantClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestControllers {

    private CloudantClient cloudantClient = new CloudantClient();
    private SaveDevData saveDevData = new SaveDevData();
    private JsonParser parser = new JsonParser();

    @CrossOrigin
    @RequestMapping(value = "/wlmdata",  method = RequestMethod.POST, headers="Accept=application/json")
    public ResponseEntity<Boolean> wlmData(@RequestBody  String data) throws Exception{
        System.out.println(data);
        return new ResponseEntity<>(saveDevData.SavaDeviceData(parser.parse(data).getAsJsonObject(), "wlm"), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/emddata",  method = RequestMethod.POST, headers="Accept=application/json")
    public ResponseEntity<Boolean> emdData(@RequestBody  String data) throws Exception{
        System.out.println(data);
        return new ResponseEntity<>(saveDevData.SavaDeviceData(parser.parse(data).getAsJsonObject(), "emd"), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/ghdata",  method = RequestMethod.POST, headers="Accept=application/json")
    public ResponseEntity<Boolean> ghData(@RequestBody  String data) throws Exception{
        System.out.println(data);
        return new ResponseEntity<>(saveDevData.SavaDeviceData(parser.parse(data).getAsJsonObject(), "wlm"), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/getRegisteredDevices", method = RequestMethod.GET)
    public ResponseEntity<String> getRegisteredDevices(){
        return new ResponseEntity<>(cloudantClient.getRegDevices().getDocs().toString(), HttpStatus.OK);
    }
}
