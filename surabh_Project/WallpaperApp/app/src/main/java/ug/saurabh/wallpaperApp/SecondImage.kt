package ug.saurabh.wallpaperApp

import android.app.WallpaperManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_second_image.*
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import java.io.InputStream
import java.net.URL


class SecondImage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_image)

        val image=intent.getStringExtra("image")

        Glide.with(this).load(image).into(TvlargeImage)

        TvSetImage.setOnClickListener {
            //var bitmap=BitmapFactory.decodeResource(resources,Integer.parseInt(image))

            var wallpaperManager=WallpaperManager.getInstance(applicationContext)

            val policy = ThreadPolicy.Builder()
                .permitAll().build()
            StrictMode.setThreadPolicy(policy)

            var ins: InputStream? = null

            try {
                ins = URL(image).openStream()
                wallpaperManager.setStream(ins)
            }catch (e:Exception){
                Log.d("umang","khali image hai")
            }

        }

    }

}