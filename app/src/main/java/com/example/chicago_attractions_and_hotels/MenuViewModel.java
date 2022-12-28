package com.example.chicago_attractions_and_hotels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MenuViewModel extends ViewModel {

    //Observer for the menu items
    private final MutableLiveData<Integer> selectedItem = new MutableLiveData<Integer>();

    public void selectItem(Integer item) {
        selectedItem.setValue(item);
    }
    public LiveData<Integer> getSelectedItem() {
        return selectedItem;
    }
}
