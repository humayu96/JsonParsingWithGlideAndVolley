package com.example.jsonparsingwithglideandvolley.Adopter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.jsonparsingwithglideandvolley.Class.AboutMovies;
import com.example.jsonparsingwithglideandvolley.MoviesInfo;
import com.example.jsonparsingwithglideandvolley.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyMovieViewHolder> {

    RequestOptions options ;
    private Context mContext ;
     List<AboutMovies> aboutMovies;

    public RecyclerViewAdapter(Context mContext, List movies) {


        this.mContext = mContext;
        this.aboutMovies = movies;
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading)
                .error(R.drawable.loading);

    }

    @Override
    public MyMovieViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View view = inflater.inflate(R.layout.movies_item,viewGroup,false);

        final MyMovieViewHolder myMovieViewHolder1 = new MyMovieViewHolder(view);

        myMovieViewHolder1.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MoviesInfo.class);

           intent.putExtra("movie_name",aboutMovies.get(myMovieViewHolder1.getAdapterPosition()).getName());
             intent.putExtra("movie_category",aboutMovies.get(myMovieViewHolder1.getAdapterPosition()).getCategories());
             intent.putExtra("movie_studio",aboutMovies.get(myMovieViewHolder1.getAdapterPosition()).getStudio());
             intent.putExtra("movie_episode",aboutMovies.get(myMovieViewHolder1.getAdapterPosition()).getEpisode());
              intent.putExtra("movie_rating",aboutMovies.get(myMovieViewHolder1.getAdapterPosition()).getRating());
            intent.putExtra("movie_img",aboutMovies.get(myMovieViewHolder1.getAdapterPosition()).getImg());
               intent.putExtra("movie_description",aboutMovies.get(myMovieViewHolder1.getAdapterPosition()).getDescription());

               mContext.startActivity(intent);
            }
        });

        return myMovieViewHolder1;
    }

    @Override
    public void onBindViewHolder( MyMovieViewHolder myMovieViewHolder,final int i) {

        AboutMovies aboutMovies_bind = aboutMovies.get(i);
        myMovieViewHolder.txt_moviename.setText(aboutMovies_bind.getName());
        myMovieViewHolder.txt_moviestudio.setText(aboutMovies_bind.getStudio());
        myMovieViewHolder.txt_movierate.setText(aboutMovies_bind.getRating());
        myMovieViewHolder.txt_moviecategory.setText(aboutMovies_bind.getCategories());

        Glide.with(mContext).load(aboutMovies.get(i).getImg()).apply(options).into(myMovieViewHolder.movieimg);

    }

    @Override
    public int getItemCount() {
        return aboutMovies.size();
    }

    public class MyMovieViewHolder extends RecyclerView.ViewHolder{

        TextView txt_moviename , txt_moviecategory , txt_moviestudio , txt_movierate;
        ImageView movieimg;
        LinearLayout linearLayout;

        public MyMovieViewHolder(View itemView) {
            super(itemView);

            txt_moviename = itemView.findViewById(R.id.movie_name);
            txt_moviestudio = itemView.findViewById(R.id.studio);
            txt_movierate = itemView.findViewById(R.id.rating);
            txt_moviecategory = itemView.findViewById(R.id.categorie);
            movieimg = itemView.findViewById(R.id.thumbnail);
            linearLayout = itemView.findViewById(R.id.container);

        }
    }
}
