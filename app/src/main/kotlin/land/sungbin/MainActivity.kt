package land.sungbin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import land.sungbin.databinding.ActivityMainBinding
import land.sungbin.keyboardbeautify.keyboardBeautify

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.conversationRecyclerview.adapter = ConversationAdapter()

        keyboardBeautify(
            rootView = binding.root,
            inputLayout = binding.messageHolder,
            otherView = binding.conversationRecyclerview,
            editText = binding.messageEdittext
        )
    }
}
