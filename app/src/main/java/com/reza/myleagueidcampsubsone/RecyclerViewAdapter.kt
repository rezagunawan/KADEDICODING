package com.reza.myleagueidcampsubsone

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class RecyclerViewAdapter(private val context: Context, private val items: List<Item>, private val listener:(Item) -> Unit) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  ViewHolder(ListItemUI().createView(
        AnkoContext.create(context, parent)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class ListItemUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui){
                verticalLayout(){
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(5)
                    orientation = LinearLayout.VERTICAL

                    cardView {
                        lparams(width = dip(175), height = dip(175))
                        verticalLayout(){
                            lparams(width = matchParent, height = matchParent)
                            padding = dip(16)
                            orientation = LinearLayout.VERTICAL
                            gravity = Gravity.CENTER

                            imageView {
                                id = R.id.image
                            }.lparams {
                                height = dip(75)
                                width = dip(75)
                                leftMargin = dip(5)
                            }

                            textView {
                                id = R.id.name
                                textSize = 14f
                                gravity = Gravity.CENTER_VERTICAL
                            }.lparams {
                                margin = dip(10)

                            }

                        }

                    }
                }


            }
        }
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer{

        fun bindItem(items: Item, listener: (Item) -> Unit) {

            itemView.name.text = items.name
            items.image?.let { Picasso.get().load(it).fit().into(image) }

            itemView.setOnClickListener {
                listener(items)
            }
        }

    }

}