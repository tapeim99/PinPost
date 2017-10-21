package com.ndeveat.pinpost.Fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.koushikdutta.ion.Ion
import com.ndeveat.pinpost.Manager
import com.ndeveat.pinpost.Ui.Post.PostPreviewAdapter
import com.ndeveat.pinpost.Ui.Post.PostPreviewModel
import com.ndeveat.pinpost.R
import com.ndeveat.pinpost.Ui.Categories.SocialNetworkType
import kotlinx.android.synthetic.main.editor_image_contents.*
import kotlinx.android.synthetic.main.fragment_postlist.view.*
import kotlin.concurrent.thread

/**
 * Created by ndeveat on 2017. 9. 18..
 */

class PostviewFragment : Fragment() {
    var mLayoutManager: LinearLayoutManager? = null
    var mRecyclerView: RecyclerView? = null
    var mPostViewAdapter: PostPreviewAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater!!.inflate(R.layout.fragment_postlist, container, false)

        mPostViewAdapter = PostPreviewAdapter()
        mLayoutManager = LinearLayoutManager(context)
        mRecyclerView = rootView.post_preview_list
        mRecyclerView!!.setItemViewCacheSize(30)
        mRecyclerView!!.layoutManager = mLayoutManager
        mRecyclerView!!.adapter = mPostViewAdapter
        mRecyclerView!!.addItemDecoration(PostPreviewAdapter.PostPreviewDecoration())

        loadPost(0)

        return rootView
    }

    fun loadPost(page: Int) {
        Handler().postDelayed({
            mPostViewAdapter!!.updatePost()
            loadPost(page)
        }, 1500)
    }

    companion object {
        fun newInstance(): PostviewFragment {
            val fragment = PostviewFragment()
            return fragment
        }
    }
}