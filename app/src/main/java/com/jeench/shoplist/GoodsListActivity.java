package com.jeench.shoplist;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jeench.shoplist.data.Item;
import com.jeench.shoplist.databinding.ShopListItemBinding;
import com.jeench.shoplist.ui.BindingListAdapter;
import com.jeench.shoplist.ui.LoadingDialog;

import java.util.List;

public class GoodsListActivity extends AppCompatActivity {
    public static final String TAG = GoodsListActivity.class.getCanonicalName();

    private BindingListAdapter<Item, ShopListItemBinding> adapter;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);

        initGoodsListView();

        FragmentManager fragmentManager = getSupportFragmentManager();
        loadingDialog = (LoadingDialog) fragmentManager.findFragmentByTag(LoadingDialog.TAG);
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog();
            loadingDialog.show(fragmentManager, LoadingDialog.TAG);
        }

        ViewModelProviders
                .of(this)
                .get(GoodsListActivityViewModel.class)
                .get()
                .observe(this, this::onItemsLoaded);
    }

    private void initGoodsListView() {
        adapter = new BindingListAdapter<Item, ShopListItemBinding>() {

            @Override
            protected ShopListItemBinding createBinding(ViewGroup parent) {
                ShopListItemBinding binding = ShopListItemBinding.inflate(LayoutInflater.from(GoodsListActivity.this), parent, false);
                return binding;
            }

            @Override
            protected void bind(ShopListItemBinding binding, Item item) {
                binding.setItem(item);
                binding.textView.setOnClickListener(v -> {
                    Toast
                            .makeText(v.getContext(), getString(R.string.open_now_stub_text), Toast.LENGTH_SHORT)
                            .show();
                });
            }
        };

        RecyclerView goodsList = findViewById(R.id.goodsList);
        goodsList.setAdapter(adapter);
    }

    private void onItemsLoaded(List<Item> response) {
        loadingDialog.dismiss();
        adapter.setItems(response);
    }

    @Override
    public void onBackPressed() {
        if (!loadingDialog.isResumed()) {
            super.onBackPressed();
        }
    }
}
