package page.codeberg.mzml.moviedb

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import page.codeberg.mzml.moviedb.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
	private lateinit var binding: ActivityInfoBinding
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityInfoBinding.inflate(layoutInflater)
		setContentView(binding.root)

		val intent = intent
		val title: String? = intent.getStringExtra("title")
		val date: String? = intent.getStringExtra("date")
		val rating: String? = intent.getStringExtra("rating")
		val summary: String? = intent.getStringExtra("summary")
		val thumb: Int = intent.getIntExtra("thumb",0)

		findViewById<TextView>(R.id.tv_title_info).text = title
		findViewById<TextView>(R.id.tv_release).text = date
		findViewById<TextView>(R.id.tv_rating).text = rating
		findViewById<TextView>(R.id.tv_summary).text = summary
		findViewById<ImageView>(R.id.iv_info_image).setImageResource(thumb)
		findViewById<ConstraintLayout>(R.id.cl_info).setBackgroundResource(thumb)
	}
}