package com.momtaz.weatherapp.Activitis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.momtaz.weatherapp.Adapters.FutureAdapter
import com.momtaz.weatherapp.Domains.FutureDomain
import com.momtaz.weatherapp.R
import com.momtaz.weatherapp.databinding.ActivityFutureBinding

class FutureActivity : AppCompatActivity() {
    lateinit var binding: ActivityFutureBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapterTomorrow: RecyclerView.Adapter<FutureAdapter.ViewHolder>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFutureBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        callback()
    }

    private fun callback() {
        binding.back.setOnClickListener {
            val intent =Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initRecyclerView() {
        val items = ArrayList<FutureDomain>()
        items.add(FutureDomain("Set","storm","Storm",25,10))
        items.add(FutureDomain("Sun","cloudy","Cloudy",24,16))
        items.add(FutureDomain("Mon","windy","Windy",29,15))
        items.add(FutureDomain("Tue","cloudy_sunny","Cloudy Sunny",22,13))
        items.add(FutureDomain("Wen","sunny","Sunny",28,11))
        items.add(FutureDomain("Thu","rainy","Rainy",23,12))
        recyclerView=findViewById(R.id.view2)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterTomorrow= FutureAdapter(items)
        recyclerView.adapter=adapterTomorrow


    }
}