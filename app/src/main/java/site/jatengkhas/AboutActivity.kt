package site.jatengkhas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val actionbar = supportActionBar
        actionbar!!.title = "Tentang Saya"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val img: ImageView = findViewById(R.id.imageView_my_photo)
        val myName: TextView = findViewById(R.id.textView_my_name)
        val email: TextView = findViewById(R.id.textView_email)

        val aImg = "https://d17ivq9b7rppb3.cloudfront.net/small/avatar/202006101734360cd67ce591a985d058d040ae7a8a0544.png"
        val aName = "Ahmad Taufiq Hidayat"
        val aEmail = "ahmadtaufiqhdyt@gmail.com"

        Glide.with(this)
            .load(aImg)
            .apply(RequestOptions())
            .into(img)
        myName.text = aName
        email.text = aEmail
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
