package com.example.onlineshop.activity

import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityVideoBinding

class VideoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVideoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoPath = Uri.parse("android.resource://com.example.onlineshop/${R.raw.video}")
        binding.videoView.setVideoURI(videoPath)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(binding.videoView)
        binding.videoView.setMediaController(mediaController)

        binding.button.setOnClickListener {
            if (binding.videoView.isPlaying) {
                binding.videoView.pause()
                binding.button.text = "Play"
            } else {
                binding.videoView.start()
                binding.button.text = "Pause"
            }
        }

        val handler = Handler(mainLooper)
        handler.postDelayed(object : Runnable {
            override fun run() {
                try {
                    val progress =
                        (binding.videoView.currentPosition.toDouble() / binding.videoView.duration.toDouble()) * 100
                    binding.text.text = "درصد پخش شده: ${progress.toInt()}%"

                } catch (e: Exception) {
                    Log.e("test", e.toString())

                }
                handler.postDelayed(this, 1000)
            }
        }, 0)

        binding.videoView.setOnPreparedListener{
            it.start()
        }
    }


}