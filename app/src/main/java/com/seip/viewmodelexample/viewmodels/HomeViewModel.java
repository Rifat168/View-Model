package com.seip.viewmodelexample.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<String> name;

    public LiveData<String> getName(){
        if (name != null){
            return name;
        }
        name = new MutableLiveData<>();
        name.postValue("Unknown");
        return name;

    }
    public  void setName(String name){
        this.name.postValue(name);
    }

}
