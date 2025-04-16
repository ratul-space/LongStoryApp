package com.example.longstoryapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ListView
import com.example.longstoryapp.R
import com.example.longstoryapp.adapters.ListViewAdapter
import com.example.longstoryapp.model.StoryClass

class MainActivity : AppCompatActivity() {
    var title = arrayOf(
        "Android Developers",
        "Game Developer",
        "AI Expert",
        "Web Developer",
        "Game Programmer",
        "Special Designer",
        "Programing",
        "Ultra Max"
    )
    var profile = intArrayOf(
        R.drawable.img,
        R.drawable.img_1,
        R.drawable.img_2,
        R.drawable.img_3,
        R.drawable.img_1,
        R.drawable.img_2,
        R.drawable.img_3,
        R.drawable.img
    )
    var time = arrayOf(
        "25 min ago",
        "4 min ago",
        "6 min ago",
        "37 min ago",
        "23 min ago",
        "12 min ago",
        "26 min ago",
        "13 min ago"
    )
    var comment = arrayOf(
        "ohh cool! Enjoy this app with your full potential",
        "ohh cool! Enjoy this app with your full potential",
        "ohh cool! Enjoy this app with your full potential",
        "ohh cool! Enjoy this app with your full potential",
        "ohh cool! Enjoy this app with your full potential",
        "ohh cool! Enjoy this app with your full potential",
        "ohh cool! Enjoy this app with your full potential",
        "ohh cool! Enjoy this app with your full potential",
    )
    private var storyClass: ArrayList<StoryClass>?= null
    private var listViewAdapter: ListViewAdapter?= null
    private var ls: ListView?= null
    lateinit var lf: LayoutInflater
    lateinit var headerView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.long_story_app)
        ls = findViewById(R.id.list)
        lf = this.layoutInflater
        headerView = lf.inflate(R.layout.header, null, false) as View
        ls!!.addHeaderView(headerView, null,false)
        storyClass = ArrayList()
        for (i in title.indices){
            val storyClassob = StoryClass(title[i], profile[i], time[i], comment[i] )
            storyClass!!.add(storyClassob)
        }
        listViewAdapter

    }
}