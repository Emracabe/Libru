package com.embre.libru;

import static com.embre.libru.BookActivity.BOOK_ID_KEY;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BooksRecViewAdapter extends RecyclerView.Adapter<BooksRecViewAdapter.ViewHolder> {

    ArrayList<Book> books = new ArrayList<>();
    Context context;
    String currentActivity;

    public BooksRecViewAdapter(Context context, String currentActivity) {
        this.context = context;
        this.currentActivity = currentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.books_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtBookName.setText(books.get(position).getName());

        Glide.with(context)
                .asBitmap()
                .load(books.get(position).getImageURL())
                .into(holder.bookImg);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BookActivity.class);
                intent.putExtra(BOOK_ID_KEY, books.get(position).getId());
                context.startActivity(intent);
            }
        });

        holder.txtAuthorName.setText(books.get(position).getAuthor());
        holder.txtShortDesc.setText(books.get(position).getShortDesc());

        String bookName = books.get(position).getName();

        if (books.get(position).isExpanded()) {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.VISIBLE);
            holder.btnDownArrow.setVisibility(View.GONE);

            if (currentActivity.equals("allBooks")) {
                holder.btnDelete.setVisibility(View.GONE);
            } else if (currentActivity.equals("currentlyRead")) {
                holder.btnDelete.setVisibility(View.VISIBLE);

                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Are you sure you want to delete " + books.get(position).getName() + "?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromCurrentlyRead(books.get(position))) {
                                    Toast.makeText(context, bookName + " Deleted", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                } else {
                                    Toast.makeText(context, "Something went wrong, please try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            } else if (currentActivity.equals("wantToRead")) {
                holder.btnDelete.setVisibility(View.VISIBLE);

                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Are you sure you want to delete " + books.get(position).getName());
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromWantToRead(books.get(position))) {
                                    Toast.makeText(context, bookName + " Deleted", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                } else {
                                    Toast.makeText(context, "Something went wrong, please try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            } else if (currentActivity.equals("alreadyRead")) {
                holder.btnDelete.setVisibility(View.VISIBLE);

                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Are you sure you want to delete " + bookName + "?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromAlreadyRead(books.get(position))) {
                                    Toast.makeText(context, bookName + " Deleted", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                } else {
                                    Toast.makeText(context, "Something went wrong, please try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            } else if (currentActivity.equals("favorite")) {
                holder.btnDelete.setVisibility(View.VISIBLE);

                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                                .setMessage("Are you sure you want to delete " + books.get(position).getName() + "?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance().removeFromFavorite(books.get(position))) {
                                    Toast.makeText(context, bookName + " Deleted", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                } else  {
                                    Toast.makeText(context, "Something went wrong, please try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }
        } else {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.GONE);
            holder.btnDownArrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return this.books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView bookImg;
        private TextView txtBookName;
        private CardView parent;

        private ImageView btnDownArrow, btnUpArrow;
        private TextView txtAuthorName, txtShortDesc;
        private RelativeLayout expandedRelLayout;

        private TextView btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bookImg = itemView.findViewById(R.id.bookImg);
            txtBookName = itemView.findViewById(R.id.txtBookName);
            parent = itemView.findViewById(R.id.parent);

            btnDownArrow = itemView.findViewById(R.id.btnDownArrow);
            btnUpArrow = itemView.findViewById(R.id.btnUpArrow);
            txtAuthorName = itemView.findViewById(R.id.txtAuthorName);
            txtShortDesc = itemView.findViewById(R.id.txtShortDesc);

            expandedRelLayout = itemView.findViewById(R.id.expandedRelLayout);

            btnDelete = itemView.findViewById(R.id.btnDelete);

            btnDownArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            btnUpArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
