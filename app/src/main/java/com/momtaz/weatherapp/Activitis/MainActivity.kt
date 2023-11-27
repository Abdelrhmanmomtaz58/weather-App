package com.momtaz.weatherapp.Activitis

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.momtaz.weatherapp.Adapters.HoulyAdapter
import com.momtaz.weatherapp.Domains.Hourly
import com.momtaz.weatherapp.R
import com.momtaz.weatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var recyclerView: RecyclerView
   lateinit var  houlyAdapter:RecyclerView.Adapter<HoulyAdapter.ViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
         initRecycleview()
        callback()
    }

    private fun callback() {
        binding.next.setOnClickListener {
            val intent=Intent(this,FutureActivity::class.java)
            startActivity(intent)
        }

    }


    private fun initRecycleview() {
        if (binding.search.text.isEmpty())
        {
            binding.city.text="city"
        }else{
            binding.search.setOnClickListener {
                binding.city.text=binding.search.text
            }
        }
        binding.search.setOnClickListener {
            binding.city.text=binding.search.text
        }
        val list =ArrayList<Hourly>()
        list.add(Hourly("9 pm", 28,"cloudy"))
        list.add(Hourly("11 pm", 29,"sunny"))
        list.add(Hourly("12 pm", 30,"wind"))
        list.add(Hourly("1 am", 29,"rainy"))
        list.add(Hourly("2 am", 27,"storm"))
        recyclerView = findViewById(R.id.View1)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        houlyAdapter= HoulyAdapter(list)
        recyclerView.adapter=houlyAdapter


    }
}