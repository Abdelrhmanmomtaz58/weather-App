package com.momtaz.weatherapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.momtaz.weatherapp.Domains.Hourly
import com.momtaz.weatherapp.R

class HoulyAdapter(private val list:ArrayList<Hourly>) :RecyclerView.Adapter<HoulyAdapter.ViewHolder>(){
    lateinit var  context:Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =LayoutInflater.from(parent.context).inflate(R.layout.viewholder_hourly,parent,false)
        context=parent.context
        return ViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.hourtext.text=list[position].hour
        holder.tempTxt.text= list[position].temp.toString() +"°"
       val drawableResourceID:Int=holder.itemView.resources.getIdentifier(list[position].picPath,"drawable",holder.itemView.context.packageName)
        Glide.with(context).load(drawableResourceID)
            .into(holder.pic)


    }


    class ViewHolder(viewItem: View):RecyclerView.ViewHolder(viewItem) {
        var hourtext: TextView = itemView.findViewById(R.id.hourTxt)
        var tempTxt: TextView = itemView.findViewById(R.id.tempTxt)
        var pic: ImageView = itemView.findViewById(R.id.pic)
    }
}