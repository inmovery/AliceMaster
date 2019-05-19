package hse.t.alicemaster.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import hse.t.alicemaster.HLSActivity;
import hse.t.alicemaster.Model.Data;
import hse.t.alicemaster.Model.Item;
import hse.t.alicemaster.R;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsViewHolder>{

    private Context mContext;
    private List<Films> mFilmsList;
    private RequestOptions option;

    public FilmsAdapter(Context context, List<Films> filmsList){
        mFilmsList = filmsList;
        mContext = context;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape);

    }

    //Инициализация holder
    @Override
    public FilmsViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView  = LayoutInflater.from(parent.getContext()).inflate(R.layout.films_row_item, parent, false);

        final FilmsViewHolder viewHolder = new FilmsViewHolder(itemView);
        viewHolder.mViewContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, HLSActivity.class);
                i.putExtra("title", mFilmsList.get(viewHolder.getAdapterPosition()).getTitle());
                i.putExtra("rating", mFilmsList.get(viewHolder.getAdapterPosition()).getRating());
                i.putExtra("description", mFilmsList.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("image", mFilmsList.get(viewHolder.getAdapterPosition()).getImage_url());
//                i.putExtra("adult", mFilmsList.get(viewHolder.getAdapterPosition()).getAdult());
//                i.putExtra("video", mFilmsList.get(viewHolder.getAdapterPosition()).getVideo_url());
//                i.putExtra("price", mFilmsList.get(viewHolder.getAdapterPosition()).getAdult());

                mContext.startActivity(i);

            }
        });

        return viewHolder;
    }
    //Привязка данных к элементам
    @Override
    public void onBindViewHolder(FilmsViewHolder holder, int position) {

        Glide.with(mContext).load(mFilmsList.get(position).getImage_url()).apply(option).into(holder.mPoster);

        Films data = mFilmsList.get(position);
        holder.mTitle.setText(data.getTitle());
        holder.mRating.setText(data.getRating().toString());
        holder.mDescription.setText(data.getDescription());
    }

    @Override
    public int getItemCount() {
        return mFilmsList.size();
    }


}
