package com.bvpieee.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bvpieee.R

class ChapterPagerAdapter : RecyclerView.Adapter<ChapterPagerAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int = 5

    override fun getItemViewType(position: Int): Int {
        return R.layout.rect_view
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(position)
        holder.image.setOnClickListener {
            //call activity
//            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    inner class RecyclerViewHolder(val item: View) : RecyclerView.ViewHolder(item) {

        val image: ImageView = item.findViewById(R.id.image)

        fun bind(position: Int) {
            val image = item.findViewById<ImageView>(R.id.image)

            when {
                position == 0 -> {
                    image.setImageDrawable(
                        ContextCompat.getDrawable(
                            image.context,
                            R.drawable.raspp
                        )
                    )
                }
                position == 1 -> {
                    image.setImageDrawable(
                        ContextCompat.getDrawable(
                            image.context,
                            R.drawable.iaspp
                        )
                    )
                }
                position == 2 -> {
                    image.setImageDrawable(
                        ContextCompat.getDrawable(
                            image.context,
                            R.drawable.cspp
                        )
                    )
                }
                position == 3 -> {
                    image.setImageDrawable(
                        ContextCompat.getDrawable(
                            image.context,
                            R.drawable.wiepp
                        )
                    )
                }
                else -> {
                    image.setImageDrawable(
                        ContextCompat.getDrawable(
                            image.context,
                            R.drawable.hknpp
                        )
                    )
                }
            }
        }

    }

}