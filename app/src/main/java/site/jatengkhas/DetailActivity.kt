package site.jatengkhas

import android.content.Intent
import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val actionBar = supportActionBar
        actionBar!!.title = "Detail"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val img: ImageView = findViewById(R.id.imageView_detail)
        val tvTtitle: TextView = findViewById(R.id.textView_detail_title)
        val tvOrigin: TextView = findViewById(R.id.textView_detail_origin)
        val tvTaste: TextView = findViewById(R.id.textView_detail_taste)
        val tvHistory: TextView = findViewById(R.id.textView_detail_history)
        val tvIngredients: TextView = findViewById(R.id.textView_detail_ingredients)
        val tvTutorial: TextView = findViewById(R.id.textView_detail_tutorial)

        val dPhoto = intent.getStringExtra(EXTRA_PHOTO)
        val dTitle = intent.getStringExtra(EXTRA_TITLE)
        val dOrigin = intent.getStringExtra(EXTRA_ORIGIN)
        val dTaste = intent.getStringExtra(EXTRA_TASTE)
        val dHistory = intent.getStringExtra(EXTRA_HISTORY)
        val dIngredients = intent.getStringExtra(EXTRA_INGREDIENTS)
        val dTutorial = intent.getStringExtra(EXTRA_TUTORIAL)

        Glide.with(this)
            .load(dPhoto)
            .apply(RequestOptions())
            .into(img)
        tvTtitle.text = dTitle
        tvOrigin.text = dOrigin
        tvTaste.text = dTaste
        tvHistory.text = Html.fromHtml(dHistory)
        tvIngredients.text = dIngredients
        tvTutorial.text = dTutorial
    }

    companion object{
        const val EXTRA_PHOTO = "photo"
        const val EXTRA_TITLE = "title"
        const val EXTRA_ORIGIN = "origin"
        const val EXTRA_TASTE = "taste"
        const val EXTRA_HISTORY = "history"
        const val EXTRA_INGREDIENTS = "ingredients"
        const val EXTRA_TUTORIAL = "tutorial"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> {
                val dTitle = intent.getStringExtra(EXTRA_TITLE)
                val dIngredients = intent.getStringExtra(EXTRA_INGREDIENTS)
                val dTutorial = intent.getStringExtra(EXTRA_TUTORIAL)

                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, dTitle+"\nBahan : \n"+dIngredients+"\n Langkah-langkah : \n"+dTutorial)
                startActivity(Intent.createChooser(intent, "Bagikan ke"))

            }
        }
        return super.onOptionsItemSelected(item)
    }
}
