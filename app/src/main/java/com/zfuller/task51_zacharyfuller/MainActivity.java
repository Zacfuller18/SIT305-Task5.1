package com.zfuller.task51_zacharyfuller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final Context Context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        finds();
    }

    private void finds() {
        RecyclerView rv_Stories = findViewById(R.id.rv_Stories);
        RecyclerView rv_News = findViewById(R.id.rv_News);

        StoryAdapter adapter = new StoryAdapter(Context);
        LinearLayoutManager manager = new LinearLayoutManager(Context);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        rv_Stories.setLayoutManager(manager);
        rv_Stories.setAdapter(adapter);

        NewsAdapter newsAdapter = new NewsAdapter(Context);
        GridLayoutManager newsManager = new GridLayoutManager(Context, 2);
        newsManager.setOrientation(RecyclerView.VERTICAL);
        rv_News.setLayoutManager(newsManager);
        rv_News.addItemDecoration(new SpacesItemDecoration(10));
        rv_News.setAdapter(newsAdapter);
    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layout_Frame, fragment);
        transaction.addToBackStack("tag");
        transaction.commit();
    }

    public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.MyViewHolder> {

        public Context context;

        public StoryAdapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public StoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(context).inflate(R.layout.item_story, parent, false);

            return new StoryAdapter.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull StoryAdapter.MyViewHolder holder, int position) {

            if (position == 0) {
                holder.iv.setImageResource(R.drawable.one);
            } else if (position == 1) {
                holder.iv.setImageResource(R.drawable.two);
            } else if (position == 2) {
                holder.iv.setImageResource(R.drawable.three);
            } else if (position == 3) {
                holder.iv.setImageResource(R.drawable.four);
            } else if (position == 4) {
                holder.iv.setImageResource(R.drawable.five);
            } else if (position == 5) {
                holder.iv.setImageResource(R.drawable.six);
            } else if (position == 6) {
                holder.iv.setImageResource(R.drawable.seven);
            }

        }

        @Override
        public int getItemCount() {
            return 7;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            public ImageView iv;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                iv = itemView.findViewById(R.id.iv);

                itemView.setOnClickListener(view -> {

                    int res;

                    if (getAdapterPosition() == 0) {
                        res = R.drawable.one;
                        Fragment fragment = new HomeFragment(res, "Devil May Cry 5 Passes 5 Million Units Sold", "The latest in the acclaimed series of hack-and-slash games, Devil May Cry 5 hits a huge sales milestone following just over three years on the shelf.");
                        loadFragment(fragment);
                    } else if (getAdapterPosition() == 1) {
                        res = R.drawable.two;
                        Fragment fragment = new HomeFragment(res, "PS Plus Extra and Premium Pricing Revealed for Australia", "Some regions are already able to confirm the pricing of PS Plus' new tiers as official information drops on Sony's latest subscription service.");
                        loadFragment(fragment);
                    } else if (getAdapterPosition() == 2) {
                        res = R.drawable.three;
                        Fragment fragment = new HomeFragment(res, "AMD May Have Disabled Overclocking for Its Newly Released RX 6400", "AMD recently launched its low-end RX 6400 graphics card, but it seems as though it may have disabled overclocking, which could worry some PC users.");
                        loadFragment(fragment);
                    } else if (getAdapterPosition() == 3) {
                        res = R.drawable.four;
                        Fragment fragment = new HomeFragment(res, "20-Year-Old Free-to-Play Wolfenstein Game Releases on Steam", "The classic multiplayer shooter, Wolfenstein: Enemy Territory, finally receives a free-to-play release on Steam after nearly 20 years.");
                        loadFragment(fragment);
                    } else if (getAdapterPosition() == 4) {
                        res = R.drawable.five;
                        Fragment fragment = new HomeFragment(res, "Oblivion Modder Shows What the Town of Skingrad Looks Like in Unreal Engine 5", "Unreal Engine 5 has just been fully released and people are utilizing it to its fullest, which includes showing what Oblivion looks like in it.");
                        loadFragment(fragment);
                    } else if (getAdapterPosition() == 5) {
                        res = R.drawable.six;
                        Fragment fragment = new HomeFragment(res, "Quake Mod Turns the Classic FPS Into A LEGO Game", "A mod shows what happens when the fast-paced antics of Quake, one of the most influential FPS games ever, combines with the iconic aesthetics of LEGO.");
                        loadFragment(fragment);
                    } else if (getAdapterPosition() == 6) {
                        res = R.drawable.seven;
                        Fragment fragment = new HomeFragment(res, "New Kingdom Hearts 4 Story and Gameplay Details Revealed", "During a recent interview, Tetsuya Nomura discusses some elements of Kingdom Hearts 4's story and combat, including the new Build command.");
                        loadFragment(fragment);
                    }


                });
            }
        }
    }

    public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

        public Context context;

        public NewsAdapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public NewsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);

            return new NewsAdapter.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull NewsAdapter.MyViewHolder holder, int position) {

            if (position == 0) {
                holder.iv_Image.setImageResource(R.drawable.one);
                holder.tv_Title.setText("Devil May Cry 5 Passes 5 Million Units Sold");
                holder.tv_Desc.setText(("The latest in the acclaimed series of hack-and-slash games, Devil May Cry 5 hits a huge sales milestone following just over three years on the shelf."));
            } else if (position == 1) {
                holder.iv_Image.setImageResource(R.drawable.two);
                holder.tv_Title.setText("PS Plus Extra and Premium Pricing Revealed for Australia");
                holder.tv_Desc.setText(("Some regions are already able to confirm the pricing of PS Plus' new tiers as official information drops on Sony's latest subscription service."));
            } else if (position == 2) {
                holder.iv_Image.setImageResource(R.drawable.three);
                holder.tv_Title.setText("AMD May Have Disabled Overclocking for Its Newly Released RX 6400");
                holder.tv_Desc.setText(("AMD recently launched its low-end RX 6400 graphics card, but it seems as though it may have disabled overclocking, which could worry some PC users."));
            } else if (position == 3) {
                holder.iv_Image.setImageResource(R.drawable.four);
                holder.tv_Title.setText("20-Year-Old Free-to-Play Wolfenstein Game Releases on Steam");
                holder.tv_Desc.setText(("The classic multiplayer shooter, Wolfenstein: Enemy Territory, finally receives a free-to-play release on Steam after nearly 20 years."));
            } else if (position == 4) {
                holder.iv_Image.setImageResource(R.drawable.five);
                holder.tv_Title.setText("Oblivion Modder Shows What the Town of Skingrad Looks Like in Unreal Engine 5");
                holder.tv_Desc.setText(("Unreal Engine 5 has just been fully released and people are utilizing it to its fullest, which includes showing what Oblivion looks like in it."));
            } else if (position == 5) {
                holder.iv_Image.setImageResource(R.drawable.six);
                holder.tv_Title.setText("Quake Mod Turns the Classic FPS Into A LEGO Game");
                holder.tv_Desc.setText(("A mod shows what happens when the fast-paced antics of Quake, one of the most influential FPS games ever, combines with the iconic aesthetics of LEGO."));
            } else if (position == 6) {
                holder.iv_Image.setImageResource(R.drawable.seven);
                holder.tv_Title.setText("New Kingdom Hearts 4 Story and Gameplay Details Revealed");
                holder.tv_Desc.setText(("During a recent interview, Tetsuya Nomura discusses some elements of Kingdom Hearts 4's story and combat, including the new Build command."));
            } else if (position == 7) {
                holder.iv_Image.setImageResource(R.drawable.eight);
                holder.tv_Title.setText("New Xbox Game Pass Game for May 2022 Leaks Online");
                holder.tv_Desc.setText(("Xbox is expected to confirm the first half of its Game Pass May lineup in the coming days, but one game leaks online ahead of time."));
            }
        }

        @Override
        public int getItemCount() {
            return 8;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            public ImageView iv_Image;
            public TextView tv_Title, tv_Desc;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                iv_Image = itemView.findViewById(R.id.iv_Image);
                tv_Title = itemView.findViewById(R.id.tv_Title);
                tv_Desc = itemView.findViewById(R.id.tv_Desc);

                itemView.setOnClickListener(view -> {

                    int res = 0;
                    String title = tv_Title.getText().toString();
                    String desc = tv_Desc.getText().toString();

                    if (getAdapterPosition() == 0) {
                        res = R.drawable.one;
                    } else if (getAdapterPosition() == 1) {
                        res = R.drawable.two;
                    } else if (getAdapterPosition() == 2) {
                        res = R.drawable.three;
                    } else if (getAdapterPosition() == 3) {
                        res = R.drawable.four;
                    } else if (getAdapterPosition() == 4) {
                        res = R.drawable.five;
                    } else if (getAdapterPosition() == 5) {
                        res = R.drawable.six;
                    } else if (getAdapterPosition() == 6) {
                        res = R.drawable.seven;
                    } else if (getAdapterPosition() == 7) {
                        res = R.drawable.eight;
                    }

                    Fragment fragment = new HomeFragment(res, title, desc);
                    loadFragment(fragment);
                });
            }
        }
    }

    public static class HomeFragment extends Fragment {

        public View view;
        private final int res;
        private final String title;
        private final String desc;
        public ImageView iv_Image;
        public RecyclerView rv_Related;
        public TextView tv_Title, tv_Related, tv_Desc;

        public HomeFragment(int res, String title, String desc) {
            this.res = res;
            this.title = title;
            this.desc = desc;
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            view = inflater.inflate(R.layout.news_detail, container, false);
            finds();

            iv_Image.setImageResource(res);
            tv_Title.setText(title);
            tv_Desc.setText(desc);

            return view;
        }

        private void finds() {

            iv_Image = view.findViewById(R.id.iv_Image);
            tv_Title = view.findViewById(R.id.tv_Title);
            tv_Desc = view.findViewById(R.id.tv_Desc);
            tv_Related = view.findViewById(R.id.tv_Related);
            rv_Related = view.findViewById(R.id.rv_Related);

            RelatedAdapter adapter = new RelatedAdapter(getContext());
            LinearLayoutManager manager = new LinearLayoutManager(getContext());
            manager.setOrientation(RecyclerView.VERTICAL);
            rv_Related.setLayoutManager(manager);
            rv_Related.setAdapter(adapter);

        }


        public static class RelatedAdapter extends RecyclerView.Adapter<RelatedAdapter.MyViewHolder> {

            private final Context context;

            public RelatedAdapter(Context context) {
                this.context = context;
            }

            @NonNull
            @Override
            public RelatedAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(context).inflate(R.layout.item_related, parent, false);

                return new MyViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull RelatedAdapter.MyViewHolder holder, int position) {

                if (position == 0) {
                    holder.iv_Image.setImageResource(R.drawable.nine);
                    holder.tv_Title.setText("New Splatoon 3 Special Weapon Officially Revealed");
                    holder.tv_Desc.setText("A new Special Weapon coming to Splatoon 3 will let users capture their enemies' ink and turn it against them with a big blast.");
                } else if (position == 1) {
                    holder.iv_Image.setImageResource(R.drawable.ten);
                    holder.tv_Title.setText("2K Games Is Making Rocket League Competitor Gravity Goal");
                    holder.tv_Desc.setText("A recent leak suggests that 2K games is looking to make a clear rival to Psyonix's Rocket League called Gravity Goal, but it does have a few twists.");
                } else if (position == 2) {
                    holder.iv_Image.setImageResource(R.drawable.eleven);
                    holder.tv_Title.setText("The Walking Dead Game Was Very Nearly Set in The Left 4 Dead Universe");
                    holder.tv_Desc.setText("Telltale Games' The Walking Dead was a beloved adaptation of the then popular TV show, but a recent video shows that it was almost a different game.");
                }
            }

            @Override
            public int getItemCount() {
                return 3;
            }

            public static class MyViewHolder extends RecyclerView.ViewHolder {

                public ImageView iv_Image;
                public TextView tv_Title, tv_Desc;

                public MyViewHolder(@NonNull View itemView) {
                    super(itemView);

                    iv_Image = itemView.findViewById(R.id.iv_Image);
                    tv_Title = itemView.findViewById(R.id.tv_Title);
                    tv_Desc = itemView.findViewById(R.id.tv_Desc);

//                    itemView.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//
//                            int res = 0;
//                            String title = tv_Title.getText().toString();
//                            String desc = tv_Desc.getText().toString();
//
//                            if (getAdapterPosition() == 0) {
//                                res = R.drawable.one;
//                            } else if (getAdapterPosition() == 1) {
//                                res = R.drawable.two;
//                            } else if (getAdapterPosition() == 2) {
//                                res = R.drawable.three;
//                            } else if (getAdapterPosition() == 3) {
//                                res = R.drawable.four;
//                            } else if (getAdapterPosition() == 4) {
//                                res = R.drawable.five;
//                            } else if (getAdapterPosition() == 5) {
//                                res = R.drawable.six;
//                            } else if (getAdapterPosition() == 6) {
//                                res = R.drawable.seven;
//                            } else if (getAdapterPosition() == 7) {
//                                res = R.drawable.eight;
//                            }
//
//                            Fragment fragment = new HomeFragment(res, title, desc);
//                            loadFragment(fragment);
//                        }
//                    });
                }
            }
        }
    }

    public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private final int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.top = space;
            outRect.bottom = space;
        }
    }
}