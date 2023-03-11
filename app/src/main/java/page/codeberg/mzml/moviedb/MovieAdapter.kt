package page.codeberg.mzml.moviedb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(
	private val listData: List<Movie>, private val listener: OnAdapterListener): RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {



	inner class ListViewHolder(listView: View) : RecyclerView.ViewHolder(listView) {
		val nameFilm : TextView = itemView.findViewById(R.id.tv_movie_title)
		val dateFilm : TextView = itemView.findViewById(R.id.tv_movie_date)
		val ratingFilm : TextView = itemView.findViewById(R.id.tv_movie_rate)
		val image : ImageView = itemView.findViewById(R.id.iv_movie_thumbnail)
		val container: View = itemView.findViewById(R.id.rl_movies)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
		val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false)
		return ListViewHolder(view)
	}

	override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
		val data = listData[position]
		with(holder) {
			nameFilm.text = data.name
			dateFilm.text = data.date
			ratingFilm.text = data.rating
			image.setImageResource(data.image)
		}
		holder.container.setOnClickListener{
			listener.onClick(data.name, data.date, data.rating, data.image,position)
		}
	}

	override fun getItemCount(): Int {
		return listData.size
	}

	interface OnAdapterListener{
		fun onClick(title: String, date: String, rating: String, thumb: Int,position: Int)
	}
}