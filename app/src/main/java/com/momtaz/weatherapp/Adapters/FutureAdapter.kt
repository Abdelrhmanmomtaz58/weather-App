package com.momtaz.weatherapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.momtaz.weatherapp.Domains.FutureDomain
import com.momtaz.weatherapp.Domains.Hourly
import com.momtaz.weatherapp.R

class FutureAdapter(private val list:ArrayList<FutureDomain>) :RecyclerView.Adapter<FutureAdapter.ViewHolder>(){
    lateinit var  context:Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =LayoutInflater.from(parent.context).inflate(R.layout.viewholder_future,parent,false)
        context=parent.context
        return ViewHolder(itemView)

    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            dayTxt.text=list[position].day
            statusTxt.text=list[position].status
            highTxt.text=list[position].highTemp.toString()
            lowTxt.text=list[position].lowTemp.toString()
        }



       val drawableResourceID:Int=holder.itemView.resources.getIdentifier(list[position].picPath,"drawable",holder.itemView.context.packageName)
        Glide.with(context).load(drawableResourceID)
            .into(holder.pic)


    }
    override fun getItemCount(): Int {
        return list.size

    }


    class ViewHolder(viewItem: View):RecyclerView.ViewHolder(viewItem) {
        var dayTxt: TextView=itemView.findViewById(R.id.dayTxt)
        var statusTxt: TextView=itemView.findViewById(R.id.statusTxt)
        var lowTxt:TextView=itemView.findViewById(R.id.lowTxt)
        var highTxt:TextView=itemView.findViewById(R.id.highTxt)
        var pic: ImageView=itemView.findViewById(R.id.pic)
    }
}