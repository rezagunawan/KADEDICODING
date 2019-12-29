package com.reza.myleagueidcampsubsone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailLeagueActivity : AppCompatActivity() {

    private var name: String = ""
    private var desc: String = ""
    private var image: Int = 0
    lateinit var nameTextView: TextView
    lateinit var descTextView: TextView
    lateinit var imageLeagueView : ImageView

    companion object {
        const val EXTRA_LEAGUE = "extra_league"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        scrollView{
            verticalLayout{
                padding = dip(16)

                imageLeagueView = imageView()
                    .lparams(width = dip(100),
                        height = wrapContent) {
                        gravity = Gravity.CENTER }

                nameTextView = textView().lparams(width = wrapContent) {
                    margin = dip(10)
                    gravity = Gravity.CENTER
                }

                descTextView = textView().lparams(width = wrapContent) {
                    margin = dip(10)
                    gravity = Gravity.CENTER
                }

            }
        }

        val league = intent.getParcelableExtra(EXTRA_LEAGUE) as Item

        name = league.name.toString()
        desc = league.desc.toString()
        image = league.image ?: 0
        nameTextView.text = name
        descTextView.text = desc
        Glide.with(imageLeagueView).load(image).into(imageLeagueView)
    }
}
