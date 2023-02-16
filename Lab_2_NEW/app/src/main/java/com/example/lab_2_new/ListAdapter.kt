package com.example.lab_2_new

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide


class ListAdapter(context: Context, image: Array<String?>, name: Array<String?>) :
    BaseAdapter() {
    private val context: Context
    private val image: Array<String?>
    private val name: Array<String?>

    override fun getCount(): Int {
        return image.size
    }

    override fun getItem(i: Int): Any {
        return i
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, convertView: View?, parent: ViewGroup?): View? {
        var view: View? = convertView
        val viewHolder: ViewHolder
        if (view == null) {
            viewHolder = ViewHolder()
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_item, null, true)
            if (view != null) {
                viewHolder.name = view.findViewById(R.id.name)
            }
            viewHolder.image = view.findViewById(R.id.img)
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }
        viewHolder.name?.text = name[i]
        loadImage(viewHolder, i)
        return view
    }

    private fun loadImage(viewHolder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(image[position])
            .into(viewHolder.image!!)
    }

    init {
        this.context = context
        this.image = image
        this.name = name
    }
}
