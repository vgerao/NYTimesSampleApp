package com.example.nytimesarticleapp.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.nytimesarticleapp.model.remotedata.services.Resource;
import com.example.nytimesarticleapp.view.base.BaseAdapter;

import java.util.List;

final class ArticlesListBindingAdapter {

    private ArticlesListBindingAdapter(){
    }

    @BindingAdapter(value = "resource")
    public static void setResource(RecyclerView recyclerView, Resource resource){
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if(adapter == null)
            return;

        if(resource == null || resource.data == null)
            return;

        if(adapter instanceof BaseAdapter){
            ((BaseAdapter)adapter).setData((List) resource.data);
        }
    }

}
