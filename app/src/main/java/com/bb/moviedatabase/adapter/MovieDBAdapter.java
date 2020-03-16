package com.bb.moviedatabase.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View.OnClickListener;

import com.bb.moviedatabase.Activities.DetailActivity;
import com.bb.moviedatabase.Activities.MainActivity;
import com.bb.moviedatabase.R;
import com.bb.moviedatabase.model.Movie;

import java.util.List;

public class MovieDBAdapter extends RecyclerView.Adapter implements OnClickListener
{
    private Context mContext;
    private List<Movie> movieList;

    public MovieDBAdapter(Context applicationContext, List<Movie> movieList){
        this.mContext = mContext;
        this.movieList = movieList;
    }

    public <SwipeRefreshLayout, FavoriteDbHelper> MovieDBAdapter(MainActivity<FavoriteDbHelper,SwipeRefreshLayout> favoriteDbHelperSwipeRefreshLayoutMainActivity, List<Movie> movieList) {
    }

    public MyViewHolder onCreateViewHolder(int i, ViewGroup viewGroup)
    {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.movie_card, viewGroup, false);

            return new MyViewHolder(view);
        }

    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, userrating;
        public ImageView thumbnail;

        public MyViewHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            userrating = (TextView) view.findViewById(R.id.userrating);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

            view.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View v){
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        Movie clickedDataItem = movieList.get(pos);
                        Intent intent = new Intent(mContext, DetailActivity.class);
                        intent.putExtra("original_title", movieList.get(pos).getOriginalTitle());
                        intent.putExtra("poster_path", movieList.get(pos).getPosterPath());
                        intent.putExtra("overview", movieList.get(pos).getOverview());
                        intent.putExtra("vote_average", movieList.get(pos).getVoteAverage());
                        intent.putExtra("release.date", movieList.get(pos).getReleaseDate());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked" + clickedDataItem.getOriginalTitle(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }}