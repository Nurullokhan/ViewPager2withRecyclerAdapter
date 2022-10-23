package com.example.viewpager2withrecycleradapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewpager2withrecycleradapter.adapters.RvAdapter
import com.example.viewpager2withrecycleradapter.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var itemList: ArrayList<String>
    private lateinit var adapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemList = ArrayList()
        itemList.add("https://getwalls.io/media/large/2019/12/minimalist-wallpaper-4k-large-340443173.jpg")
//        itemList.add("https://www.nawpic.com/media/2020/minimalist-nawpic-4.jpg")
//        itemList.add("https://i.pinimg.com/originals/55/9e/84/559e84fab7a7e48b0f36a70359f8b947.jpg")

        adapter = RvAdapter(itemList)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        )
        /**
         * Called to configure the tab for the page at the specified position. Typically calls [ ][TabLayout.Tab.setText], but any form of styling can be applied.
         *
         * @param tab The Tab which should be configured to represent the title of the item at the given
         * position in the data set.
         * @param position The position of the item within the adapter's data set.
         */
        { tab, position ->

            tab.text = itemList[position]

        }.attach()
    }
}