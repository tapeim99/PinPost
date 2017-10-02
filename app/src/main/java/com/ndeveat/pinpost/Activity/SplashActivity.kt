package com.ndeveat.pinpost.Activity

import android.app.Activity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.ndeveat.pinpost.Categories.Category.CategoryModel
import com.ndeveat.pinpost.DataCenter
import com.ndeveat.pinpost.R
import com.ndeveat.pinpost.SocialNetworkType
import org.jetbrains.anko.intentFor
import kotlin.concurrent.thread

/*
* 기초 처리하는 부분
*
* 처음 시작하는 사람
* 이전에 시작하던 사람
* */

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // add social network
        DataCenter.instance.SocialNetworkServices.put(SocialNetworkType.Facebook, 1)
        DataCenter.instance.SocialNetworkServices.put(SocialNetworkType.Tstory, 5)
        DataCenter.instance.SocialNetworkServices.put(SocialNetworkType.Twitter, 5)

        // add category
        addSocialNetworkCount()


        // TODO
        // 회원 가입 및 로그인 추가
        // 회원가입이 되어있다면 넘어간다.
        // 앱의 로컬 데이터 베이스에 정보들을 저장한다.
        startActivity(intentFor<MainActivity>())

        finish()
    }

    fun addSocialNetworkCount() {
        DataCenter.instance.Categories.add(
                CategoryModel(
                        SocialNetworkType.Facebook,
                        ContextCompat.getDrawable(this@SplashActivity, R.drawable.sns_facebook_00001),
                        ContextCompat.getColor(this@SplashActivity, R.color.snsFacebook)))
        DataCenter.instance.Categories.add(
                CategoryModel(
                        SocialNetworkType.Tstory,
                        ContextCompat.getDrawable(this@SplashActivity, R.drawable.sns_tstory_00001),
                        ContextCompat.getColor(this@SplashActivity, R.color.snsTstory)))
        DataCenter.instance.Categories.add(
                CategoryModel(
                        SocialNetworkType.Twitter,
                        ContextCompat.getDrawable(this@SplashActivity, R.drawable.sns_twitter_00001),
                        ContextCompat.getColor(this@SplashActivity, R.color.snsTwitter)))
    }
}