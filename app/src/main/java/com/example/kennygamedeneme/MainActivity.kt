package com.example.kennygamedeneme

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import com.example.kennygamedeneme.databinding.ActivityMainBinding
import kotlinx.coroutines.Runnable
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var kennyArray = ArrayList<ImageView>()
    var score = 0
    var highScore = 0
    var runnable = Runnable{}
    var handler = Handler(Looper.getMainLooper())

    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.tvScore.text = score.toString()
        binding.tvHighScore.text = highScore.toString()
        kennyArray.add(binding.kenny1)
        kennyArray.add(binding.kenny2)
        kennyArray.add(binding.kenny3)
        kennyArray.add(binding.kenny4)
        kennyArray.add(binding.kenny5)
        kennyArray.add(binding.kenny6)
        kennyArray.add(binding.kenny7)
        kennyArray.add(binding.kenny8)
        kennyArray.add(binding.kenny9)

        hideKenny()
    }
    fun hideKenny (){
        runnable = object :Runnable{
            override fun run() {
                for (i in kennyArray){
                    i.visibility = View.INVISIBLE
                }
                var random = java.util.Random()
                var index = random.nextInt(9)
                kennyArray[index].visibility = View.VISIBLE

                handler.postDelayed(runnable , 500)
            }
        }
        handler.post(runnable)
    }
    fun clicked(v : View){

        score += 1
        binding.tvScore.text ="$score"
    }


}