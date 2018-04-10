package com.savion.mvpreader.model.parse

import com.savion.mvpreader.model.bean.Tab
import org.json.JSONObject

/**
 * Created by Administrator on 2017-12-29.
 */
class TabsParse(var strArray: Array<String>) : ParseTemp<ArrayList<Tab>>() {

    fun parseTabJson(str: String): Tab {
        val str = JSONObject(str)
        var tab = Tab()
        if (str.has("id"))
            tab.id = str.getString("id")
        if (str.has("tag"))
            tab.tag = str.getString("tag")
        if (str.has("isRemote"))
            tab.isIsRemote = str.getBoolean("isRemote")
        if (str.has("parent"))
            tab.parent = str.getString("parent")
        if (str.has("target"))
            tab.target = str.getString("target")
        if (str.has("title"))
            tab.title = str.getString("title")
        return tab
    }

    override fun parse(): ArrayList<Tab> {
        var tabs = ArrayList<Tab>()
        for (str in strArray) {
            tabs.add(parseTabJson(str))
        }
        return tabs;
    }

    override fun hook(): Boolean {
        return true
    }
}