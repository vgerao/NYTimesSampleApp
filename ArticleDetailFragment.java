package com.example.nytimesarticleapp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.nytimesarticleapp.R;
import com.example.nytimesarticleapp.common.Constants;
import com.example.nytimesarticleapp.databinding.FragmentArticleDetailsBinding;
import com.example.nytimesarticleapp.view.base.BaseFragment;
import com.example.nytimesarticleapp.viewmodel.ArticleDetailsViewModel;

public class ArticleDetailFragment extends BaseFragment<ArticleDetailsViewModel, FragmentArticleDetailsBinding> {
    @Override
    protected Class<ArticleDetailsViewModel> getViewModel() {
        return ArticleDetailsViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_article_details;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        if(null != args) {
            viewModel.setUrl(args.getString(Constants.ARTICLE_URL));
            viewModel.loadArticleDetails();
        }
        viewModel.getArticleEntityMutableLiveData().observe(this, articleEntity -> {
            if(null != articleEntity && null != args) {
                dataBinding.textTitle.setText(articleEntity.getTitle());
                dataBinding.textContent.setText(articleEntity.getContent());
                dataBinding.textPublishedDate.setText(args.getString(Constants.ARTICLE_PUBLISHED_DATE));
                dataBinding.loadingProgress.setVisibility(View.GONE);
            }
        });

        viewModel.getErrorMessageRecieved().observe(this, message ->{
            dataBinding.loadingProgress.setVisibility(View.GONE);
            dataBinding.textContent.setText(getActivity().getString(R.string.networkError));
        });
    }
}
