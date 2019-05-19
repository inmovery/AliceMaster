package hse.t.alicemaster.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import hse.t.alicemaster.R;

public class FilmsViewHolder extends RecyclerView.ViewHolder{

    ImageView mPoster;
    TextView mTitle;
    TextView mRating;
    TextView mDescription;
    LinearLayout mViewContainer;

    public FilmsViewHolder(View itemView){
        super(itemView);

        mViewContainer = (LinearLayout)itemView.findViewById(R.id.container);
        mTitle = (TextView)itemView.findViewById(R.id.title);
        mRating = (TextView)itemView.findViewById(R.id.rating);
        mDescription = (TextView)itemView.findViewById(R.id.description);
        mPoster = (ImageView)itemView.findViewById(R.id.poster);

    }
}