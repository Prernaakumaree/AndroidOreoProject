package example.android.prerna.com.androidexampleproject.databinding.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import example.android.prerna.com.androidexampleproject.databinding.model.DataModel;

public class DataItemViewModel extends BaseObservable {

    private DataModel dataModel;

    public DataItemViewModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    @Bindable
    public String getTitle() {
        return !TextUtils.isEmpty(dataModel.getTitle()) ? dataModel.getTitle() : "";
    }
}
