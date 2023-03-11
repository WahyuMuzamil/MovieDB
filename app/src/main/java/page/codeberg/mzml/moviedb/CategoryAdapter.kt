package page.codeberg.mzml.moviedb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private val listData: List<String>): RecyclerView.Adapter<CategoryAdapter.ListViewHolder>() {
	inner class ListViewHolder(listView: View) : RecyclerView.ViewHolder(listView) {
		val nameCategory : TextView = itemView.findViewById(R.id.tv_categories)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
		val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent, false)
		return ListViewHolder(view)
	}

	override fun getItemCount(): Int {
		return listData.size
	}

	override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
		val data = listData[position]
		holder.nameCategory.text = data
	}
}