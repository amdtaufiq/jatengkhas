package site.jatengkhas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvEat: RecyclerView
    private var list: ArrayList<Eat> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvEat = findViewById(R.id.rv)
        rvEat.setHasFixedSize(true)

        list.addAll(EatData.listData)
        showEatList()
    }

    private fun showEatList() {
        rvEat.layoutManager = LinearLayoutManager(this)
        val adapterEat = AdapterEat(list)
        rvEat.adapter = adapterEat
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_profile,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.me -> {
                val about = Intent(this, AboutActivity::class.java)
                startActivity(about)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
