package example.android.prerna.com.androidexampleproject.databinding;

import android.databinding.DataBindingComponent;

public class AppDataBindingComponent implements DataBindingComponent {

    @Override
    public RecyclerViewDataBinding getRecyclerViewDataBinding() {
        return new RecyclerViewDataBinding();
    }
}
