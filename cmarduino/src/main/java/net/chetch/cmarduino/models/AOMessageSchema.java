package net.chetch.cmarduino.models;

import net.chetch.cmarduino.data.AOData;
import net.chetch.utilities.SLog;
import net.chetch.messaging.MessageSchema;

import java.util.Map;

public class AOMessageSchema extends MessageSchema {

   static public final String AO_PREFIX = "AO:";
   static public String sanitiseID(String id){
      id = id.replace('_', '-');
      return id;
   }

   static public String statusCommand(String aoid){
      return "adm:" + sanitiseID(aoid) + ":status";
   }
   static public String enableCommand(String aoid){
      return "adm:" + sanitiseID(aoid) + ":enable";
   }

   static public String fn(String fieldName){
      return AO_PREFIX + fieldName;
   }

   public void assignAOData(AOData aodata){
      aodata.enable(message.getBoolean(fn("Enabled")));
      SLog.i("ERMS", "Setting enabled for " + message.getString(fn("UID")) + " to: " + message.getBoolean(fn("Enabled")));
   }

}