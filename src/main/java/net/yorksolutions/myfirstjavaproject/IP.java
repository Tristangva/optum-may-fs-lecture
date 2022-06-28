package net.yorksolutions.myfirstjavaproject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IP {
    @JsonProperty("ip")// tell jackson to map field to a json field called "ip"
                        //      When jackson is parsing jsom. then when the ip field appears,
                        //          Set this field's value to the ip fields value
                        //      when jackson is serializing to json, then the json object shall have a field
                        //          called ip with a value of this fields
    String ipAddress;
}
