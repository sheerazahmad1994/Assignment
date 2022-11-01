package com.example.kids.core.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kids.R
import com.example.kids.databinding.ListItemArticleBinding
import java.util.*
import kotlin.collections.ArrayList

class ArticleAdapter(
    private val context: Context,
    private var dataList: ArrayList<com.example.kids.core.model.getarticles.Result>,
    private var onClick: OnClick
) :
    RecyclerView.Adapter<ArticleAdapter.BindViewHolder>(), Filterable {

    private var dataListFilter = ArrayList<com.example.kids.core.model.getarticles.Result>()

    init {
        dataListFilter = dataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindViewHolder {
        val rootView =
            ListItemArticleBinding.inflate(LayoutInflater.from(context), parent, false)

        return BindViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return dataListFilter.size
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(viewHolder: BindViewHolder, position: Int) {
        val item = dataList[position]

        viewHolder.itemBinding.tvHeading.text = item.title
        viewHolder.itemBinding.tvSubHeading.text = item.byline
        viewHolder.itemBinding.tvSection.text = item.source
        viewHolder.itemBinding.tvDate.text = item.published_date
        if (item.media.size > 0) {
            Glide.with(context).load(item.media[0].media_metadata[0].url)
                .apply(RequestOptions().centerCrop())
                .placeholder(R.drawable.ic_baseline_camera)
                .error(R.drawable.ic_baseline_camera)
                .into(viewHolder.itemBinding.ivIcon)
        }

        viewHolder.itemBinding.root.setOnClickListener {
            onClick.onItemClick(item)
        }
    }

    class BindViewHolder(val itemBinding: ListItemArticleBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {

                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    dataListFilter = dataList
                } else {
                    val resultList = ArrayList<com.example.kids.core.model.getarticles.Result>()
                    for (row in dataList) {
                        if (row.title.lowercase(Locale.ROOT).contains(
                                charSearch.lowercase(
                                    Locale.ROOT
                                )
                            )
                        ) {
                            resultList.add(row)
                        }
                    }
                    dataListFilter = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = dataListFilter
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                dataListFilter =
                    results?.values as ArrayList<com.example.kids.core.model.getarticles.Result>
                notifyDataSetChanged()
            }

        }
    }

    interface OnClick {
        fun onItemClick(data: com.example.kids.core.model.getarticles.Result)
    }
}