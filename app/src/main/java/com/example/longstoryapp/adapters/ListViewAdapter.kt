package com.example.longstoryapp.adapters

import android.content.Context
import android.icu.text.Transliterator
import android.icu.text.Transliterator.Position
import android.util.Log.v
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.viewmodel.savedstate.R
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.longstoryapp.model.StoryClass
import kotlinx.coroutines.NonDisposableHandle.parent

class ListViewAdapter(
    private val mcontext: Context,
    private val storyClassArrayList: ArrayList<StoryClass>,
) : BaseAdapter() {
    override fun getCount(): Int {
        return storyClassArrayList.size
    }

    override fun getItem(position: Int): Any {
        return storyClassArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
        potion: Int,
        convertView: View?,
        parent: ViewGroup?,
    ): View {
        var convertView = convertView
        val viewHolder: ViewHolder
        if (convertView == null) {
            val layoutInflater = LayoutInflater.from(mcontext)
            convertView = layoutInflater.inflate(R.layout.list_item)
            viewHolder = ViewHolder()
            viewHolder.time = convertView!!.findViewById<View>(R.id.time) as TextView
            viewHolder.title = convertView!!.findViewById<View>(R.id.title) as TextView
            viewHolder.comment = convertView!!.findViewById<View>(R.id.comment) as TextView
            viewHolder.profile = convertView!!.findViewById<View>(R.id.profile) as ImageView
            convertView.tag = viewHolder
        }else{
            viewHolder = convertView.tag as ListViewAdapter.ViewHolder
        }
        val storyClass = getItem(potion) as StoryClass
        viewHolder.title!!.text = storyClass.title
        viewHolder.time!!.text = storyClass.time
        viewHolder.comment!!.text = storyClass.comment
        viewHolder.profile!!.setImageResource(storyClass.profile)
        return convertView
    }

    private inner class ViewHolder {
        internal val profile: ImageView? = null
        internal val title: TextView? = null
        internal val time: TextView? = null
        internal val comment: TextView? = null
    }

}

