package com.example.onlineshop.activity

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityVideoBinding

class VideoActivity : AppCompatActivity() {
    private lateinit var binding:ActivityVideoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoPath = Uri.parse("android.resource://com.example.onlineshop/${R.raw.video}")
        binding.video.setVideoURI(videoPath)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(binding.video)
        binding.video.setMediaController(mediaController)

        binding.button.setOnClickListener {
            if (binding.video.isPlaying) {
                binding.video.pause()
                binding.button.text = "Play"
            } else {
                binding.video.start()
                binding.button.text = "Pause"
            }
        }

        binding.video.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.setOnBufferingUpdateListener { mediaPlayer, percent ->
                Log.d("videoTestDarsad", "progress")
                val progress = (mediaPlayer.currentPosition.toDouble() / mediaPlayer.duration.toDouble()) * 100
                binding.text.text = "درصد پخش شده: ${progress.toInt()}%"
                Log.d("videoTestDdarsad", "progress : $progress")
            }
        }
    }


}