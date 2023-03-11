package page.codeberg.mzml.moviedb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import page.codeberg.mzml.moviedb.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
	private lateinit var binding : ActivityLoginBinding
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityLoginBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.btLogin.setOnClickListener {
			startActivity(Intent(this,DashboardActivity::class.java))
		}
	}
}