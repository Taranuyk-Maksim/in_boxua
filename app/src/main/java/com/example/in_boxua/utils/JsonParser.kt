//package com.example.in_boxua
//
//import org.json.JSONArray
//import org.json.JSONObject
//import java.io.IOException
//import java.io.InputStream
//
//class JsonParser {
//    fun getStringFromJsonFile() : String{
//        val jsonStrng : String
//        try{
//            val ips : InputStream = resources.openRawResource(R.raw.day)
//            val size = ips.available()
//            val buffer = ByteArray(size)
//            ips.read(buffer)
//            ips.close()
//            jsonStrng = String(buffer, Charsets.UTF_8)
//
//        }catch (ex : IOException){
//            ex.printStackTrace()
//            return "IOException"
//        }
//        return jsonStrng
//    }
//
//    fun createDay(jsArray: JSONArray) : ArrayList<Lesson>{
//
//        val  day  = ArrayList<Lesson> ()
//
//        for(n in 0 until jsArray.length()) {
//            val less: JSONObject = jsArray.getJSONObject(n)
//            day.add(Lesson(
//                less.getString("time"),
//                less.getString("lessonsName"),
//                less.getString("auditory"),
//                less.getString("type"),
//                less.getString("professors")))
//        }
//        return day
//    }
//
//    fun parseJsonToJSONArray(json : String) : JSONArray {
//
//        val jsObj = JSONObject(json.substring(json.indexOf("{"),
//            json.lastIndexOf("}") + 1))
//        val jsArray : JSONArray = jsObj.getJSONArray("monday")
//
//        return jsArray
//    }
//
//}