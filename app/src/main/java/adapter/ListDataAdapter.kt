package adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import entity.ListData
import net.nullife.tensionmention.R

import org.jetbrains.anko.layoutInflater

class ListAdapter : ArrayAdapter<ListData> {

    constructor(context: Context?, resource: Int) : super(context, resource)
    constructor(context: Context?, resource: Int, textViewResourceId: Int) : super(context, resource, textViewResourceId)
    constructor(context: Context?, resource: Int, objects: Array<out ListData>?) : super(context, resource, objects)
    constructor(context: Context?, resource: Int, textViewResourceId: Int, objects: Array<out ListData>?) : super(context, resource, textViewResourceId, objects)
    constructor(context: Context?, resource: Int, objects: MutableList<ListData>?) : super(context, resource, objects)
    constructor(context: Context?, resource: Int, textViewResourceId: Int, objects: MutableList<ListData>?) : super(context, resource, textViewResourceId, objects)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var newView = convertView ?: context.layoutInflater.inflate(R.layout.row, null)

        getItem(position)?.run {
            newView.findViewById<TextView>(R.id.rowTension).text = tension
            newView.findViewById<TextView>(R.id.rowDate).text = date
            newView.findViewById<TextView>(R.id.rowComment).text = comment
        }
        return newView
    }
}