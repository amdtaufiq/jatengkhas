package site.jatengkhas

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AdapterEat(val listEat: ArrayList<Eat>) : RecyclerView.Adapter<AdapterEat.EatListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EatListHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
        return EatListHolder(view)
    }

    override fun getItemCount(): Int {
        return listEat.size
    }

    override fun onBindViewHolder(holder: EatListHolder, position: Int) {
        val (photo, title, origin, taste, history, ingredients, tutorial) = listEat[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.img)

        holder.tvTtitle.text = title
        holder.tvHhistory.text = history

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val move = Intent(mContext, DetailActivity::class.java)
            move.putExtra(DetailActivity.EXTRA_PHOTO, photo)
            move.putExtra(DetailActivity.EXTRA_TITLE, title)
            move.putExtra(DetailActivity.EXTRA_ORIGIN, origin)
            move.putExtra(DetailActivity.EXTRA_TASTE, taste)
            move.putExtra(DetailActivity.EXTRA_HISTORY, history)
            move.putExtra(DetailActivity.EXTRA_INGREDIENTS, ingredients)
            move.putExtra(DetailActivity.EXTRA_TUTORIAL, tutorial)
            mContext.startActivity(move)
        }
    }

    inner class EatListHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvTtitle: TextView = itemView.findViewById(R.id.textView_title)
        var tvHhistory: TextView = itemView.findViewById(R.id.textView_detail_history);
        var img: ImageView = itemView.findViewById(R.id.imageView)
    }
}