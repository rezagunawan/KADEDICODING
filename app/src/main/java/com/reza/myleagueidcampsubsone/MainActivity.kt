package com.reza.myleagueidcampsubsone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private val items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            recyclerView {
                lparams(width = matchParent, height =  matchParent)
                layoutManager = GridLayoutManager(context, 2)
                adapter = RecyclerViewAdapter(context, items)
                {
                    startActivity<DetailLeagueActivity>(DetailLeagueActivity.EXTRA_LEAGUE to it)
                }
            }
        }

        initData()

    }

    private fun initData(){
        val id = resources.getIntArray(R.array.league_id)
        val name = resources.getStringArray(R.array.league_name)
        val image = resources.obtainTypedArray(R.array.league_image)
        val desc = resources.getStringArray(R.array.league_desc)
        items.clear()
        for(i  in name.indices){
            items.add(Item(id[i], name[i], image.getResourceId(i, 0), desc[i]))
        }
        image.recycle()
    }
}
