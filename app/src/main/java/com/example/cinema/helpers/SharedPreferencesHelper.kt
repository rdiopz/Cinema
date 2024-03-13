package com.example.cinema.helpers

import android.content.Context
import android.text.BoringLayout

class SharedPreferencesHelper(context: Context) {
    private val appSharedPreferences = context.getSharedPreferences("APP_PREF",Context.MODE_PRIVATE)
    private fun saveData(key: String, value: String) {
        val editor = appSharedPreferences.edit()
        editor.putString(key,value)
        editor.apply()
    }
    public fun saveData(key:String, value: Boolean) {
        val editor = appSharedPreferences.edit()
        editor.putBoolean(key,value)
        editor.apply()
    }
    public fun getStringData(key:String) : String? {
        return appSharedPreferences.getString(key,"")
    }
    public fun getBooleanData(key:String) : Boolean {
        return appSharedPreferences.getBoolean(key,false)
    }
    public fun clearData(){
        val editor = appSharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

}