package example.android.prerna.com.androidexampleproject.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import example.android.prerna.com.androidexampleproject.databinding.adapter.DataAdapter;
import example.android.prerna.com.androidexampleproject.databinding.model.DataModel;

import java.util.List;

public class RecyclerViewDataBinding {

    @BindingAdapter({"app:adapter", "app:data"})
    public void bind(RecyclerView recyclerView, DataAdapter adapter, List<DataModel> data) {
        recyclerView.setAdapter(adapter);
        adapter.updateData(data);
    }
}
