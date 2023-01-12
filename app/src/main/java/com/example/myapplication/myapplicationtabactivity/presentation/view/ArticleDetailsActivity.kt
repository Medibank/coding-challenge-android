package com.example.myapplication.myapplicationtabactivity.presentation.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.myapplication.myapplicationtabactivity.R
import com.example.myapplication.myapplicationtabactivity.data.model.Article
import com.example.myapplication.myapplicationtabactivity.databinding.ActivityArticleDetailsBinding
import com.example.myapplication.myapplicationtabactivity.presentation.Util.Companion.KEY_ARTICLE
import com.example.myapplication.myapplicationtabactivity.presentation.Util.Companion.KEY_DB_SAVE_OPERATION
import com.example.myapplication.myapplicationtabactivity.presentation.viewmodel.ArticleDetailsViewModel
import com.example.myapplication.myapplicationtabactivity.presentation.viewmodel.MyViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ArticleDetailsActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MyViewModelFactory
    lateinit var viewModel: ArticleDetailsViewModel

    private lateinit var binding: ActivityArticleDetailsBinding

    private var mMsgMenu: Menu? = null

    private lateinit var selectedArticle: Article
    private var dbSaveAction: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_article_details)

        selectedArticle = intent.getSerializableExtra(KEY_ARTICLE) as Article
        dbSaveAction = intent.getBooleanExtra(KEY_DB_SAVE_OPERATION, false)

        (this as AppCompatActivity).supportActionBar?.apply {
            title = selectedArticle.title
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        binding.apply {
            tvTitle.text = selectedArticle.title
            tvDescription.text = selectedArticle.description
            tvAuthor.text = selectedArticle.author

            Glide.with(ivArticleImage.context).
            load(selectedArticle.urlToImage).
            into(ivArticleImage)
        }

        viewModel = ViewModelProvider(this,factory).get(ArticleDetailsViewModel::class.java)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> onBackPressed()
            R.id.save_article -> {
                if(dbSaveAction) {
                    viewModel.saveArticle(selectedArticle)
                    Toast.makeText(this, resources.getString(R.string.article_saved_message), Toast.LENGTH_SHORT).show()
                } else {
                    viewModel.deleteArticle(selectedArticle)
                    Toast.makeText(this, resources.getString(R.string.article_deleted_message), Toast.LENGTH_SHORT).show()
                }
                onBackPressed()
            }
            R.id.view_article -> {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(selectedArticle.url)))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        mMsgMenu = menu

        val itemArticleAction = menu!!.findItem(R.id.save_article)
        if (itemArticleAction != null) {
            if (dbSaveAction) {
                itemArticleAction.title = resources.getString(R.string.save_article)
            } else {
                itemArticleAction.title = resources.getString(R.string.delete_article)
            }
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_article_details, menu)
        return super.onCreateOptionsMenu(menu)
    }
}