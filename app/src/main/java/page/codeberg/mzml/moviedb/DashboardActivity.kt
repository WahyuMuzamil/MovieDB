package page.codeberg.mzml.moviedb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import page.codeberg.mzml.moviedb.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
	private lateinit var binding: ActivityDashboardBinding
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityDashboardBinding.inflate(layoutInflater)
		setContentView(binding.root)

		val titles = arrayOf("Transformers", "Pacific Rim", "WALL-E", "TRON: Legacy")
		val releases = arrayOf("July 3, 2007", "July 12, 2013", "November 18, 2008", "December 17, 2010")
		val ratings = arrayOf("7.0/10", "6.9/10", "8.3/10", "6.8/10")
		val thumbs = arrayOf(R.drawable.thumb_one, R.drawable.thumb_two, R.drawable.thumb_three,
			R.drawable.thumb_four)
		val moviesInfo = R.array.movies_info
		val movies: ArrayList<Movie> = ArrayList()
		for((index, title: String) in titles.withIndex()){
			movies.add(Movie(title, releases[index], ratings[index], thumbs[index]))
		}

		with(binding){
			with(rvCategories){
				adapter = CategoryAdapter(listOf("Action", "Horror",	"Comedy", "Thriller", "Fantasy", "Sci-fi", "Motivation"))
				layoutManager = LinearLayoutManager(this@DashboardActivity, LinearLayoutManager.HORIZONTAL, false)
			}
			with(rvMovies){
				adapter = MovieAdapter(movies, object : MovieAdapter.OnAdapterListener {
					override fun onClick(title: String, date: String, rating: String, thumb: Int, position: Int) {
						val intent = Intent(applicationContext, InfoActivity::class.java)
						val summary = resources.getStringArray(moviesInfo)[position]
						intent.putExtra("title", title)
						intent.putExtra("date", date)
						intent.putExtra("rating", rating)
						intent.putExtra("thumb", thumb)
						intent.putExtra("summary", summary)
						startActivity(intent)
					}

				})
				layoutManager = LinearLayoutManager(this@DashboardActivity)
			}
		}
	}
}